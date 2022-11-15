package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinCount;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private final String MSG_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String MSG_LOTTO_PURCHASED = "개를 구매했습니다.";
    private final String MSG_INPUT_WIN_NUMBER = "당첨 번호를 입력해주세요.";
    private final String MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해주세요.";
    private final String MSG_STATUS = "당첨 통계";
    private final String MSG_DIVIDER = "---";
    private final String MSG_TOTAL_PREFIX = "총 수익률은 ";
    private final String MSG_TOTAL_SUFFIX = "%입니다.";

    private final String threeHit = "3개 일치 (5,000원) - ";
    private final String fourHit = "4개 일치 (50,000원) - ";
    private final String fiveHit = "5개 일치 (1,500,000원) - ";
    private final String fiveHitAndBonus = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final String sixHit = "6개 일치 (2,000,000,000원) - ";
    private final String hitSuffix = "개";

    public void announceInputMoney() {
        System.out.println(MSG_INPUT_MONEY);
    }

    public void announceBuyResult(int lottoCount) {
        System.out.println(lottoCount + MSG_LOTTO_PURCHASED);
    }

    public void announceInputWinNumber() {
        System.out.println(MSG_INPUT_WIN_NUMBER);
    }

    public void announceInputBonusNumber() {
        System.out.println(MSG_INPUT_BONUS_NUMBER);
    }

    public void announceResult() {
        System.out.println(MSG_STATUS);
    }

    public void printBoughtLotto(List<Lotto> boughtLottos) {
        for (Lotto lotto : boughtLottos) {
            printLottoNumbersInFormat(lotto.getNumbers());
        }
    }

    private void printLottoNumbersInFormat(List<Integer> numbers) {
        String delimiter = ", ";
        StringJoiner joiner = new StringJoiner(delimiter);
        numbers.forEach(item -> joiner.add(String.valueOf(item)));
        System.out.println("[" + joiner + "]");
    }

    public void printWinCount(WinCount winCount) {
        System.out.println(threeHit + winCount.getFifth() + hitSuffix);
        System.out.println(fourHit + winCount.getFourth() + hitSuffix);
        System.out.println(fiveHit + winCount.getThird() + hitSuffix);
        System.out.println(fiveHitAndBonus + winCount.getSecond() + hitSuffix);
        System.out.println(sixHit + winCount.getFirst() + hitSuffix);
    }

    public void printProfitRatio(String ratio) {
        System.out.println(MSG_TOTAL_PREFIX + ratio + MSG_TOTAL_SUFFIX);
    }

    public void printDivider() {
        System.out.println(MSG_DIVIDER);
    }

    public void printSpacer() {
        System.out.println();
    }
}
