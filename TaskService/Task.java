package taskService;



public class Task {
	
	private String taskId;
	private String name;
	private String description;
	private String taskDescription;
	
	public Task(String string, String name2){
		taskId = "INITIAL";
		name = "INITIAL";
		description = "INITIAL DESCRIPTION";
	}
	
	public Task(String id, String name2, String description2){
		checkTaskId(taskId);
		name = "INITIAL";
		description = "INITIAL DESCRIPTION";
	}

	public Task(String taskId){
		checkTaskId(taskId);
		setName(name);
		setDescription(description);
	}
	
	public final String getTask() {return taskId;}
	public final String getName() {return name;}
	
	public void setName(String name){
		if (name == null || name.length() > 20){
			throw new IllegalArgumentException("Invalid entry"); 
		}else {
			this.name = name;
			}
		}
	public final String getDescription() {return description;}
	public void setDescription(String teskDescription) {
		if (teskDescription == null || teskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid entry, must not be blank and atleast 50 characters.");
		}else {
			this.description = taskDescription;
		}
	}
	private void checkTaskId(String taskId) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Error: Task ID is null or longer than 10 characters");
		}else {
			this.taskId = taskId;
		}
	}

	public Object setId(String tooLongId) {
		// TODO Auto-generated method stub
		return null;
	}

}