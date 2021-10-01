public class Book {
    private String name;
    private int iban;
    private boolean lendOut;
    private int ageRestriction;
    private int memberID;

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

    public int getIban(){return this.iban;}


    public void setMembersID(int memberID){
        this.memberID = memberID;
    }

    public void setLendOut(boolean LendOut){
        this.lendOut = LendOut;
    }

    @Override
    public String toString(){
        return this.name + " " + this.lendOut + " " + this.memberID;
    }
}
