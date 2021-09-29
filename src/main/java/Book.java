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
    }

    public String getBookName(){
        return this.name;
    }

    public int getIban(){
        return this.iban;
    }

    public boolean getLendOut(){
        return this.lendOut;
    }

    public int getAgeRestriction(){
        return this.ageRestriction;
    }
}
