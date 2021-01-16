import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Owner extends Manager {
	private int phone;

	public Owner(String name, int age, String gender) {
		super(name, age, gender);
	}
	
	public Owner(String name, int age, String gender, int phone) {
		super(name, age, gender);
		this.phone = phone;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public int phoneNumber(int a) {
		return a;
	}

	public String toString() {
		return "Owner [phone=" + phone + ", name=" + getName() + ", age=" + getAge() + ", gender=" + getGender() + "]";
	}	
}
