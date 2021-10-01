import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Library {
    private HashMap<Integer, Book> booksMap = new HashMap();
    private HashMap<Integer, Member> membersMap = new HashMap();

    public void addNewMember(String name, int age){
        int randomID = generateRandomNumber();
        membersMap.put(randomID, new Member(name, age, randomID));
    }

    public void addNewBook(String name, int ageRestriction){
        int randomID = generateRandomNumber();
        booksMap.put(randomID, new Book(name, randomID, ageRestriction));
    }


    public Member getMember(String name){
        for (Member member : membersMap.values()) {
            if (member.getNameOfMember().equals(name)) {
                return member;
            }
        }
        return null;
    }



    public int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100000000);
    }

    public Book getBooksName(String name){
        for (Book book : booksMap.values()) {
            if (book.getBookName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(int bookID, int memberID) {
        booksMap.values().remove(bookID);
        booksMap.get(bookID).setLendOut(true);
        booksMap.get(bookID).setMembersID(bookID);
        .addBookToBooksOfMember(booksMap.get(indexOfBook));
    }


    public void returnBook(String name, Member member){
        for (Book book : booksMap.values()) {
            if (book.getBookName().equals(name)) {
                book.setLendOut(false);
                member.deleteBookOfMember(book);
                book.setMembersID(0);
            }
        }
    }
}
