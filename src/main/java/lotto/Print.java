package lotto;

import java.util.List;

public class Print {


    public static void printLottoCnt(int lotto_cnt) {

        System.out.println(lotto_cnt + "개를 구매했습니다.");
    }

    public static void printNumbers(List<Integer> numbers){
        System.out.println(numbers);
    }


    public static void printState(double rate) {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + Rank.FIFTH.getCount()+ "개");
        System.out.println("4개 일치 (50,000원) - " + Rank.FOURTH.getCount()+ "개");
        System.out.println("5개 일치 (1,500,000원) - " + Rank.THIRD.getCount()+ "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Rank.SECOND.getCount()+ "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Rank.FIRST.getCount()+ "개");
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

}
