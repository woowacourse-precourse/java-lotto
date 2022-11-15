package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        System.out.println("\n" + lotteries.size() + "개를 구매했습니다.");
        for (Lotto lottery : lotteries) {
            List<Integer> lotteryNumbers = lottery.getNumbers()
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList());

            System.out.println(lotteryNumbers);
        }
    }

    /**
     * 로또 당첨 번호 입력해 달라는 문구 출력
     */
    public void printInputLottoWinNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    /**
     * 로또 보너스 번호 입력해 달라는 문구 출력
     */
    public void printInputLottoBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
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
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoProfitRate);
    }
}
