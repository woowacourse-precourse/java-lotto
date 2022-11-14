package lotto.view;

import lotto.Data.LottoEnum;
import lotto.service.WinLottoResult;

import java.text.DecimalFormat;

public class Output {
    WinLottoResult winLottoResult = new WinLottoResult();
    private final String INPUTMONEY_ORDER = "구입금액을 입력해 주세요.";
    private final String PURCHASE_LOTTO_ORDER = "개를 구매했습니다.";
    private final String USER_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";
    private final String WIN_STATISTICS = "당첨 통계";



    public void inputMoneyOrder() {
        System.out.println(INPUTMONEY_ORDER);
    }

    public void purchaseLottoOrder(int lottoCount) {
        System.out.println(lottoCount+PURCHASE_LOTTO_ORDER);
    }
    public void userLottoNumbersOrder() {
        System.out.println(USER_LOTTO_NUMBERS);
    }
    public void bonusLottoNumberOrder() {
        System.out.println(BONUS_LOTTO_NUMBER);
    }
    public void winStatistics() {
        System.out.println(WIN_STATISTICS);
        System.out.println("---");
    }
    public void fifthPlace(int count){
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        System.out.println("3개 일치 ("+formatter.format(LottoEnum.FIFTH.getNumber())+"원) - "+count+"개");
        winLottoResult.profitMoney += count * LottoEnum.FIFTH.getNumber();
    }
    public void fourthPlace(int count){
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        System.out.println("4개 일치 ("+formatter.format(LottoEnum.FOURTH.getNumber())+"원) - "+count+"개");
        winLottoResult.profitMoney += count * LottoEnum.FOURTH.getNumber();
    }
    public void thirdPlace(int count){
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        System.out.println("5개 일치 ("+formatter.format(LottoEnum.THIRD.getNumber())+"원) - "+count+"개");
        winLottoResult.profitMoney += count * LottoEnum.THIRD.getNumber();
    }
    public void secondPlace(int count){
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        System.out.println("5개 일치, 보너스 볼 일치 ("+formatter.format(LottoEnum.SECOND.getNumber())+"원) - "+count+"개");
        winLottoResult.profitMoney += count * LottoEnum.SECOND.getNumber();
    }
    public void firstPlace(int count){
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        System.out.println("6개 일치 ("+formatter.format(LottoEnum.FIRST.getNumber())+"원) - "+count+"개");
        winLottoResult.profitMoney += count * LottoEnum.FIRST.getNumber();
    }
    public void totalBenefit(double yield) {
        System.out.println("총 수익률은 "+yield+"%입니다.");
    }
}