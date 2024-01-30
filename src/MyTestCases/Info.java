package MyTestCases;

import java.util.Random;

public class Info {
	
	Random rand = new Random();
	
	int randomIndex = rand.nextInt(10);
	int randomEmailID = rand.nextInt(9999);
	
	String [] FirstNames = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack"};
	String [] LastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
	String CommonPassword = "Omar$1998";
	String EmailID = FirstNames[randomIndex]+LastNames[randomIndex]+randomEmailID+"@"+"GMail.com";

}
