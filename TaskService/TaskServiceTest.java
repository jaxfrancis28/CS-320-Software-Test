package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import taskService.TaskService;

class TaskServiceTest {

		
		private String id, name, description;
		private String tooLongId, tooLongName, tooLongDescription;
		

		@BeforeEach
		void setUp() {
			id = "1234567890";
			name = "This is Qwenty Chars";
			description = "The task object shall have a required description.";
			tooLongId = "111222333444555666777888999";
			tooLongDescription = "The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null";
		}
		
		@Test
		void newTaskTest1() {
			TaskService service = new TaskService();
			service.newTask(name);
			Assertions.assertNotNull(service.getTaskList().get(0).getName());
			Assertions.assertNotEquals("INITIAL", service.getTaskList().get(0).getName());
		}
		
		@Test
		void newTaskDescriptionTest1() {
			TaskService service = new TaskService();
			service.newTask(name);
			Assertions.assertNotNull(service.getTaskList().get(0).getDescription());
			Assertions.assertNotEquals("INITIAL", service.getTaskList().get(0).getDescription());
		}
		
		@Test
		void newTaskTest() {
			TaskService service = new TaskService();
			service.newTask(name);
			Assertions.assertNotNull(service.getTaskList().get(0).getName());
			Assertions.assertNotEquals("INITIAL", service.getTaskList().get(0).getName());
		}
		
		@Test
		void newTaskTooLongNameTest() {
			TaskService service = new TaskService();
			service.newTask(name);
			Assertions.assertThrows(IllegalArgumentException.class,()->service.newTask(tooLongName));
		}
		
		@Test
		void newTaskTooLongDescriptionTest() {
			TaskService service = new TaskService();
			assertThrows(IllegalArgumentException.class,() ->service.newTask(name,tooLongDescription));
			
			}
		
		@Test
		void newTaskNameNullTest() {
			TaskService service = new TaskService();
			assertThrows(IllegalArgumentException.class, () -> service.newTask(name, tooLongId));
		}
		
		@Test
		void newTaskDescriptionNullTest() {
			TaskService service = new TaskService();
			assertThrows(IllegalArgumentException.class,() -> service.newTask(name, description));
		}

		@Test
		void deleteTaskTest() throws Exception {
			TaskService service = new TaskService();
			service.newTask();
			assertEquals(1, service.getTaskList().size());
			service.deleteTask(service.getTaskList().get(0).getTask());
		}
		
		@Test
		void deleteTaskNotFoundTest() throws Exception {
			TaskService service = new TaskService();
			service.newTask();
			assertEquals(1, service.getTaskList().size());
			assertThrows(Exception.class, () -> service.deleteTask(id));
			assertEquals(1, service.getTaskList().size());
		}
		
		@Test
		void updateNameTest() throws Exception {
			TaskService service = new TaskService();
			service.updtateName(service.getTaskList().get(0).getTask(), name);
			assertEquals(name, service.getTaskList().get(0).getName());
		}
		
		@Test
		void updateDescriptionTest() throws Exception {
			TaskService service = new TaskService();
			service.newTask();
			service.updtateDescription(service.getTaskList().get(0).getTask(), name);
			assertEquals(description, service.getTaskList().get(0).getDescription());
		}
		
		@Test
		void updateNameNotFoundTest() throws Exception {
			TaskService service = new TaskService();
			service.newTask();
			assertThrows(Exception.class, () -> service.updtateName(id, name));
		}
		
		@Test
		void updateDescriptionNotFoundTest() throws Exception {
			TaskService service = new TaskService();
			service.newTask();
			assertThrows(Exception.class, () -> service.updtateDescription(id, description));
		}
		
		@RepeatedTest(4)
		void UuidTest( ) {
			TaskService service = new TaskService();
			service.newTask();
			service.newTask();
			service.newTask();
			assertEquals(3, service.getTaskList().size());
			assertNotEquals(service.getTaskList().get(0).getTask(), service.getTaskList().get(1).getTask());
			assertNotEquals(service.getTaskList().get(0).getTask(), service.getTaskList().get(2).getTask());
			assertNotEquals(service.getTaskList().get(1).getTask(), service.getTaskList().get(2).getTask());
		}
}
