package lotto.view;

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
    private final String MSG_TOTAL_SUFFIX = "입니다.";

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

    public void printBoughtLotto(List<List<Integer>> boughtLottos) {
        for (List<Integer> lotto : boughtLottos) {
            printLottoNumbersInFormat(lotto);
        }
    }

    private void printLottoNumbersInFormat(List<Integer> numbers) {
        String delimiter = ", ";
        StringJoiner joiner = new StringJoiner(delimiter);
        numbers.forEach(item -> joiner.add(String.valueOf(item)));
        System.out.println("[" + joiner + "]");
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
