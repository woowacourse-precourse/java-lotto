package lotto;

import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class LottoStore {
    private static final String BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BOUGHT_NUMBER_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---\n" +
            "3개 일치 (5,000원) - %d개\n" + "4개 일치 (50,000원) - %d개\n" + "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" + "6개 일치 (2,000,000,000원) - %d개";
    private static final String RATE_OF_RETURN = "총 수익률은 %f%입니다.";

    public LottoStore() {}

    public void buyAndDraw() {
        buyMessage();

    }

    private void buyMessage() {
        System.out.println(BUY_MESSAGE);
    }

    private void inputWinningNumbers() {
        String input = Console.readLine();
        List<Integer> winningNumbers = stringToIntegerList(input);
        Lotto lotto = new Lotto(winningNumbers);
    }

    private List<Integer> stringToIntegerList(String string) {
        String[] numbers = string.split(",");
        List<Integer> newNumbers = Arrays.asList(numbers).stream()
                                    .map(s -> Integer.parseInt(s))
                                    .collect(Collectors.toList());
        return newNumbers;
    }
}
