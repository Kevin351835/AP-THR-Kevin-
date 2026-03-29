import java.util.Scanner;

public class THR4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan inputan anda");

        System.out.println("\nData DVD");
        System.out.print("Judul: "); 
        String j1 = input.nextLine();
        System.out.print("Tahun Rilis: "); 
        int t1 = input.nextInt();
        System.out.print("Harga: "); 
        double h1 = input.nextDouble();
        System.out.print("Runtime (menit): "); 
        double r1 = input.nextDouble();
        input.nextLine(); 

        System.out.println("\nData Magazine");
        System.out.print("Judul: "); 
        String j2 = input.nextLine();
        System.out.print("Tahun Rilis: "); 
        int t2 = input.nextInt();
        System.out.print("Harga: "); 
        double h2 = input.nextDouble();
        input.nextLine(); 
        System.out.print("Penulis: "); 
        String p2 = input.nextLine();
        System.out.print("Jumlah Halaman: "); 
        int hal2 = input.nextInt();
        input.nextLine();

        System.out.println("\nData Vinyl");
        System.out.print("Judul: "); 
        String j3 = input.nextLine();
        System.out.print("Tahun Rilis: "); 
        int t3 = input.nextInt();
        System.out.print("Harga: "); 
        double h3 = input.nextDouble();
        System.out.print("Ukuran (inci): "); 
        int u3 = input.nextInt();

        Dvd dvdObj = new Dvd(j1, t1, h1, r1);
        Magazine magObj = new Magazine(j2, t2, h2, p2, hal2);
        Vinyl vinObj = new Vinyl(j3, t3, h3, u3);

        System.out.println("\nOutput test when run getDescription():");
        dvdObj.getDescription();
        magObj.getDescription();
        vinObj.getDescription();
    }
}

class Item {
    String title;
    int releaseYear;
    double price;

    Item(String title, int year, double price) {
        if (title.length() >= 255) {
            this.title = "Invalid Title";
        } else {
            this.title = title;
        }

        if (year > 1800 && year < 2026) {
            this.releaseYear = year;
        } else {
            this.releaseYear = 2000;
        }

        this.price = price;
    }

    public void getDescription() {
        System.out.println("Title: " + title);
        System.out.println("releaseYear: " + releaseYear);
        int hargaBulat = (int) price;
        System.out.println("Price: " + hargaBulat);
    }
}

class Dvd extends Item {
    double runtime;

    Dvd(String title, int year, double price, double run) {
        super(title, year, price);
        if (run < 720) {
            this.runtime = run;
        } else {
            this.runtime = 0;
        }
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Runtime: " + (int) runtime + " minutes\n");
    }
}

class Magazine extends Item {
    String author;
    int numPages;

    Magazine(String title, int year, double price, String auth, int pages) {
        super(title, year, price);
        if (auth.length() < 50) {
            this.author = auth;
        } else {
            this.author = "Unknown";
        }
        this.numPages = pages;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Author: " + author);
        System.out.println("Number of Pages: " + numPages + "\n");
    }
}

class Vinyl extends Item {
    int size;

    Vinyl(String title, int year, double price, int s) {
        super(title, year, price);
        if (s <= 12) {
            this.size = s;
        } else {
            this.size = 0;
        }
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Size in inches: " + size + "\n");
    }
}