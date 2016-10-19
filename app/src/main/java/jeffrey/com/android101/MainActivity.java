package jeffrey.com.android101;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import jeffrey.com.android101.db.TodoItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private TodoItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set views
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        // create toolbar
        toolbar.setTitle(R.string.app_name);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_add_task:
                        showAddTaskDialog();
                        return true;
                }
                return false;
            }
        });

        // create adapter
        adapter = new TodoItemAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // refresh UI
        updateUI();
    }

    private void showAddTaskDialog() {
        final EditText taskEditText = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
            .setTitle("Add a new task")
            .setMessage("What do you want to do next?")
            .setView(taskEditText)
            .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.d(TAG, "Adding to new todo item, " + String.valueOf(taskEditText.getText()));
                    TodoItem todoItem = new TodoItem();
                    todoItem.name = String.valueOf(taskEditText.getText());
                    todoItem.save();
                    updateUI();
                }
            })
            .setNegativeButton("Cancel", null)
            .create();
        dialog.show();
    }

    private void updateUI() {
        Log.d(TAG, "Updating UI");
        List<TodoItem> todoItemList = TodoItem.getAll();
        adapter.setTodoItems(todoItemList);
        adapter.notifyDataSetChanged();
    }
}
