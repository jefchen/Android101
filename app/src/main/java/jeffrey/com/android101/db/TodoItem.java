package jeffrey.com.android101.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "Tasks")
public class TodoItem extends Model {
    @Column(name = "Name")
    public String name;

    public static List<TodoItem> getAll() {
        return new Select()
            .from(TodoItem.class)
            .execute();
    }
}