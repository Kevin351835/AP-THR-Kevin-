import java.util.Scanner; 

public class THR3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        System.out.println("Masukkan inputan anda");

        System.out.print("Masukkan nama Food: ");
        String n1 = input.nextLine();
        System.out.print("Masukkan harga Food: ");
        int p1 = input.nextInt();
        input.nextLine(); 

        System.out.print("Masukkan nama Regular Menu: ");
        String n2 = input.nextLine();
        System.out.print("Masukkan harga Regular Menu: ");
        int p2 = input.nextInt();
        input.nextLine(); 

        System.out.print("Masukkan nama Special Menu: ");
        String n3 = input.nextLine();
        System.out.print("Masukkan harga Special Menu: ");
        int p3 = input.nextInt();

        Food menu1 = new Food(n1, p1);
        RegularMenu menu2 = new RegularMenu(n2, p2);
        SpecialMenu menu3 = new SpecialMenu(n3, p3);

        System.out.println("\n--- DAFTAR MENU ---");
        menu1.getInfo();
        menu2.getInfo();
        menu3.getInfo();

        input.close();
    }
}

class Food {
    String name;
    int price;

    Food(String name, int price) {
        this.name = name;
        if (price < 1000000) {
            this.price = price;
        } else {
            System.out.println("Peringatan: Harga " + name + " tidak boleh >= 1.000.000. Diatur ke 0.");
            this.price = 0; 
        }
    }

    public int calcPrice() {
        return this.price + 5000;
    }

    public void getInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Price: " + calcPrice());
        System.out.println();
    }
}

class RegularMenu extends Food {
    RegularMenu(String name, int price) {
        super(name, price); 
    }

    @Override 
    public int calcPrice() {
        return super.calcPrice() + 10000;
    }
}

class SpecialMenu extends Food {
    SpecialMenu(String name, int price) {
        super(name, price); 
    }

    @Override 
    public int calcPrice() {
        return super.calcPrice() + 20000;
    }
}