import java.util.ArrayList;
import java.util.Scanner;

public class THR5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Book> listBuku = new ArrayList<>();

        System.out.println("Input data Book:");
        System.out.print("Title: ");
        String t1 = scan.nextLine();
        System.out.print("Author: ");
        String a1 = scan.nextLine();
        System.out.print("Year: ");
        int y1 = scan.nextInt();
        scan.nextLine(); 
        listBuku.add(new Book(t1, a1, y1));
        System.out.println();

        System.out.println("Input data GeneralBook:");
        System.out.print("Title: ");
        String t2 = scan.nextLine();
        System.out.print("Author: ");
        String a2 = scan.nextLine();
        System.out.print("Year: ");
        int y2 = scan.nextInt();
        scan.nextLine();
        System.out.print("Genre: ");
        String g2 = scan.nextLine();
        listBuku.add(new GeneralBook(t2, a2, y2, g2));
        System.out.println();

        System.out.println("Input data ChildrenBook:");
        System.out.print("Title: ");
        String t3 = scan.nextLine();
        System.out.print("Author: ");
        String a3 = scan.nextLine();
        System.out.print("Year: ");
        int y3 = scan.nextInt();
        System.out.print("Min Age: ");
        int age3 = scan.nextInt();
        System.out.print("Has Visualisation (true/false): ");
        boolean vis3 = scan.nextBoolean();
        listBuku.add(new ChildrenBook(t3, a3, y3, age3, vis3));

        System.out.println("\nOutput test when run getInfo():");

        for (Book b : listBuku) {
            b.getInfo();
            System.out.println(); 
        }

        scan.close();
    }
}

class Book {
    String title;
    String author;
    int yearOfPublication;

    Book(String t, String a, int y) {
        this.title = t;
        this.author = a;
        this.yearOfPublication = y;
    }

    public void getInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publication: " + yearOfPublication);
    }
}

class GeneralBook extends Book {
    String genre;

    GeneralBook(String t, String a, int y, String g) {
        super(t, a, y);
        this.genre = g;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Genre: " + genre);
    }
}

class ChildrenBook extends Book {
    int minAge;
    boolean hasVisualisation;

    ChildrenBook(String t, String a, int y, int age, boolean vis) {
        super(t, a, y);
        this.minAge = age;
        this.hasVisualisation = vis;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Minimum Age: " + minAge);
        System.out.println("Has Visualisation: " + (hasVisualisation ? "Yes" : "No"));
    }
}