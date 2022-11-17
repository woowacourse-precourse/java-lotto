package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.Game.RANK;

public class Display {

    void printMoneyGuide(){
        System.out.println("구입금액을 입력해 주세요.");

    }

    void printPurchasedLottos(int numberOfLottos, List<Lotto> lottos){
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for(Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers.toString());
        }
    }

    void inputWinGuide(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    void inputBonusGuide(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    void printResult(List<Game.RANK> ranks, double profitRate){
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "
                + Collections.frequency(ranks, RANK.FIVE) + "개");
        System.out.println("4개 일치 (50,000원) - "
                + Collections.frequency(ranks, RANK.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - "
                + Collections.frequency(ranks, RANK.THREE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "
                + Collections.frequency(ranks, RANK.TWO) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - "
                + Collections.frequency(ranks, RANK.ONE) + "개");

        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
