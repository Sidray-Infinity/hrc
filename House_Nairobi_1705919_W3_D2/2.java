import java.util.Scanner;

abstract class Book {
    String title;

    abstract void setTitle(String s);

    String getTitle() {
        return this.title;
    }
}

class MyBook extends Book {
    static Scanner scan = new Scanner(System.in);

    void setTitle(String s) {
        this.title = s;
    }

    public static void main(String args[]) {
        MyBook b = new MyBook();

        System.out.println("Enter the title of the book:");
        String title = scan.nextLine();

        b.setTitle(title);

        System.out.println("Title of the book is: " + b.getTitle());

    }
}