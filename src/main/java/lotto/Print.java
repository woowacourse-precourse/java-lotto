package lotto;

import java.util.Collections;
import java.util.List;

public class Print {
    private static final String PRICE_INPUT = "구입금액을 입력해주세요:";
    private static final String LOTTO_INPUT = "당첨 번호를 입력해주세요: ";
    private static final String BONUS_INPUT = "보너스 번호를 입력하세요:";

    public static void pricePrint() {
        System.out.println(PRICE_INPUT);
    }
    public static void numPrint(User user) {
        System.out.println(user.getLotto_num()+"개를 구매했습니다.");
    }
    public static void lottoPrint() {
        System.out.println(LOTTO_INPUT);
    }

    public static void bonusPrint() {
        System.out.println(BONUS_INPUT);
    }
    public static void myLottoPrint(List<List<Integer>> my_lotto) {
        for (int i = 0; i < my_lotto.size(); i++) {
            System.out.println(my_lotto.get(i).toString());
        }
    }

    public  static void winningsPrint(List<Integer> count){
        System.out.println("3개 일치 (5,000원) -"+" "+Collections.frequency(count,3)+"개");
        System.out.println("4개 일치 (50,000원) -"+" "+Collections.frequency(count,4)+"개");
        System.out.println("5개 일치 (1,500,000원) -"+" "+Collections.frequency(count,5)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) -"+" "+Collections.frequency(count,-1)+"개");
        System.out.println("6개 일치 (2,000,000,000원) -"+" "+Collections.frequency(count,6)+"개");
    }
    public static void yieldPrint(double yield){
        System.out.println("총 수익률은 "+yield+"%입니다.");
    }
}
