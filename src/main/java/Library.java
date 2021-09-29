import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Library {
    ArrayList<Book> booksList = new ArrayList<Book>();
    ArrayList<Member> membersList = new ArrayList<Member>();

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

    public void borrowBook(int indexOfBook, Member member) {
        booksList.get(indexOfBook).setLendOut(true);
        booksList.get(indexOfBook).setMembersID(member.getMemberID());
    }

    public void returnBook(Member member){
        booksList.get(booksList.indexOf(member)).setLendOut(false);
        booksList.get(booksList.indexOf(member)).setMembersID(member.getMemberID());
    }

    public void getBook(int indexOfBook){
        System.out.println(booksList.get(indexOfBook).getBookName());
        System.out.println(booksList.get(indexOfBook).getLendOut());
        System.out.println(booksList.get(indexOfBook).getMemberIdOfBook());
    }

    public void showAvailableBooks() {
        for (Book book : booksList) {
            System.out.println(book.getBookName());
        }
    }

    public int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100000000);
    }


}
