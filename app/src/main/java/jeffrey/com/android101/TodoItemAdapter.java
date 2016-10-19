package jeffrey.com.android101;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jeffrey.com.android101.db.TodoItem;

import java.util.List;

public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemViewHolder> {
    private List<TodoItem> todoItems;

    public void setTodoItems(@NonNull List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @Override
    public TodoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.item_todo, parent, false);
        return new TodoItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TodoItemViewHolder holder, int position) {
        final TodoItem todoItem = todoItems.get(position);
        holder.taskTitle.setText(todoItem.name);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoItem.delete();
                todoItems.remove(todoItem);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }
}
