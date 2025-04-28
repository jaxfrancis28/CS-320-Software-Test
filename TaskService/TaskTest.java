package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;

class TaskTest {
	
	private String id, name, description;
	private String tooLongId, tooLongName, tooLongDescription;
	

	@BeforeEach
	void setUp() {
		id = "1234567890";
		name = "This is Qwenty Chars";
		description = "The task object shall have a required description.";
		tooLongId = "111222333444555666777888999";
		tooLongName = "This is way to long to be a task name";
		tooLongDescription = "The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null";
	}
	
	@Test
	void getTaskIdTest() {
		Task task = new Task(id);
		Assertions.assertEquals(id, task.getTask());
	}
	@Test
	void getName() {
		Task task = new Task(id, name);
		Assertions.assertEquals(name, task.getName());
	}
	
	@Test
	void getDescription() {
		Task task = new Task(id, name, description);
		Assertions.assertEquals(description, task.getDescription());
	}
	
	@Test
	void getNameTest() {
		Task task = new Task(id, name, description);
		Assertions.assertEquals(name, task.getName());
	}
	
	@Test
	void getDescriptionTest() {
		Task task = new Task(id, name, description);
		Assertions.assertEquals(description, task.getDescription());
	}
	
	@Test
	void setTooLongIdTest() {
		Task task = new Task(id, name, description);;
		Assertions.assertThrows(IllegalArgumentException.class,()-> task.setId(tooLongId));
	}
	
	@Test
	void setTooLongNameTest() {
		Task task = new Task(id, name, description);;
		Assertions.assertThrows(IllegalArgumentException.class,()-> task.setName(tooLongName));
	}
	
	@Test
	void setTooLongDescriptionTest() {
		Task task = new Task(id, name, description);;
		Assertions.assertThrows(IllegalArgumentException.class,()-> task.setDescription(tooLongDescription));
	}
	@Test
	void TaskIdNullTest(){
		Assertions.assertThrows(IllegalArgumentException.class,()-> new Task(null));
	}
	
	@Test
	void TestNameNullTest() {
		Task task = new Task(id, name, description);;
		Assertions.assertThrows(IllegalArgumentException.class,()-> task.setName(null));
	}
	@Test
	void TaskDescriptionNullTest() {
		Task task = new Task(id, name, description);;
		Assertions.assertThrows(IllegalArgumentException.class,()-> task.setDescription(null));
	}
}
