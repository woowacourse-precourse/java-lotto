package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

/**
 * 도메인에 관한 출력 UI
 */
public class OutputUi {

    /**
     * 사용자에게 로또 구입금액을 입력해 달라는 문구 출력
     */
    public void printBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    /**
     * 로또 수량과 로또 번호 출력 하기
     */
    public void printLottoAmountAndNumber(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (Lotto lottery : lotteries) {
            System.out.println(lottery.toString());
        }
    }

    /**
     * 로또 당첨 번호 입력해 달라는 문구 출력
     */
    public void printInputLottoWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    /**
     * 사용자 로또 당첨된 개수와 정보 출력
     */
    public void printWinLottoAmountsInformation(Map<LottoRank, Integer> lottoWinAmounts) {
        System.out.println("\n당첨통계\n---");
        for (LottoRank lottoRank : lottoWinAmounts.keySet()) {
            System.out.println(lottoRank.getRankMessage() + " - " + lottoWinAmounts.get(lottoRank) + "개");
        }
    }

    /**
     * 사용자 로또 수익률 출력 로직
     */
    public void printLottoProfitRate(double lottoProfitRate) {
        System.out.printf("%.1f", lottoProfitRate);
    }
}
