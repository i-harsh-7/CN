import java.util.*;

public class ErrorDet {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Choose method: 1. Simple Parity Check 2. Two-Dim Parity Check 3. Checksum 4. Cyclic Redundancy Check");
        
        int ch;
        do {
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1: simpleParitySender(); break;
                case 2: simpleParityRec(); break;
                case 3: tdpcSender(); break;
                case 4: tdpcRec(); break;
                default: System.out.println("Invalid choice.");
            }
        } while (ch > 0 && ch < 5);
    }

    static void simpleParitySender() {
        String str = sc.next();
        System.out.println("Data at sender: " + str);
        long cnt = str.chars().filter(ch -> ch == '1').count();
        System.out.println("Encoded: " + str + (cnt % 2 == 0 ? "0" : "1"));
    }

    static void simpleParityRec() {
        String str = sc.next();
        long cnt = str.chars().filter(ch -> ch == '1').count();
        System.out.println(cnt % 2 == 0 ? "No Error" : "Error found");
    }

    static void tdpcSender() {
        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt(), c = sc.nextInt();
        List<List<Character>> bits = new ArrayList<>();
        for (int i = 0; i <= r; i++) bits.add(new ArrayList<>());

        System.out.println("Enter bit stream:");
        for (int i = 0; i < r; i++) {
            int cnt = 0;
            for (int j = 0; j < c; j++) {
                char ch = sc.next().charAt(0);
                bits.get(i).add(ch);
                if (ch == '1') cnt++;
            }
            bits.get(i).add(cnt % 2 == 0 ? '0' : '1');
        }

        for (int i = 0; i < c; i++) {
            int cnt = 0;
            for (int j = 0; j < r; j++) {
                if (bits.get(j).get(i) == '1') cnt++;
            }
            bits.get(r).add(cnt % 2 == 0 ? '0' : '1');
        }

        System.out.println("\nEncoded data:");
        bits.forEach(row -> row.forEach(b -> System.out.print(b + " ")));
    }

    static void tdpcRec() {
        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt(), c = sc.nextInt();
        List<List<Character>> bits = new ArrayList<>();
        for (int i = 0; i <= r; i++) bits.add(new ArrayList<>());
        
        System.out.println("Enter received data:");
        int row = -1, col = -1;

        for (int i = 0; i <= r; i++) {
            int cnt = (int) bits.get(i).stream().filter(ch -> ch == '1').count();
            if (cnt % 2 != 0) row = i;
        }
        
        for (int i = 0; i <= c; i++) {
            int cnt = 0;
            for (int j = 0; j <= r; j++) {
                if (bits.get(j).get(i) == '1') cnt++;
            }
            if (cnt % 2 != 0) col = i;
        }
        
        if (row != -1) {
            System.out.println("Error at: Row " + row + " Col " + col);
        } else {
            System.out.println("No error found.");
        }
    }
}

