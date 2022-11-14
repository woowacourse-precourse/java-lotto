package lotto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Printer {

    private static final String BUY_MESSAGE = "개를 구매했습니다.";
    private static final String THREE = "3개 일치 (5,000원) - ";
    private static final String FOUR = "4개 일치 (50,000원) - ";
    private static final String FIVE = "5개 일치 (1,500,000원) - ";
    private static final String FIVEBOUNS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX = "6개 일치 (2,000,000,000원) - ";
    private static final List<String> list = new ArrayList<>(Arrays.asList(THREE, FOUR, FIVE, FIVEBOUNS, SIX));
    private static final String unit = "개";
    private static final String MESSAGE_STATICS = "당첨 통계\n---";

    private static final String MESSAGE_FINAL = "총 수익률은 ";
    private static final String MESSAGE_FINAL2 = "%입니다.";


    public void printToDo(String toDo) {
        System.out.println(toDo);
    }

    public void printUserLottoNumber(List<List<Integer>> lottoInput) {

        int amountLotto = lottoInput.size();

        System.out.println(amountLotto + BUY_MESSAGE);

        for (int i = 0; i < amountLotto; i++) {
            System.out.println(lottoInput.get(i));
        }

    }

    public void printWinList(List<Integer> correctNumberList) {

        List<Integer> amountEachWin = knowAmountEachWin(correctNumberList);

        System.out.println(MESSAGE_STATICS);

        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i) + amountEachWin.get(i) + unit);
        }


    }

    public List<Integer> knowAmountEachWin(List<Integer> correctNumberList) {

        List<Integer> frequencyList = new ArrayList<>();

        for (int i = 3; i < 8; i++) {
            int frequency = Collections.frequency(correctNumberList, i);
            frequencyList.add(frequency);

        }
        return frequencyList;
    }

    public void printRevenuePercent(int inputMoney, int revenue) {

        double doubleInputMoney = inputMoney;
        double doubleRevenue = revenue;

        double revenuePercent = doubleRevenue / doubleInputMoney * 100;

        System.out.println(MESSAGE_FINAL + String.format("%.1f", revenuePercent) + MESSAGE_FINAL2);

    }

}
