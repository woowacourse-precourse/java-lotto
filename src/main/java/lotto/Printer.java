package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.EnumCreate.MatchAmount;
import lotto.EnumCreate.MatchAmount.LottoMatchMoneyMessage;

public class Printer {

    MatchAmount matchThree = MatchAmount.THREE;
    MatchAmount matchSix = MatchAmount.SIX;
    private static final String BUY = "개를 구매했습니다.";
    private static final String STATICS = "당첨 통계\n---";
    private static final String REVENUE = "총 수익률은 ";
    private static final String REVENUE2 = "%입니다.";
    private static final String UNIT = "개";

    private static final int PERCENT = 100;

    public void printToDo(String toDo) {
        System.out.println(toDo);
    }

    public void printUserLottoNumber(List<List<Integer>> lottoInput) {

        int amountLotto = lottoInput.size();

        System.out.println(amountLotto + BUY);

        for (int i = 0; i < amountLotto; i++) {
            System.out.println(lottoInput.get(i));
        }

    }

    public void printWinList(List<Integer> correctNumberList) {
        List<Integer> amountEachWin = knowAmountEachWin(correctNumberList);

        System.out.println(STATICS);

        for (LottoMatchMoneyMessage matchNumber : LottoMatchMoneyMessage.values()) {
            int index = matchNumber.ordinal();

            String numberMessage = matchNumber.getNumberMessage();

            System.out.println(numberMessage + amountEachWin.get(index) + UNIT);
        }
    }

    public List<Integer> knowAmountEachWin(List<Integer> correctNumberList) {

        List<Integer> frequencyList = new ArrayList<>();

        for (int i = matchThree.getNumber(); i < matchSix.getNumber() + 1; i++) {
            int frequency = Collections.frequency(correctNumberList, i);
            frequencyList.add(frequency);
        }
        return frequencyList;
    }

    public void printRevenuePercent(int inputMoney, int revenue) {

        double doubleInputMoney = inputMoney;
        double doubleRevenue = revenue;

        double revenuePercent = doubleRevenue / doubleInputMoney * PERCENT;

        System.out.println(REVENUE + String.format("%.1f", revenuePercent) + REVENUE2);

    }

}
