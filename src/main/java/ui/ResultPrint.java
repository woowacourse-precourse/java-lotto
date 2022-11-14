package ui;
import java.util.List;
public class ResultPrint {
    public static void printResult(List<Integer> rankings){
        System.out.println("당첨 통계"+"\n"+"---");
        fifthPrint(rankings.get(5));
        fourthPrint(rankings.get(4));
        thirdPrint(rankings.get(3));
        secondPrint(rankings.get(2));
        firstPrint(rankings.get(1));
    }
    public static void firstPrint(int count){
        System.out.println("6개 일치 (2,000,000,000원) -" + count+"개");
    }
    public static void secondPrint(int count){
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -" + count+"개");
    }
    public static void thirdPrint(int count){
        System.out.println("5개 일치 (1,500,000원) -" + count+"개");
    }
    public static void fourthPrint(int count){
        System.out.println("4개 일치 (50,000원) -" + count+"개");
    }
    public static void fifthPrint(int count){
        System.out.println("3개 일치 (5,000원) -" + count+"개");
    }
}
