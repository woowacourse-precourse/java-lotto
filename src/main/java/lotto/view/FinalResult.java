package lotto.view;

import lotto.model.RateOfReturn;

public class FinalResult {
    public static int first=0;
    public static int second=0;
    public static int third=0;
    public static int fourth=0;
    public static int fifth=0;

    public static void printFinalResult(){
        System.out.println("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + fifth+ "개\n" +
                "4개 일치 (50,000원) - " +fourth+ "개\n" +
                "5개 일치 (1,500,000원) - " +third+ "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " +second + "개\n" +
                "6개 일치 (2,000,000,000원) - " +first+ "개\n" +
                "총 수익률은 "+ RateOfReturn.rate() + "%입니다.");
    }



}
