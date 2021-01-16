
public interface EditUser<E> { // Generic interface
	public void changeUsername(String a);
	public void changePassword(String b);
	public String name(Object o);
	public String name2(E o); // Generic method
}
