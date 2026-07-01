import java.util.Scanner;
public class Ex42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng của mảng: ");
        int rows = sc.nextInt();
        System.out.print("Nhập số cột của mảng: ");
        int columns = sc.nextInt();
        int[][] arr= new int[rows][columns];
        int odd=0;
        int even=0;
        System.out.println("Nhập các phần tử của mảng:");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.printf("Phần tử [%d][%d]: ",i,j);
                arr[i][j]=sc.nextInt();
                if(arr[i][j]%2==0){
                    odd+=arr[i][j];
                }else even+=arr[i][j];
            }
        }
        System.out.printf("Tổng các số chẵn: %d\nTổng các số lẻ: %d",odd,even);
    }
}
