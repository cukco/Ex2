import java.util.ArrayList;
import java.util.List;

abstract class Payment{
    double amount;
    abstract void pay();
    void printAmount(){
        System.out.printf("%.2f",amount);
    }
}
interface Refundable{
    void refund();
}
class CashPayment extends Payment{
    CashPayment(double a){
        amount = a;
    }
    void pay(){
        System.out.printf("Paid by cash: %.2f",amount);
    }
}
class CreditCardPayment extends Payment implements Refundable{
    CreditCardPayment(double a){
        amount = a;
    }
    void pay(){
        System.out.printf("Paid by CreditCard: %.2f",amount);
    }
    public void refund(){
        System.out.printf(" Refund by CreditCard: %.2f",amount);
    }
}
class EWalletPayment extends Payment implements Refundable{
    EWalletPayment(double a){
        amount = a;
    }
    void pay(){
        System.out.printf("Pay by EWallet: %.2f",amount);
    }
    public void refund(){
        System.out.printf(" Refund by EWallet: %.2f",amount);
    }
}
public class Ex2 {
    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();
        payments.add(new CashPayment(12));
        payments.add(new CreditCardPayment(12));
        payments.add(new EWalletPayment(12));
        for (int i=0;i<payments.size();i++) {
            payments.get(i).pay();
            try{
                Refundable refundable = (Refundable) payments.get(i);
                refundable.refund();
            }catch(ClassCastException e){
                System.out.println();
                continue;
            }
            System.out.println();
        }
    }
}
