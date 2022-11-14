package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class LottoGame {
    private static final String inputSuffix = "을(를) 입력해 주세요.";
    private static final String resultPrefix = "당첨 통계\n---";

    private final WinningNumbers winningNumbers;
    private final Person person;

    private LottoGame(WinningNumbers winningNumbers, Person person) {
        this.winningNumbers = winningNumbers;
        this.person = person;
    }

    public static LottoGame start() {
        Person person = generatePerson();
        WinningNumbers winningNumbers = generateWinningNumbers();
        return new LottoGame(winningNumbers, person);
    }

    private static Person generatePerson() {
        System.out.println(Constants.MONEY + inputSuffix);
        Person person = Person.from(Parser.money(Console.readLine()));
        person.printLottos();
        return person;
    }

    private static WinningNumbers generateWinningNumbers() {
        System.out.println(Constants.WINNING_NUMBER + inputSuffix);
        Lotto winningNumbers = new Lotto(Parser.numbers(Console.readLine()));

        System.out.println(Constants.BONUS + inputSuffix);
        int bonusNumber = Parser.number(Console.readLine());
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public void result() {
        System.out.println(resultPrefix);
        printResult(person.matchResult(winningNumbers));
    }

    private void printResult(Map<Rank, Integer> matchResult) {
        for (Rank rank : matchResult.keySet()) {
            if (rank == Rank.OUT) {
                continue;
            }
            System.out.printf(rank + " - %d개\n", matchResult.get(rank));
        }
        String printYield = String.format("총 수익률은 %.1f%%입니다.", person.yield(matchResult));
        System.out.println(printYield);
    }
}
