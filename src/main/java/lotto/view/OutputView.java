package lotto.view;

import java.text.MessageFormat;
import java.util.List;
import lotto.Lotto;

public enum OutputView {

    LOTTO_COUNT_MESSAGE("\n{0}개를 구매했습니다."),
    PROFIT_START_MESSAGE("당첨 통계"),
    PROFIT_SEPARATOR_MESSAGE("---"),
    PROFIT_INFORMATION_MESSAGE("{0}개 일치{1} ({2,number}원) - {3}개"),
    PROFIT_RATIO_MESSAGE("{0}개 일치{1} ({2,number}원) - {3}개"),
    BONUS_BALL_MESSAGE(", 보너스 볼 일치");

    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public static void printLottoInformation(List<Lotto> lottos) {
        System.out.println(MessageFormat.format(LOTTO_COUNT_MESSAGE.toString(), lottos.size()));
        lottos.forEach(System.out::println);
    }
}
