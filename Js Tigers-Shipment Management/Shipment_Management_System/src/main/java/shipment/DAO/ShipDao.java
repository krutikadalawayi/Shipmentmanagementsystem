package shipment.DAO;

import java.sql.SQLException;
import java.util.List;

//import net.javaguides.todoapp.model.Todo;

public class ShipDao {
	public interface TodoDao {

		 void insertTodo(Todo todo) throws SQLException;

		 Todo selectTodo(long todoId);

		 List<Todo> selectAllTodos();

		 boolean deleteTodo(int id) throws SQLException;

		 boolean updateTodo(Todo todo) throws SQLException;

		}
}
