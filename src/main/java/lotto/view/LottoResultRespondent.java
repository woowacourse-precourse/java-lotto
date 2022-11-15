package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoGrade;
import lotto.service.LottoService;

public class LottoResultRespondent {

    private LottoService lottoService = new LottoService();

    public void printLottoResult(Lotto lotto, User user) {
        printLottoResultTitle();
        Integer lottoWinningPrice = printLottoWinningResult(
                lottoService.getLottoWinningResult(lotto, user));
        printLottoStat(user, lottoWinningPrice);
    }

    private void printLottoResultTitle() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private Integer printLottoWinningResult(List<LottoGrade> lottoWinningResult) {
        Integer lottoWinningProfitAmount = 0;
        Integer gradeFifthFrequency = Collections.frequency(lottoWinningResult, LottoGrade.FIFTH);
        System.out.println("3개 일치 (5,000원) - " + gradeFifthFrequency + "개");
        lottoWinningProfitAmount += gradeFifthFrequency * 5000;
        Integer gradeFourthFrequency = Collections.frequency(lottoWinningResult, LottoGrade.FOURTH);
        System.out.println("4개 일치 (50,000원) - " + gradeFourthFrequency + "개");
        lottoWinningProfitAmount += gradeFourthFrequency * 50000;
        Integer gradeThirdFrequency = Collections.frequency(lottoWinningResult, LottoGrade.THIRD);
        System.out.println("5개 일치 (1,500,000원) - " + gradeThirdFrequency + "개");
        lottoWinningProfitAmount += gradeThirdFrequency * 1500000;
        Integer gradeSecondFrequency = Collections.frequency(lottoWinningResult, LottoGrade.SECOND);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + gradeSecondFrequency + "개");
        lottoWinningProfitAmount += gradeSecondFrequency * 30000000;
        Integer gradeFirstFrequency = Collections.frequency(lottoWinningResult, LottoGrade.FIRST);
        System.out.println("6개 일치 (2,000,000,000원) - " + gradeFirstFrequency + "개");
        lottoWinningProfitAmount += gradeFirstFrequency * 2000000000;
        return lottoWinningProfitAmount;
    }

    private void printLottoStat(User user, Integer lottoWinningPrice) {
        Integer totalPriceAmount = user.getLottoPrice();
        Float profitPercent = (float) lottoWinningPrice / totalPriceAmount;
        System.out.println(
                "총 수익률은 " + String.format(String.valueOf(profitPercent * 100), "%.1f") + "%입니다.");
    }
}
