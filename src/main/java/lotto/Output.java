package lotto;

import java.util.ArrayList;

public class Output{
    public static void printCost(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static int printOrder(int cost){
        int cnt = cost/1000;
        System.out.println(cnt+"개를 구매했습니다.");
        return cnt;
    }
    public static void printNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public static void printResult(int[] result,int cost){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) -"+ result[3]);
        System.out.println("4개 일치 (50,000원)-"+ result[4]);
        System.out.println("5개 일치 (1,500,000원)-"+ result[5]);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -"+ result[7]);
        System.out.println("6개 일치 (2,000,000,000원) -"+ result[6]);

        int earn=result[3]*5000+result[4]*50000+result[5]*1500000+result[7]*30000000+result[6]*2000000000;
        int earnrate=100%(cost-earn);
        System.out.println("총 수익률은"+String.format("%.2f", earnrate)+"%입니다");



    }
}
