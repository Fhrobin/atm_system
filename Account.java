
public class Account extends Bank {

    private String name;
    private double balance;
    private int card;
    private String exp;
    private String pass;


    public Account(){
        super();
        this.name = "";
        this.balance = 40;
        this.card = 0;
        this.exp = "";
        this.pass = "";
    }


    public Account(String name,double balance, int card, String exp, String pass){

        this.name = name;
        this.balance = balance;
        this.card = card;
        this.exp = exp;
        this.pass = pass;
    }


    public String getName(){

        return name;
    }


    public int getCardNum(){

        return card;
    }


    public String getExpDate(){

        return exp;
    }


    public String getPassword(){

        return pass;
    }


    public void setBalance(double balance){

        this.balance = balance;

    }


    public double getBalance(){

        return balance;
    }


    public String toString(){
        return String.format("Customer: Name: %s  Card: %s Expiration Date:%s Password:%s", getName(), getCardNum(), getExpDate(), getPassword());
    }

}