package lotto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Printer {

    public void printUserLottoNumber(List<List<Integer>> lottoInput) {

        int amountLotto = lottoInput.size();

        System.out.println(amountLotto + "개를 구매하셨습니다.");

        for (int i = 0; i < amountLotto; i++) {
            System.out.println(lottoInput.get(i));
        }

    }

    public void printWinList(List<Integer> correctNumberList) {

        String three = "3개 일치 (5,000원) - ";
        String four = "4개 일치 (50,000원) - ";
        String five = "5개 일치 (1,500,000원) - ";
        String fiveBouns = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        String six = "6개 일치 (2,000,000,000원) - ";
        List<String> list = new ArrayList<>(Arrays.asList(three, four, five, fiveBouns, six));
        String unit = "개";

        List<Integer> amountEachWin = knowAmountEachWin(correctNumberList);


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

        double revenuePercent = doubleRevenue / doubleInputMoney;

        System.out.println("총 수익률은 " + String.format("%.2f", revenuePercent) + "%입니다.");

    }

}
