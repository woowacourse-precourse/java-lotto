package lotto.view;

import static lotto.domain.winning.WinningRank.*;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.winning.WinningRank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static final String PREFIX_LETTER_FOR_DISPLAY = "[";
    public static final String SUFFIX_LETTER_FOR_DISPLAY = "]";
    public static final String DELIMITER = ", ";

    public static final String BREAK_LINE = System.lineSeparator();
    public static final String RESULT_MESSAGE = BREAK_LINE + "당첨 통계" + BREAK_LINE + "---";

    private static final String RESULT_THREE_MATCH = "3개 일치 (5,000원) - %d개";
    private static final String RESULT_FOUR_MATCH = BREAK_LINE + "4개 일치 (50,000원) - %d개";
    private static final String RESULT_FIVE_MATCH = BREAK_LINE + "5개 일치 (1,500,000원) - %d개";
    private static final String RESULT_FIVE_MATCH_ONE_BONUS = BREAK_LINE + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String RESULT_SIX_MATCH = BREAK_LINE + "6개 일치 (2,000,000,000원) - %d개";

    public static final String INPUT_MESSAGE_FOR_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_MESSAGE_FOR_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_MESSAGE_FOR_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String FORMAT_FOR_COUNT_OF_TICKETS = "%n%d개를 구매했습니다. %n";
    public static final String FORMAT_FOR_YIELD = BREAK_LINE + "총 수익률은 %.1f%%입니다.";

    public static void print(String message) {
        System.out.println(message);
    }

    public void printCountOfLottoTickets(int count) {
        System.out.printf(FORMAT_FOR_COUNT_OF_TICKETS, count);
    }

    public void printAllLottoTickets(List<Lotto> lottoTickets) {
        lottoTickets.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        String lottoText = convertText(lotto.getLotto());
        print(lottoText);
    }

    private String convertText(List<LottoNumber> lottoNumbers) {
        List<String> status = lottoNumbers.stream()
                .map(numbers -> String.valueOf(numbers.getNumber()))
                .collect(Collectors.toList());
        return PREFIX_LETTER_FOR_DISPLAY + String.join(DELIMITER, status) + SUFFIX_LETTER_FOR_DISPLAY;
    }

    public void printResult(Map<WinningRank, Integer> ranks, double yield) {
        System.out.println(RESULT_MESSAGE);
        System.out.printf(RESULT_THREE_MATCH, ranks.getOrDefault(FIFTH, 0));
        System.out.printf(RESULT_FOUR_MATCH, ranks.getOrDefault(FOURTH, 0));
        System.out.printf(RESULT_FIVE_MATCH, ranks.getOrDefault(THIRD, 0));
        System.out.printf(RESULT_FIVE_MATCH_ONE_BONUS, ranks.getOrDefault(SECOND, 0));
        System.out.printf(RESULT_SIX_MATCH, ranks.getOrDefault(FIRST, 0));

        System.out.printf(FORMAT_FOR_YIELD, yield);
    }
}
