import java.util.ArrayList;
import java.util.Scanner;

class Invoice{
    String InvoiceID;
    double amount;
    public Invoice(String InvoiceID,double amount){
        this.InvoiceID=InvoiceID;
        this.amount=amount;
    }
}
interface Manage<T>{
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}
public class InvoiceManager implements Manage<Invoice> {
    ArrayList<Invoice> danhsach=new ArrayList<>();
    @Override
    public void add(Invoice invoice){
        danhsach.add(invoice);
    }
    @Override
    public void update(int index, Invoice invoice){
        danhsach.set(index,invoice);
    }
    @Override
    public void delete(int index){
        danhsach.remove(index);
    }
    @Override
    public void display(){
        int x=0;
        for(Invoice i: danhsach){
            x++;
            System.out.println("ID : "+x+" , Mã hóa đơn: "+i.InvoiceID+", Số tiền: "+String.format("%.3f",i.amount));
        }
    }
    public static void main(String[] args){
        InvoiceManager invoiceManager=new InvoiceManager();
        int choice=0;
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("*************** MENU QUẢN LÝ HÓA ĐƠN ***************\n" +
                    "1. Thêm hóa đơn\n" +
                    "2. Sửa hóa đơn\n" +
                    "3. Xóa hóa đơn\n" +
                    "4. Hiển thị danh sách hóa đơn\n" +
                    "5. Thoát\n" +
                    "Lựa chọn của bạn:");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    String InvoiceID;
                    double amount;
                    while (true) {
                        System.out.println("Nhập mã hoá đơn: ");
                         InvoiceID= scanner.nextLine();
                        if (InvoiceID.matches("HD\\d{4}")) break;
                        System.err.println("Sai định dạng!");
                    }
                    while(true){
                        System.out.println("Nhập số tiền:");
                        amount=scanner.nextFloat();
                        if(amount<0){
                            System.out.println("Vui lòng nhập số thực >=0!");
                            continue;
                        }else break;
                    }
                    invoiceManager.add(new Invoice(InvoiceID,amount));
                    System.out.println("Hóa đơn đã được thêm thành công");
                    break;
                case 3:
                    invoiceManager.display();
                    System.out.println("Nhập id hóa đơn cần xóa:");
                    int id=scanner.nextInt();
                    try{
                        invoiceManager.danhsach.get(id-1);
                        invoiceManager.delete(id-1);
                        System.out.println("Hóa đơn đã được xóa thành công");
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Không tìm thấy hóa đơn nào có id = "+id);
                    }
                    break;
                case 2:
                    invoiceManager.display();
                    System.out.println("Nhập id hóa đơn cần sửa:");
                    id=scanner.nextInt();
                    scanner.nextLine();
                    try{
                        invoiceManager.danhsach.get(id);
                        while (true) {
                            System.out.println("Nhập mã hoá đơn mới: ");
                            InvoiceID= scanner.nextLine();
                            if (InvoiceID.matches("HD\\d{4}")) break;
                            System.err.println("Sai định dạng!");
                        }
                        while(true){
                            System.out.println("Nhập số tiền mới:");
                            amount=scanner.nextFloat();
                            if(amount<0){
                                System.out.println("Vui lòng nhập số thực >=0!");
                                continue;
                            }else break;
                        }
                        invoiceManager.update(id-1,new Invoice(InvoiceID,amount));
                        System.out.println("Hóa đơn đã được sửa thành công");
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Không tìm thấy hóa đơn nào có id = "+id);
                    }
                    break;
                case 4:
                    invoiceManager.display();
                    break;
                case 5: System.exit(0);
            }
        }
    }
}
