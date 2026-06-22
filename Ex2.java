import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số thứ nhất (firstNumber): ");
        int n1 = scanner.nextInt();
        System.out.print("Nhập số thứ hai (secondNumber): ");
        int n2 = scanner.nextInt();
        System.out.println("--- Kết quả ---");
        System.out.printf("firstNumber = %d\nsecondNumber = %d\nTổng = %d\nHiệu = %d\nTích = %d\nThương = %d\nPhần dư =%d",n1,n2,n1+n2,n1-n2,n1*n2,n1/n2,n1%n2);
    }
}
