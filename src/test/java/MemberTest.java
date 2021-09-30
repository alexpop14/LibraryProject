import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    public void testGetNameOfMember(){
        Member memberTest = new Member("Alex",21,123152);

        String testName = memberTest.getNameOfMember();

        assertEquals(testName, "Alex");
    }

    @Test
    public void testGetMemberID(){
        Member memberTest = new Member("Alex",21,123152);

        int memberIDTest = memberTest.getMemberID();

        assertEquals(memberIDTest, 123152);
    }

    @Test
    public void testAddBookToBooksOfMember(){
        Member testMember = new Member("Alex",21,123152);
        Book testBook = new Book("???",1245432, 12);

        testMember.addBookToBooksOfMember(testBook);

        ArrayList<Book> testBooksOfMember = new ArrayList<Book>();
        testBooksOfMember.add(testBook);

        assertEquals(testBooksOfMember, testMember.getArrayListOfBooks());
    }

    @Test
    public void testDeleteBookOfMember(){
        Member memberTest = new Member("Alex",21,123152);
        Book bookTest = new Book("???",1245432, 12);

        memberTest.addBookToBooksOfMember(bookTest);
        memberTest.deleteBookOfMember(bookTest);

        assertTrue(memberTest.getArrayListOfBooks().isEmpty());

    }
}