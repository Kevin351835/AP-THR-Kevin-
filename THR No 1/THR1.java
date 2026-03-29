import java.util.Scanner;
import java.util.Stack;

abstract class DetectiveCase {
    public abstract String[] solve(String input);
}

class ClairvoyanceStack extends DetectiveCase {

    @Override
    public String[] solve(String input) {
        if (input == null || input.isEmpty()) {
            return new String[]{"Input tidak boleh kosong!"};
        }

        String[] words = input.split(" ");
        
        if (words.length < 10) {
            return new String[]{"Harus minimal 10 kata."};
        }

        String[][] pairs = new String[5][2];
        for (int i = 0; i < 5; i++) {
            pairs[i][0] = words[i * 2];
            pairs[i][1] = words[i * 2 + 1];
        }

        Stack<String> s = new Stack<>();
        int[] urutan = {3, 1, 0, 2, 4};
        
        for (int i = 0; i < urutan.length; i++) {
            int idx = urutan[i];
            s.push(pairs[idx][0]);
            s.push(pairs[idx][1]);
        }

        String[] hasil = new String[s.size()];
        for (int i = 0; i < hasil.length; i++) {
            hasil[i] = s.get(i);
        }
        
        return hasil;
    }
}

public class THR1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan 10 kata/angka: ");
        
        if (sc.hasNextLine()) {
            String inputUser = sc.nextLine();
            
            DetectiveCase dc = new ClairvoyanceStack();
            String[] result = dc.solve(inputUser);
            
            System.out.println("Hasil Analisis Kasus");
            System.out.print("[");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i == result.length - 1 ? "" : ", "));
            }
            System.out.println("]");
        }
        
        sc.close(); 
    }
}