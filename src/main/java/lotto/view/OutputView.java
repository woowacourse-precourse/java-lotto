package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.dto.LottoStatsDTO;

public class OutputView {
    private static final String INPUT_PAID_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INFO_LOTTO_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String OUTPUT_LOTTO_STATS = "\n당첨 통계\n---\n3개 일치 (5,000원) - %d개\n4개 일치 (50,000원) - %d개\n"
        + "5개 일치 (1,500,000원) - %d개\n5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n6개 일치 (2,000,000,000원) - %d개\n총 수익률은 %f%%입니다.";

    public static void printInputAmount() {
        System.out.println(INPUT_PAID_AMOUNT);
    }

    public static void printPaidLotto(Integer lottoCount, List<Lotto> paidLotto) {
        System.out.printf(INFO_LOTTO_COUNT, lottoCount);
        printLottoNumbers(paidLotto);
    }

    private static void printLottoNumbers(List<Lotto> paidLotto) {
        for (Lotto lottoNumber: paidLotto) {
            System.out.println(lottoNumber.getLottoNumbers());
        }
    }

    public static void printInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printLottoStats(LottoStatsDTO lottoStatsDTO) {
        System.out.printf(OUTPUT_LOTTO_STATS, lottoStatsDTO.getMatchThreeNumbers(), lottoStatsDTO.getMatchFourNumbers(),
            lottoStatsDTO.getMatchFourNumbers(), lottoStatsDTO.getMatchFiveNumbers(), lottoStatsDTO.getMatchFiveNumbersAndBonus(),
            lottoStatsDTO.getMatchSixNumbers(), lottoStatsDTO.getYieldPercent());
    }
}
