package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class View {
    private static final String WELCOME_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String COUNT_MESSAGE = "개를 구매하였습니다.";
    private static final String INPUT_WINNING_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해주세요.";
    private static final String WINNING_STATIC_MESSAGE = "당첨통계\n---";
    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printLottoCountMessage(int count) {
        System.out.println(count + COUNT_MESSAGE);
    }

    public void printLottosInfoByBuyer(Lottos lottos) {
        lottos.forEach((lotto) -> System.out.println(lotto.getNumbers()));
    }

    public void printInputWinningMessage() {
        System.out.println(INPUT_WINNING_MESSAGE);
    }

    public void printInputBonusMessage() {
        System.out.println(INPUT_BONUS_MESSAGE);
    }

    public void printWinningStatics() {
        System.out.println(WINNING_STATIC_MESSAGE);
    }
}
