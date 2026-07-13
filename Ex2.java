class Book{
    String title;
    String author;
    double price;
    public Book(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
}
public class Ex72 {
    public static void main(String[] args){
        Book me=new Book("Đất rừng phương Nam","Đoàn Giỏi",20);
        System.out.print("Title: "+me.title+",Author: "+me.author+",Price: "+me.price);
    }
}
