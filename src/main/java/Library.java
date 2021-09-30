import java.util.ArrayList;
import java.util.Random;

public class Library {
    private ArrayList<Book> booksList = new ArrayList<Book>();
    private ArrayList<Member> membersList = new ArrayList<Member>();

    public void addMember(String name, int age) {
        membersList.add(new Member(name, age, generateRandomNumber()));
    }

    public void addBook(String bookName, int ageRestriction) {
        booksList.add(new Book(bookName, generateRandomNumber(), ageRestriction));
    }

    public Member getMember(String name){
        for (Member member : membersList) {
            if (member.getNameOfMember().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public Book getBooksName(String name){
        for (Book book : booksList) {
            if (book.getBookName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(int indexOfBook, Member member) {
        booksList.get(indexOfBook).setLendOut(true);
        booksList.get(indexOfBook).setMembersID(member.getMemberID());
        member.addBookToBooksOfMember(booksList.get(indexOfBook));
    }

    public void returnBook(String name, Member member){
        for (Book book : booksList) {
            if (book.getBookName().equals(name)) {
                book.setLendOut(false);
                member.deleteBookOfMember(book);
                book.setMembersID(0);
            }
        }
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public void showAvailableBooks() {
        for (Book book : booksList) {
            if(book.getMemberIdOfBook() == 0){
            System.out.println(book.getBookName());
            }
        }
    }

    public int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100000000);
    }
}
