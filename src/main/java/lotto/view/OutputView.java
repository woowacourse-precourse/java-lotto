package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

import java.util.List;
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


}
