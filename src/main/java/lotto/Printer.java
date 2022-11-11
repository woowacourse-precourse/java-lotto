package lotto;

import java.util.List;

public class Printer {

    private final int MONEY_UNIT=1000;
    public Printer(){

    }

    public void printHowManyLottos(int money){
        System.out.printf("%d개를 구매했습니다.%n", money/MONEY_UNIT);
    }

    public void printLottoNumbers(Lottos lottos){
        for(int order=0;order<lottos.size();order++){
            System.out.println(printEachLottoNumbers(lottos.get(order)));
        }
    }

    private List<Integer> printEachLottoNumbers(Lotto lotto) {
        return lotto.printLotto();
    }

    public void printResult(int[] winning, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("%s(%d원) - %d개\n", Rank.FIFTH.getValue(), new Result().FIFTH_PRIZE, winning[0]);
        System.out.printf("%s(%d원) - %d개\n", Rank.FOURTH.getValue(), new Result().FOURTH_PRIZE, winning[1]);
        System.out.printf("%s(%d원) - %d개\n", Rank.THIRD.getValue(), new Result().THIRD_PRIZE, winning[2]);
        System.out.printf("%s(%d원) - %d개\n", Rank.SECOND.getValue(), new Result().SECOND_PRIZE, winning[3]);
        System.out.printf("%s(%d원) - %d개\n", Rank.FIRST.getValue(), new Result().FIRST_PRIZE, winning[4]);
        System.out.print("총 수익률은 "+String.format("%,.1f",yield)+ "%입니다.");
    }
}
