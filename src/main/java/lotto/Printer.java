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
            printEachLottoNumbers(lottos.get(order));
        }
    }

    private void printEachLottoNumbers(Lotto lotto) {
        List<Integer> list = new LottoNumberGenerater().makeLottoNumber(lotto);
        System.out.println(list);
    }

    public void printResult(int[] winning, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf(Rank.FIFTH.getValue()+"(%d원) - "+winning[0]+"개%n", new Result().FIFTH_PRIZE);
        System.out.printf(Rank.FOURTH.getValue()+"(%d원) - "+winning[1]+"개%n", new Result().FOURTH_PRIZE);
        System.out.printf(Rank.THIRD.getValue()+"(%d원) - "+winning[2]+"개%n", new Result().THIRD_PRIZE);
        System.out.printf(Rank.SECOND.getValue()+"(%d원) - "+winning[3]+"개%n", new Result().SECOND_PRIZE);
        System.out.printf(Rank.FIRST.getValue()+"(%d원) - "+winning[4]+"개%n", new Result().FIRST_PRIZE);
        System.out.print("총 수익률은 "+String.format("%,.1f",yield)+ "%입니다.");
    }
}
