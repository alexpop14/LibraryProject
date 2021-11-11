import com.audi.ja.libraryAlex.service.LibraryService;

public class Main {

    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        libraryService.returnBook(256391,26424155);
    }
}
