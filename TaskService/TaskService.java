package taskService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
	
	private final List<Task> taskList = new ArrayList<>();
	
	private String newUniqueId() {
		return UUID.randomUUID().toString().substring(
				0, Math.min(toString().length(), 10));
	}
	
	private Task searchForTask(String id) throws Exception{
		int index = 0;
		while(index < taskList.size()) {
			if(id.equals(taskList.get(index).getTask())) {
				return taskList.get(index);
			}
			index++;
		}
		throw new Exception("No existing task");
	}
	public void newTask() {
		Task task = new Task(newUniqueId());
		taskList.add(task);
	}
	
	public void newTask(String name) {
		Task task = new Task(newUniqueId(), name);
		taskList.add(task);
	}
	public void newTask(String name, String description) {
		Task task = new Task(newUniqueId(), name, description);
		taskList.add(task);
		}
	public void deleteTask(String id) throws Exception {
		taskList.remove(searchForTask(id));
	}
	
	public void updtateName(String id, String name) throws Exception {
		searchForTask(id).setName(name);
	}
	
	public void updtateDescription(String id, String name) 
			throws Exception {
		searchForTask(id).setDescription(id);
	}
	
	public List<Task> getTaskList(){return taskList;}

}
