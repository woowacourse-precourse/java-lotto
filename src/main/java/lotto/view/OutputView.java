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

    public static final String INPUT_MESSAGE_FOR_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_MESSAGE_FOR_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_MESSAGE_FOR_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String FORMAT_FOR_COUNT_OF_TICKETS = "%n%d개를 구매했습니다. %n";

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

    public void printLottoResultMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printResult(Map<WinningRank, Integer> ranks, double yield) {
        System.out.println("3개 일치 (" + FIFTH.getPrize() + "원)-" + ranks.getOrDefault(FIFTH, 0) + "개");
        System.out.println("4개 일치 (" + FOURTH.getPrize() + "원)-" + ranks.getOrDefault(FOURTH, 0) + "개");
        System.out.println("5개 일치 (" + THIRD.getPrize() + "원)-" + ranks.getOrDefault(THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(" + SECOND.getPrize() + "원)-" + ranks.getOrDefault(SECOND, 0) + "개");
        System.out.println("6개 일치 (" + FIRST.getPrize() + "원)-" + ranks.getOrDefault(FIRST, 0) + "개");

        System.out.printf("총 수익률은 %.2f 입니다.", yield);
    }
}
