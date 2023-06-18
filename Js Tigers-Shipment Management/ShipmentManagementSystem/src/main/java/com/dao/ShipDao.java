package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Ship;



public interface ShipDao {

	void insertTodo(Ship todo) throws SQLException;

	Ship selectTodo(long todoId);

	List<Ship> selectAllTodos();

	boolean deleteTodo(int id) throws SQLException;

	boolean updateTodo(Ship todo) throws SQLException;

}