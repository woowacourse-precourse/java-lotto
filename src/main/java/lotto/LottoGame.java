package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class LottoGame {
    private final WinningNumbers winningNumbers;
    private final Person person;

    private LottoGame(WinningNumbers winningNumbers, Person person) {
        this.winningNumbers = winningNumbers;
        this.person = person;
    }

    public static LottoGame start() {
        System.out.println("구입금액을 입력해 주세요.");
        Person person = Person.from(Parser.money(Console.readLine()));
        person.printLottos();

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningNumbers = new Lotto(Parser.numbers(Console.readLine()));
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Parser.number(Console.readLine());
        WinningNumbers winner = new WinningNumbers(winningNumbers, bonusNumber);

        return new LottoGame(winner, person);
    }

    public void result() {
        System.out.println("당첨 통계");
        System.out.println("---");
        printResult(person.matchResult(winningNumbers));
    }

    private void printResult(Map<Rank, Integer> matchResult) {
        for (Rank rank : matchResult.keySet()) {
            if (rank == Rank.OUT) {
                continue;
            }
            System.out.printf(rank + " - %d개\n", matchResult.get(rank));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", person.yield(matchResult));
    }
}
