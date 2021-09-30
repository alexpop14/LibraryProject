import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void testGetBookName(){
        Book testBook = new Book("????", 1254235, 12);
        String test = testBook.getBookName();
        assertEquals("????",test);
    }

    @Test
    public void testGetLendOut(){
        Book testBook = new Book("????", 1254235, 12);
        boolean test = testBook.getLendOut();
        assertEquals(false,test);
    }

    @Test
    public void testSetLendOut(){
        Book testBook = new Book("????", 1254235, 12);

        boolean test1 = testBook.getLendOut();
        assertEquals(false,test1);


        testBook.setLendOut(true);
        boolean test2 = testBook.getLendOut();
        assertEquals(true,test2);
    }

    @Test
    public void testSetMembersId(){
        Book testBook = new Book("????", 1254235, 12);

        testBook.setMembersID(123);

        assertEquals(testBook.getMemberIdOfBook(),123);
    }

    @Test
    public void testGetMembersIdOfBook(){
        Book testBook = new Book("????", 1254235, 12);
        assertEquals(testBook.getMemberIdOfBook(),0);
    }
}