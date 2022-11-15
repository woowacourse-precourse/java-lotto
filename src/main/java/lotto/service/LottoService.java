package lotto.service;

import lotto.domain.Issue;
import lotto.domain.Lotto;
import lotto.ui.ExceptionMsg;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LottoService {
    private List<Lotto> history;
    private Lotto win;
    private final Output output;
    private final Input input;
    private Issue issue;

    public LottoService() {
        output = new Output();
        input = new Input();
    }

    public static boolean isOnlyNumbers(String target) {
        return target.replaceAll("[^0-9]", "").length() == target.length();
    }

    final public void start() {
        create();
        showHistory();
        createWinNum();
        createBonusNum();
        winStatistics();
        revenue();
    }

    private void create() {
        output.moneyInform();
        issue = new Issue(input.number());
        history = issue.lotto();
    }

    private void showHistory() {
        output.amount(history.size());
        output.lottoHistory(history);
    }


    private void createWinNum() {
        output.winningNum();
        String[] targetNumber = input.number().split(",");
        for (String number : targetNumber) {
            if (!isOnlyNumbers(number)) {
                throw new IllegalArgumentException(ExceptionMsg.LOTTO_NUMBER);
            }
        }
        Integer[] numbers = Stream.of(targetNumber)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        win = new Lotto(Arrays.asList(numbers));
    }

    private void createBonusNum() {
        output.bonusNum();
        win.addBonusNum(input.number());
    }

    private void winStatistics() {
        for (Lotto numbers : history) {
            int count = win.compare(numbers);
            if (count == 5 && numbers.hasBonusNum(win)) {
                CoincideNumber.plusCountOfRank(5);
                continue;
            }
            int rank = 7 - count;
            if (rank < 5) {
                CoincideNumber.plusCountOfRank(rank);
            }
        }
        output.winStatistics();
    }

    private void revenue() {
        double revenue = 0;
        for (CoincideNumber coincideNumber : CoincideNumber.values()) {
            if (coincideNumber.count() != 0) {
                revenue = revenue + coincideNumber.calculateRevenue();
            }
        }
        output.revenue(issue.revenue(revenue));
    }


}
