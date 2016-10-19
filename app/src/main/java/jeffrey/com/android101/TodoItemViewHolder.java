package jeffrey.com.android101;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TodoItemViewHolder extends RecyclerView.ViewHolder {
    public TextView taskTitle;
    public Button button;

    public TodoItemViewHolder(View itemView) {
        super(itemView);
        taskTitle = (TextView) itemView.findViewById(R.id.task_title);
        button = (Button) itemView.findViewById(R.id.button);
    }
}
