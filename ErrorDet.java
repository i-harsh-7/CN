import java.util.*;


public class ErrorDet{

	static Scanner sc = new Scanner(System.in);

	public static void main(String abcd[]){
		System.out.println("Choose the method : \n1. Simple Parity Check \n2. Two - Dim Parity Check \n3. Checksum \n4. Cyclic Redundancy Check");
		
		int ch = 0;

		List<List<Character>> encode = new ArrayList<>();
		
		do{
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			
			switch(ch){
				case 1: 
					simpleParitySender();
					break;
					
				case 2 : 
					simpleParityRec();
					break;
				
				case 3 : 
					tdpcSender();
					break;
					
				case 4 : 
					tdpcRec();
					break;
				
				default : 
					System.out.println("Enter the right choice ...");
					break;
		
			}
		}while(ch>0 && ch<9);
	}
	
	static void simpleParitySender(){
		String str = sc.next();
		int n = str.length();
		
		System.out.println("Data at sender side : " + str);
		int cnt = 0;
		for(char ch : str.toCharArray()){
			if(ch == '1') cnt++;
		}
		
		if(cnt%2 != 0) str += "1";
		else str += "0";
		
		System.out.println("After the encoding : " + str);
	}
	
	static void simpleParityRec(){
		String str = sc.next();
		int n = str.length();
		
		System.out.println("Data Received at receiver side : " + str);
		int cnt = 0;
		for(char ch : str.toCharArray()){
			if(ch == '1') cnt++;
		}
		
		if(cnt%2 == 0) System.out.println("No Error found");
		else System.out.println("Error found");
	}
	
	static void tdpcSender(){
		System.out.print("Enter the number of rows and columns : ");
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		List<List<Character>> bits = new ArrayList<>();
		int k = 0, cnt = 0;
		
		for(int i=0; i<r+1; i++){
			bits.add(new ArrayList<>());
		}
		
		System.out.println("Enter the bit stream at sender side: ");
		
		for(int i=0; i<r; i++){
			cnt = 0;
			for(int j=0; j<c; j++){
				char ch = sc.next().charAt(0);
				bits.get(i).add(ch);
				if(ch == '1') cnt++;
			}
			
			if(cnt %2 != 0) bits.get(i).add('1');
			else bits.get(i).add('0');
		}
		
		for(int i=0; i<=c; i++){
			cnt = 0;
			for(int j=0; j<r; j++){
				if(bits.get(j).get(i) == '1') cnt++;
			}
			
			if(cnt %2 != 0) bits.get(r).add('1');
			else bits.get(r).add('0');
		}

		System.out.println("\nData after encoding : ");
		
		for(int i=0; i<=r; i++){
			for(int j=0; j<=c; j++){
				System.out.print(bits.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	static void tdpcRec(){
		System.out.print("Enter the number of rows and columns : ");
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		List<List<Character>> bits = new ArrayList<>();
		int k = 0, cnt = 0;
		
		for(int i=0; i<r+1; i++){
			bits.add(new ArrayList<>());
		}
		
		System.out.println("Enter the bit stream at receiver side : ");
		
		int row = -1, col = -1;
		
		for(int i=0; i<r+1; i++){
			cnt = 0;
			for(int j=0; j<c+1; j++){
				char ch = sc.next().charAt(0);
				bits.get(i).add(ch);
				if(ch == '1') cnt++;
			}
			
			if(cnt%2 != 0) row = i;
		}
		for(int i=0; i<c+1; i++){
			cnt = 0;
			for(int j=0; j<r+1; j++){
				if(bits.get(j).get(i) == '1') cnt++;
			}
			
			if(cnt%2 != 0) col = i;
		}
		if(r != -1){
			System.out.println("Error found at : Row = " + row + " : Col = " + col);
		}
		else System.out.println("No Error Found");
		
	}
}









