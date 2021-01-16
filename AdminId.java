
public class AdminId implements EditUser<AdminId> { // Generic type E is replaced by the concrete type AdminId
	private String name;
	private String username;
	private String password;
	
	public AdminId(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public AdminId() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void changeUsername(String username) {
		this.username = username;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	// Polymorphism
	public String name(Object o) { // Object is the root class of all class. So instance of any class can be passed here. The passed instance will be casted to Object type implicitly.
		AdminId id = null;
		if(o instanceof AdminId) { // We want only instance of type AdminId as passed to Object o. If any instance of other class is passed the condition will be false.
			id = (AdminId)o; // If an instance of AdminId is passed to Object o it will be casted to AdminId explicitly. Because Object is the super class here.
		}
		return id.name;
	}
	
	// Generics
	public String name2(AdminId id) { // Generic type E is replaced by the concrete type AdminId
		return id.name;
	}
}
