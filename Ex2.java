import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Event{
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Event(){}

    public String getName(){ return name; }
    public LocalDateTime getStartDate(){ return startDate; }
    public LocalDateTime getEndDate(){ return endDate; }
    public void setName(String name){this.name = name;}
    public void setStartDate(LocalDateTime startDate){ this.startDate = startDate;}
    public void setEndDate(LocalDateTime endDate){ this.endDate = endDate;}

    public String toString(){
        return String.format("Name: %s, Start Date: %s, End Date: %s", name, startDate, endDate);
    }
}


public class Bai162 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Event> events = new ArrayList<>();
        while(true){
            System.out.print("Nhập tên sự kiện (hoặc 'exit' để thoát):\n");
            String name = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime startDate=null;
            LocalDateTime endDate=null;
            if(name.isEmpty()){
                System.out.print("Cannot enter empty string\n");
                continue;
            }else if(name.equals("exit")){
                break;
            }
            boolean flag=false;
            while(!flag){
                try{
                    System.out.println("Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm:ss):");
                    startDate = LocalDateTime.parse(scanner.nextLine(), formatter);
                    flag=true;
                }catch(DateTimeParseException e){
                    System.out.println("Enter not valid date");
                }
            }
            flag=false;
            while(!flag){
                try{
                    System.out.println("Nhập thời gian kết thúc (dd-MM-yyyy HH:mm:ss):");
                    endDate = LocalDateTime.parse(scanner.nextLine(), formatter);
                    flag=true;
                }catch(DateTimeParseException e){
                    System.out.println("Enter not valid date");
                }
            }
            events.add(new Event(name,startDate,endDate));
        }
        events.stream().sorted(Comparator.comparing(Event::getStartDate)).forEach(System.out::println);
    }
}
