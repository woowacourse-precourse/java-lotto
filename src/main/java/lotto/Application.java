package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Issue;
import lotto.domain.LottoService;
import lotto.domain.impl.IssueImpl;
import lotto.domain.impl.LottoServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Character.*;
import static lotto.Constants.COMMA;
import static lotto.Constants.COUNT_DEFAULT_VALUE;
import static lotto.Rank.*;
import static lotto.message.ExceptionMessage.*;
import static lotto.message.Message.*;

public class Application {

    private static final Issue issue = new IssueImpl();
    private static final LottoService lottoService = new LottoServiceImpl();

    public static void main(String[] args) {
        try {
            int amount = requestAmount();
            List<Lotto> issuedLottes = createLottos(amount);
            printIssuedLottos(issuedLottes);
            PrizeNumber prizeNumber = requestPrizeNumber();
            Map<Rank, Integer> results = getLottoResults(issuedLottes, prizeNumber);
            printResults(results);
            double rate = getRate(results, amount);
            printRate(rate);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
        }
    }

    private static PrizeNumber requestPrizeNumber() {
        List<Integer> numbers = requestNumbers();
        int bonusNumber = requestBonusNumber();
        return new PrizeNumber(numbers, bonusNumber);
    }

    private static List<Lotto> createLottos(int amount) {
        return issue.createLottos(amount);
    }

    private static Map<Rank, Integer> getLottoResults(List<Lotto> issuedLottos, PrizeNumber prizeNumber) {
        return lottoService.compare(issuedLottos, prizeNumber);
    }

    private static double getRate(Map<Rank, Integer> results, int amount) {
        return lottoService.calculateRate(results, amount);
    }

    private static int requestAmount() {
        System.out.println(REQUEST_AMOUNT);
        String input = Console.readLine();
        typeValidate(input);
        return Integer.parseInt(input);
    }

    private static void typeValidate(String target) {
        for (char ch : target.toCharArray()) {
            if (!isDigit(ch)) {
                throw new IllegalArgumentException(TYPE_EXCEPTION);
            }
        }
    }

    private static List<Integer> requestNumbers() {
        System.out.println(REQUEST_PRIZE_NUMBERS);
        String input = Console.readLine();

        return Arrays.stream(input.split(COMMA))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static int requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        typeValidate(input);
        return Integer.parseInt(input);
    }

    private static void printIssuedLottos(List<Lotto> lottos) {
        String message = String.format(RESPONSE_LOTTO_SIZE, lottos.size());
        System.out.println(message);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printResults(Map<Rank, Integer> results) {
        System.out.println(RESULTS);
        System.out.println(DIV_LINE);
        for (Rank rank : Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST)) {
            int count = results.getOrDefault(rank, COUNT_DEFAULT_VALUE);
            System.out.println(rank.getMessage(count));
        }
    }

    private static void printRate(double rate) {
        String message = String.format(RESPONSE_RATE, rate);
        System.out.println(message);
    }

    private static void printExceptionMessage(IllegalArgumentException e) {
        System.out.println(PREFIX + e.getMessage());
    }
}
