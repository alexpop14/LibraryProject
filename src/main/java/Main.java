import com.audi.ja.libraryAlex.service.LibraryService;

public class Main {

    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();

        libraryService.returnBook(47411039);
/*



        library.borrowBook(67791741, 26424155);
        library.borrowBook(98258201, 26424155);
        library.borrowBook(98258201, 31902233);


        library.getBookFromDbByIsbn(47389228);

        library.addNewMember("Elias","2002-05-14");
        library.addNewMember("Fabian","2001-12-21");
        library.addNewMember("Marvin","2003-10-30");
        library.addNewMember("Alex","2000-03-14");

        library.addNewBook("Way of the Wolf", 14);
        library.addNewBook("???", 20);
        library.addNewBook("The great Gatsby", 18);
        library.addNewBook("Middlemarch", 5);

        System.out.println("-------------------------------");
        System.out.print("MemberID of User: ");
        System.out.println(library.getMember("Elias").getMemberID());
        System.out.println("----------com.audi.ja.libraryAlex.model.Book before borrow-----------");
        System.out.println(library.getBooksName("???"));
        System.out.println("-------------com.audi.ja.libraryAlex.model.Book after borrow---------------");
        library.borrowBook(library.getBooksIban("???"),library.getMember("Elias").getMemberID());
        System.out.println(library.getBooksName("???"));
        System.out.println("----------com.audi.ja.libraryAlex.model.Book after return-------------");
        library.returnBook(library.getBooksIban("???"), library.getMember("Elias").getMemberID());
        System.out.println(library.getBooksName("???"));

*/
    }











/*


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
*/
}
