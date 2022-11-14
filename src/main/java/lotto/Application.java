package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Issue;
import lotto.domain.LottoService;
import lotto.domain.impl.IssueImpl;
import lotto.domain.impl.LottoServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.lang.Character.*;
import static lotto.Rank.*;
import static lotto.message.ExceptionMessage.TYPE_EXCEPTION;

public class Application {

    private static final Issue issue = new IssueImpl();
    private static final LottoService lottoService = new LottoServiceImpl();

    public static void main(String[] args) {
        try {
            int amount = requestAmount();
            List<Lotto> userLottos = issue.createLotto(amount);
            printLottos(userLottos);
            Lotto prizeLotto = requestPrizeNumbers();
            int bonusNumber = requestBonusNumber();
            Map<Rank, Integer> results = lottoService.compare(userLottos, prizeLotto, bonusNumber);
            printResults(results);
            double rate = lottoService.calculateRate(results, amount);
            printRate(rate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int requestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validate(input);
        return Integer.parseInt(input);
    }

    private static void validate(String target) {
        for (char ch : target.toCharArray()) {
            if (!isDigit(ch)) {
                throw new IllegalArgumentException(TYPE_EXCEPTION);
            }
        }
    }

    private static Lotto requestPrizeNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        List<Integer> prizeNumbers = new ArrayList<>();
        for (String number : input.split(",")) {
            prizeNumbers.add(Integer.valueOf(number));
        }
        return new Lotto(prizeNumbers);
    }

    private static int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validate(input);
        return Integer.parseInt(input);
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printResults(Map<Rank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST)) {
            int count = results.getOrDefault(rank, 0);
            System.out.println(rank.getMessage(count));
        }
    }

    private static void printRate(double rate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", rate));
    }
}
