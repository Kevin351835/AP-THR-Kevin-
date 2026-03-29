import java.util.*;

public class THR2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Masukkan inputan anda: ");
        
        if (!sc.hasNextLine()) return;
        String inputOwner = sc.nextLine().trim();
        
        System.out.print("Daftar Suspect: ");
        if (!sc.hasNextLine()) return;
        String barisNama = sc.nextLine();
        String[] potongNama = barisNama.split(" ");

        Queue<String> antrian = new LinkedList<>();
        for (String n : potongNama) {
            if (!n.isEmpty()) antrian.add(n);
        }

        Stand s = null;
        if (inputOwner.equalsIgnoreCase("Josuke")) s = new CrazyDiamond();
        else if (inputOwner.equalsIgnoreCase("Jotaro")) s = new StarPlatinum();
        else if (inputOwner.equalsIgnoreCase("Okuyasu")) s = new TheHand();
        else if (inputOwner.equalsIgnoreCase("Koichi")) s = new Echoes();
        else if (inputOwner.equalsIgnoreCase("Rohan")) s = new HeavensDoor();

        Stack<String> tumpukan = new Stack<>();

        System.out.println("\nHasil Pemeriksaan");
        
        if (s != null) {
            while (!antrian.isEmpty()) {
                String orang = antrian.poll();
                if (s.cek(orang)) {
                    tumpukan.push(orang);
                }
            }
            
            if (tumpukan.isEmpty()) {
                System.out.println(inputOwner + " exposed no one.");
            } else {
                System.out.println(inputOwner + " exposed someone!");
            }
            System.out.println("Arrested: " + tumpukan);
            
        } else {
            System.out.println(inputOwner + " exposed no one.");
            System.out.println("Arrested: []");
        }
        
        sc.close();
    }
}

abstract class Stand {
    String pemilik;
    Stand(String pemilik) { this.pemilik = pemilik; }
    public abstract boolean cek(String nama);
}

class CrazyDiamond extends Stand {
    CrazyDiamond() { super("Josuke"); }
    public boolean cek(String s) {
        return s.toLowerCase().startsWith("k");
    }
}

class StarPlatinum extends Stand {
    StarPlatinum() { super("Jotaro"); }
    public boolean cek(String s) {
        return s.length() <= 3;
    }
}

class TheHand extends Stand {
    TheHand() { super("Okuyasu"); }
    public boolean cek(String s) {
        String teks = s.toLowerCase();
        for (int i = 0; i < teks.length() - 1; i++) {
            if (teks.charAt(i) == teks.charAt(i + 1)) return true;
        }
        return false;
    }
}

class Echoes extends Stand {
    Echoes() { super("Koichi"); }
    public boolean cek(String s) {
        int v = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) v++;
        }
        return v >= 3;
    }
}

class HeavensDoor extends Stand {
    HeavensDoor() { super("Rohan"); }
    public boolean cek(String s) {
        String t = s.toLowerCase();
        return t.length() > 1 && t.equals(new StringBuilder(t).reverse().toString());
    }
}