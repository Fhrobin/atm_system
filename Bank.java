import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bank{

    private ArrayList<Account> A;
    private ArrayList<Account> B;


    public Bank(){
        A = new ArrayList<>();
        B = new ArrayList<>();
    }


    public void addBankA(Account acc){

        A.add(acc);

    }

    public void addBankB(Account acc){

        B.add(acc);
    }


    public void showAccounts(){

        for(Account acc : A) System.out.println(acc.toString());
        for(Account acc : B) System.out.println(acc.toString());

    }


    public boolean authorizeATMA(int card){
        boolean isTrue = false;
        boolean isIt = false;
        for(Account acc : A){
            if (card == acc.getCardNum()) {
                isTrue = true;
                    if (card == acc.getCardNum() && cardExp(acc.getExpDate())){
                        System.out.println("card is authorized");
                    isIt = true;
                        break;
            }if(isIt == false) {
                    System.out.println("card is expired");
                }
            }
        }

        if(isTrue == false){
            System.out.println("card is not supported by ATM");
        }
        System.out.println(isTrue && isIt);
        return (isTrue && isIt);
    }


    public boolean authorizeATMB(int card){
        boolean isTrue = false;
        boolean isIt = false;
        for(Account acc : B){
            if (card == acc.getCardNum()) {
                isTrue = true;
                if (card == acc.getCardNum() && cardExp(acc.getExpDate())){
                    System.out.println("card is authorized");
                    isIt = true;
                    break;
                }if(isIt == false) {
                    System.out.println("card is expired");
                }
            }
        }

        if(isTrue == false){
            System.out.println("card is not supported by ATM");
        }
        System.out.println(isTrue && isIt);
        return (isTrue && isIt);
    }

    public static boolean cardExp(String month){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        if(month.compareTo(today) > 0){
            return true;
        }else
            return false;
    }

    public boolean authorizeCardA(String passCode){
        boolean isTrue = false;
        for(Account acc : A){
            if (passCode.compareTo(acc.getPassword())>0) {
                isTrue = true;
                break;
            }
        }
        return isTrue;

    }

    public boolean authorizeCardB(String passCode){
        boolean isTrue = false;
        for(Account acc : B){
                if (passCode.compareTo(acc.getPassword())>0) {
                    isTrue = true;
                    break;
                }else{
                    System.out.println("Wrong password");
                }
        }
        return isTrue;
    }

    public double withdraw(String passCode,double amount){
        double amount2= 0;
        for(Account acc : A){
            if (passCode.compareTo(acc.getPassword()) > 0) {
                if(amount <= acc.getBalance()) {
                    System.out.println(acc.getBalance());
                    amount2 = acc.getBalance() - amount;
                    acc.setBalance(amount2);
                    System.out.print("Your remaining balance is:  ");
                    System.out.println(acc.getBalance());
                    return amount2;
                }

            }
        }
        return amount2;
    }

    public double withdrawB(String passCode,double amount){
        double amount2= 0;
        for(Account acc : B){
            if (passCode.compareTo(acc.getPassword()) > 0) {
                if(amount <= acc.getBalance()) {
                    System.out.println(acc.getBalance());
                    amount2 = acc.getBalance() - amount;
                    acc.setBalance(amount2);
                    System.out.print("Your remaining balance is:  ");
                    System.out.println(acc.getBalance());
                    return amount2;
                }

            }
        }
        return amount2;
    }



}