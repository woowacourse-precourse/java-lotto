package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.dto.LottoStatsDTO;

public class OutputView {
    private static final String INPUT_PAID_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INFO_LOTTO_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

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
}
