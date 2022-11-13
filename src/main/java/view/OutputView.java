package view;

import domain.LottoNumberList;
import domain.LottoPurAmount;
import domain.MatchingNumber;
import util.ResultView;
import util.WinNum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String BUY = "개를 구매했습니다.";
    private static final String PROFIT = "총 수익률은 ";
    private static final String END_WORD = "%입니다.";


    public static void printBuyLottoNumber(LottoPurAmount lottoPurAmount) {
        String buynumber = "";
        int divideprice = lottoPurAmount.getLottopuramount()/1000;
        buynumber = divideprice + BUY;
        System.out.println("\n" + buynumber);
    }

    public static void printAllLottoNumber(List<List<Integer>> lottonumberlist) {
        for(int i=0; i<lottonumberlist.size(); i++) {
            System.out.println(lottonumberlist.get(i).toString());
        }
    }

    public static void printResult(MatchingNumber matchingNumber) {
        ResultView[] values = ResultView.values();
        WinNum[] values2 = WinNum.values();
        HashMap<String,Integer> numberList = matchingNumber.getMatchingNumber();

        for(int i=0; i< values.length; i++) {
            String str = ResultView.valueOf(values2[i].toString()).label() + numberList.get(values2[i].toString()) + "개";
            System.out.println(str);
        }
    }

    public static void printProfit(float puramount,float winamount) {
        String profit;
        profit = PROFIT + String.format("%.1f", puramount/winamount * 100) + END_WORD;
        System.out.println(profit);
    }
}
