
public class SellerId implements EditUser<SellerId> { // Generic type E is replaced by the concrete type SellerId
	private String name;
	private String username;
	private String password;
	
	public SellerId() {
		
	}
	
	public SellerId(String username, String password) {
		this.username = username;
		this.password = password;
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
		SellerId id = null;
		if(o instanceof SellerId) { // We want only instance of type SellerId as passed to Object o. If any instance of other class is passed the condition will be false.
			id = (SellerId)o; // If an instance of AdminId is passed to Object o it will be casted to AdminId explicitly. Because Object is the super class here.
		}
		return id.name;
	}
	
	// Generics
	public String name2(SellerId id) { // Generic type E is replaced by the concrete type SellerId
		return id.name;
	}
}