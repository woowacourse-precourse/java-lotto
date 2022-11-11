package lotto.presentation.view;

import constants.LottoGameMessage;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Match;

public class LottoGamePrinter {

    public static void printEnterLottoAmount() {
        System.out.println(LottoGameMessage.READ_LOTTO_COUNT);
    }

    public static void printEnterWinNumber() {
        System.out.println(LottoGameMessage.READ_WIN_NUMBER);
    }

    public static void printEnterBonusNumber() {
        System.out.println(LottoGameMessage.READ_BONUS_NUMBER);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto));
    }

    public static void printMatchResult(List<Match> matches) {
        System.out.println(LottoGameMessage.PRINT_MATCH_RESULT_PREFIX);
        Arrays.stream(Match.values())
                        .forEach(match -> printMatchCase(matches,match));
    }

    public static void printMatchCase(List<Match> matches, Match writeMatch) {
        if (writeMatch.equals(Match.NO_MATCH)) {
            return;
        }
        long count = matches.stream()
                .filter(match -> match.equals(writeMatch))
                .count();

        System.out.printf(writeMatch.resultMessage+System.lineSeparator(),count);
    }

}
