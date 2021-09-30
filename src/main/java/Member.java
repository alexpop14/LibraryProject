import java.util.ArrayList;

public class Member {
    private String name;
    private int age;
    private int memberID;
    private int booksLendOut;
    private ArrayList<Book> booksOfMember = new ArrayList<Book>();

    Member(String name, int age, int memberID){
        this.name = name;
        this.age = age;
        this.memberID = memberID;
    }

    public String getNameOfMember(){
        return this.name;
    }

    public int getMemberID(){
        return this.memberID;
    }

    public void addBookToBooksOfMember(Book book){
        this.booksOfMember.add(book);
    }

    public void deleteBookOfMember(Book book){
        this.booksOfMember.remove(book);
    }

    public void getBooksOfMember(Book book){
        this.booksOfMember.get(booksOfMember.indexOf(book));
    }

    public ArrayList<Book> getArrayListOfBooks(){
        return this.booksOfMember;
    }

    public int getAgeOfMember(){
        return this.age;
    }

    public int getBooksLendOut(){
        return this.booksLendOut;
    }
}
