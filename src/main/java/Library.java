import java.util.ArrayList;

public class Library {
    ArrayList<Book> booksList = new ArrayList<Book>();
    ArrayList<Member> membersList = new ArrayList<Member>();


    public void addMember(){
        membersList.add(new Member("Alex", 21, 1));
        membersList.add(new Member("Fabi", 18, 2));
        membersList.add(new Member("Marvin", 17, 3));
        membersList.add(new Member("Elias", 17, 4));
    }

    public void addBook(){
        booksList.add(new Book("Beautiful World, Where Are You: A Novel",1, 12));
        booksList.add(new Book("Harlem Shuffle: A Novel",2, 16));
        booksList.add(new Book("The Man Who Died Twice",3, 18));
        booksList.add(new Book("Something New Under the Sun: A Novel",4, 6));
        booksList.add(new Book("Chronicles from the Land of the Happiest People on Earth",5, 12));
    }

    public void showMembers(){
        for (Member member: membersList) {
            System.out.println(member.getNameOfMember());
        }
    }

    public void showMembersID(){
        for (Member member: membersList) {
            System.out.println(member.getMemberID());
        }
    }

}
