package Jdbc_Package;
import java.util.*;


public class Simple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch = 0;
		do {
			
			Scanner sc = new Scanner(System.in);
			Student std = new Student();
			System.out.println("1.Insert 2.Update 3.Delete 4.View");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			switch(ch) {
			
			case 1:
				try {
					std.Insert();
					} 
					catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					break;
			
			case 2:
				try {
					std.Update();
					} 
					catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					break;
			
			case 3: 
				try {
					std.Delete();
					} 
					catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					break;
			
			case 4: 
				try {
					std.View();
					} 
					catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					break;
			
			
			}
			
		}while(ch!=5);
		

	}

}
