class Student{
    String StudentId;
    String StudentName;
    int age;
    public Student(String id,String name,int age){
        this.StudentId=id;
        this.StudentName=name;
        this.age=age;
    }
    public void displayData(){
        System.out.print("ID: "+this.StudentId+",Name: "+this.StudentName+",Age: "+this.age);
    }
}
public class Ex771 {
    public static void main(String[] args){
        Student me=new Student("202517639","Quang",20);
        me.displayData();
    }
}
