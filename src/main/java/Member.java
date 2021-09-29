import java.util.ArrayList;

public class Member {
    String name;
    int age;
    int memberID;
    int booksLendOut;
    ArrayList<Book> booksOfMember = new ArrayList<Book>();

    Member(String name, int age, int memberID){
        this.name = name;
        this.age = age;
        this.memberID = memberID;
        this.booksLendOut = 0;
    }

    public String getNameOfMember(){
        return this.name;
    }

    public int getMemberID(){
        return this.memberID;
    }

    public int getAgeOfMember(){
        return this.age;
    }

    public int getBooksLendOut(){
        return this.booksLendOut;
    }
}
