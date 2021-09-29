import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        library.addMember("Alex", 21);
        library.addMember("Fabian", 18);
        library.addMember("Elias",17);
        library.addMember("Marvin", 17);

        library.addBook("Way of the Wolf", 14);
        library.addBook("???",6);
        library.addBook("The great Gatsby", 16);
        library.addBook("Middlemarch", 5);


        System.out.println("-------------------------------");
        System.out.println(library.getMember("Alex").getMemberID());
        System.out.println("----------Book before borrow-----------");
        library.getBook(0);
        System.out.println("-------------Book after borrow---------------");
        library.borrowBook(0, library.getMember("Alex"));
        library.getBook(0);
        System.out.println("----------Book after return-------------");
        library.returnBook(library.getMember("Alex"));
        library.getBook(0);
    }














    public void addWithConsole(){
        Library libraryWithConsole = new Library();
        Scanner scanner = new Scanner(System.in);
        System.out.println("in order to add a new member press -m- \n" +
                "in order to add a new book press -b-");
        String input = scanner.next();
        switch (input){
            case "m":
                System.out.print("Please insert your name: ");
                String nameMember = scanner.next();
                System.out.print("Please insert your age: ");
                int ageMember = scanner.nextInt();
                libraryWithConsole.addMember(nameMember,ageMember);
                libraryWithConsole.addMember("Hrllo", 2);
                break;
            case "b":
                System.out.print("Please insert the name of the book: ");
                String nameBook = scanner.next();
                System.out.print("Please insert minimum age: ");
                int ageRestrictionBook = scanner.nextInt();
                libraryWithConsole.addBook(nameBook,ageRestrictionBook);
                break;
            default:
                System.out.println("Wrong input, please check it!");
        }
    }

}
