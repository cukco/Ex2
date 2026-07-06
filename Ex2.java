
public class Ex52 {
    public static void main(String[] args){
        long start, end;
        String str="";
        start=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            str+="a";
        }
        end=System.currentTimeMillis();
        System.out.println("Time taken by String: "+ (end-start)+"ms");

        StringBuilder strb=new StringBuilder();
        start=System.currentTimeMillis();
        strb.append("a".repeat(1000));
        end=System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder: "+ (end-start)+"ms");

        StringBuffer stringBuffer=new StringBuffer();
        start=System.currentTimeMillis();
        stringBuffer.append("a".repeat(1000));
        end=System.currentTimeMillis();
        System.out.println("Time taken by StringBuffer: "+ (end-start)+"ms");



    }
}
