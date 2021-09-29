public class Book {
    String name;
    int iban;
    boolean lendOut;
    int ageRestriction;
    int memberID;

    Book(String name, int iban, int ageRestriction){
        this.name = name;
        this.iban = iban;
        this.ageRestriction = ageRestriction;
        this.memberID = 0;
        this.lendOut = false;
    }

    public String getBookName(){
        return this.name;
    }

    public boolean getLendOut(){
        return this.lendOut;
    }

    public void setMembersID(int memberID){
        this.memberID = memberID;
    }

    public void setLendOut(boolean LendOut){
        this.lendOut = LendOut;
    }

    public int getMemberIdOfBook(){
        return this.memberID;
    }
}
