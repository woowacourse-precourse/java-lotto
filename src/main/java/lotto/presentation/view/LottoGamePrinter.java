package lotto.presentation.view;

import constants.LottoGameMessage;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Match;

public class LottoGamePrinter {

    public void printEnterLottoAmount() {
        System.out.println(LottoGameMessage.READ_LOTTO_AMOUNT);
    }

    public void printEnterWinNumber() {
        System.out.println(LottoGameMessage.READ_WIN_NUMBER);
    }

    public void printEnterBonusNumber() {
        System.out.println(LottoGameMessage.READ_BONUS_NUMBER);
    }

    public void printLottoCount(int lottoCount) {
        System.out.printf(LottoGameMessage.PRINT_LOTTO_COUNT,lottoCount);
        lineBreak();
    }

    public void printLottosOrderByAsc(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
                lotto.sortAscending();
                System.out.println(lotto);});
    }

    public void printMatchResult(List<Match> matches) {
        System.out.println(LottoGameMessage.PRINT_MATCH_RESULT_PREFIX);
        Arrays.stream(Match.values())
                .forEach(match -> printMatchCase(matches, match));
    }

    public void printMatchCase(List<Match> matches, Match writeMatch) {
        if (writeMatch.equals(Match.NO_MATCH)) {
            return;
        }
        long count = matches.stream()
                .filter(match -> match.equals(writeMatch))
                .count();

        System.out.printf(writeMatch.resultMessage, count);
        lineBreak();
    }

    public void printProfit(double profit) {
        String roundProfit = String.format("%.1f",profit);
        System.out.printf(LottoGameMessage.PRINT_PROFIT,roundProfit);
        lineBreak();
    }

    public void lineBreak() {
        System.out.println();
    }

}
