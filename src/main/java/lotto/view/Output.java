package lotto.view;

import lotto.Data.PrizeRanking;
import lotto.service.WinLottoResult;

import java.text.DecimalFormat;

public class Output {
    public final String ERROR_ORDER = "[ERROR]";
    public final int UNDER_LIMIT = 1;
    public final int UPPER_LIMIT = 45;
    WinLottoResult winLottoResult = new WinLottoResult();

    public void inputMoneyOrder() {
        String INPUTMONEY_ORDER = "구입금액을 입력해 주세요.";
        System.out.println(INPUTMONEY_ORDER);
    }

    public void purchaseLottoOrder(int lottoCount) {
        String PURCHASE_LOTTO_ORDER = "개를 구매했습니다.";
        System.out.println(lottoCount+ PURCHASE_LOTTO_ORDER);
    }
    public void winningLottoNumbersOrder() {
        String WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
        System.out.println(WINNING_LOTTO_NUMBERS);
    }
    public void bonusLottoNumberOrder() {
        String BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";
        System.out.println(BONUS_LOTTO_NUMBER);
    }

    public void winStatistics() {
        String WIN_STATISTICS = "당첨 통계";
        System.out.println(WIN_STATISTICS);
        System.out.println("---");
    }
    public void lineSpace() {
        System.out.println();
    }
    public void fifthPlace(int count){
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        System.out.println("3개 일치 ("+formatter.format(PrizeRanking.FIFTH.getNumber())+"원) - "+count+"개");
        WinLottoResult.yield += count * PrizeRanking.FIFTH.getNumber();
    }
    public void fourthPlace(int count){
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        System.out.println("4개 일치 ("+formatter.format(PrizeRanking.FOURTH.getNumber())+"원) - "+count+"개");
        winLottoResult.yield += count * PrizeRanking.FOURTH.getNumber();
    }
    public void thirdPlace(int count){
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        System.out.println("5개 일치 ("+formatter.format(PrizeRanking.THIRD.getNumber())+"원) - "+count+"개");
        winLottoResult.yield += count * PrizeRanking.THIRD.getNumber();
    }
    public void secondPlace(int count){
        DecimalFormat formatter = new DecimalFormat("###,###,###.#");
        System.out.println("5개 일치, 보너스 볼 일치 ("+formatter.format(PrizeRanking.SECOND.getNumber())+"원) - "+count+"개");
        winLottoResult.yield += count * PrizeRanking.SECOND.getNumber();
    }
    public void firstPlace(int count){
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        System.out.println("6개 일치 ("+formatter.format(PrizeRanking.FIRST.getNumber())+"원) - "+count+"개");
        winLottoResult.yield += count * PrizeRanking.FIRST.getNumber();
    }
    public void totalYield(double yield) {
        DecimalFormat formatter = new DecimalFormat("###,###.0");
        if(yield == 0.0) {System.out.println("총 수익률은 "+0.0+"%입니다.");}
        if(yield > 0) { System.out.println("총 수익률은 "+formatter.format(yield)+"%입니다.");}
    }
}