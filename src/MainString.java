import java.util.Arrays;

public class MainString {
    public static void main(String[] args) {

        //1
//        String[] array={"1","2","3","4","5","6"};
//        String result="";
//        for(String str:array){
//            result+=str+", ";
//        }
//        System.out.println(result);

        //2
//        String[] array={"1","2","3","4","5","6"};
//        StringBuilder sb = new StringBuilder("LOL ");
//        for(String str:array){
//            sb.append(str).append(", ");
//        }
//        System.out.println(sb.toString());

        //3
        String a="lol";
        String b="lo";
        String c=(b+"l").intern();
        System.out.println(a==c);//true


    }
}
