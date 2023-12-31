package net.shipment.web;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shipment.DAO.ShipDao;
import shipment.DAO.ShipImpDao;

//import net.javaguides.todoapp.dao.TodoDao;
//import net.javaguides.todoapp.dao.TodoDaoImpl;
//import net.javaguides.todoapp.model.Todo;

public class ShipController extends HttpServlet{
	 private static final long serialVersionUID = 1 ;
	    private ShipDao todoDAO;

	    public void init() {
	        ShipDao= new ShipImpDao();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        doGet(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        String action = request.getServletPath();
}
	    try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertTodo(request, response);
                    break;
                case "/delete":
                    deleteTodo(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateTodo(request, response);
                    break;
                case "/list":
                    listTodo(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
        	  throw new ServletException(ex);
        }
    private void listTodo(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Todo > listTodo = todoDAO.selectAllTodos();
        request.setAttribute("listTodo", listTodo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	        int id = Integer.parseInt(request.getParameter("id"));
    	        Todo existingTodo = todoDAO.selectTodo(id);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
    	        request.setAttribute("todo", existingTodo);
    	        dispatcher.forward(request, response);
        }
}