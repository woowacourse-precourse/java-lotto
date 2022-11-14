package view;

import domain.MatchingNumber;
import lotto.Lotto;
import util.ResultView;
import util.WinNum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String BUY = "개를 구매했습니다.";
    private static final String PROFIT = "총 수익률은 ";
    private static final String END_WORD = "%입니다.";


    public static void printBuyLottoNumber(int lottoPurAmount) {
        String buynumber = "";
        int divideprice = lottoPurAmount/1000;
        buynumber = divideprice + BUY;
        System.out.println("\n" + buynumber);
    }

    public static void printAllLottoNumber(List<Lotto> lottos) {
        for(int i=0; i<lottos.size(); i++) {
            List<Integer> lottoNumbers = new ArrayList<>(lottos.get(i).getLotto());
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    public static void printResult(MatchingNumber matchingNumber) {
        InputView.printWinResult();

        ResultView[] values = ResultView.values();
        WinNum[] values2 = WinNum.values();
        HashMap<String,Integer> numberList = matchingNumber.getMatchingNumber();

        for(int i=0; i< values.length; i++) {
            String str = ResultView.valueOf(values2[i].toString()).label() + numberList.get(values2[i].toString()) + "개";
            System.out.println(str);
        }
    }

    public static void printProfit(float winamount,float puramount) {
        String profit;
        profit = PROFIT + String.format("%.1f", winamount/puramount * 100) + END_WORD;
        System.out.println(profit);
    }
}
