package lotto.view;

public class GameOutput {
    public static void getResult(){
        System.out.println("당첨 통계")
    }
    public static void getDetailResult(int n, int count){
        if (n==3){
            System.out.println("${n}개 일치", "(5000원)", '-',"${count}개")
        }
        if (n==4){
            System.out.println("${n}개 일치", "(50000원)", '-',"${count}개")
        }
        //여기 상수처리


        System.out.println("총 수익률은 ${}%입니다.");
    }
}