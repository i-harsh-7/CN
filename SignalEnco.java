import java.util.*;

public class SignalEnco{
	public static void main(String abc[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the input stream : ");
		String str = sc.next();
		
		int n = str.length();
		
		System.out.println("Enter the choice for signal encoding technique: \n1. NRZI \n2. NRZL \n3. Bipolar \n4. PseudoTernary \n5. Manchester \n6. Differential Manchester");
		
		int ch = sc.nextInt();
		
		switch(ch){
			case 1:
				nrzi(str, n);
				break;
				
			case 2:
				nrzl(str, n);
				break;
				
			case 3:
				bipolar(str, n);
				break;
				
			case 4:
				pseudoTernary(str, n);
				break;
				
			case 5:
				manchester(str, n);
				break;
				
			case 6:
				diffManchester(str, n);
				break;
				
			default:
				System.out.println("Choose the correct option ");
		
		}
		sc.close();
	
	}
	
	public static void nrzi(String str, int n){
		int noOfTransition = 0;
		
		for(int i=1; i<n; i++){
			if(str.charAt(i) != str.charAt(i-1)) {
				noOfTransition++;
			}	
		
		}
		
		System.out.println("Total Number of transition : " + noOfTransition);
	}
	
	public static void nrzl(String str, int n){
		int noOfTransition = 0;
		
		for(int i=1; i<n; i++){
			if(str.charAt(i) == '1') {
				noOfTransition++;
			}	
		
		}
		
		System.out.println("Total Number of transition : " + noOfTransition);
	}
	
	public static void bipolar(String str, int n){
		int noOfTransition = 0;
		
		for(int i=1; i<n; i++){
			if(str.charAt(i) == '0' && str.charAt(i-1) == '0') continue;
			else noOfTransition++;	
		}
		
		System.out.println("Total Number of transition : " + noOfTransition);
	}
	
	public static void pseudoTernary(String str, int n){
		int noOfTransition = 0;
		
		for(int i=1; i<n; i++){
			if(str.charAt(i) == '1' && str.charAt(i-1) == '1') continue;	
			else	noOfTransition++;
		}
		
		System.out.println("Total Number of transition : " + noOfTransition);
	}
	
	public static void manchester(String str, int n){
		int noOfTransition = n;
		
		for(int i=1; i<n; i++){
			if(str.charAt(i) == str.charAt(i-1)) noOfTransition++;
		}
		
		System.out.println("Total Number of transition : " + noOfTransition);
	}
	
	public static void diffManchester(String str, int n){
		int noOfTransition = n;
		
		for(int i=1; i<n; i++){
			if(str.charAt(i) == '0') noOfTransition++;
		}
		
		System.out.println("Total Number of transition : " + noOfTransition);
	}
	
	

}


