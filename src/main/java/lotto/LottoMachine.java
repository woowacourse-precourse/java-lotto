package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    static UserInput userInput = new UserInput();
    static Generator generator = new Generator();

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int money;
    private int amount;

    public void start() {
        money = userInput.getMoney();
        amount = userInput.getAmount(money);

        lottos = generateLottos();
        printLottos();

        winningNumbers = userInput.getWinningNumbers();
        bonusNumber = userInput.BonusNumber(winningNumbers);
        printResult();
    }

    private List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottos.add(generator.generateLotto());
        }
        return lottos;
    }

    private void printLottos() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
        System.out.println();
    }

    private void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");

        int totalPrize = 0;
        for (int i = Prize.values().length - 1; i >= 0; i--) {
            Prize prize = Prize.values()[i];
            int winningCount = getWinningCount(prize);
            totalPrize += winningCount * prize.getPrizeMoney();
            String result = String.format("%d개 일치 (%s) - %d개",
                    prize.getMatchCount(), prize.getPrizeString(), winningCount);
            System.out.println(result);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.\n", (float) totalPrize / money * 100);
    }

    private int getWinningCount(Prize prize) {
        int winningCount = 0;
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto);
            boolean matchBonus = isMatchBonus(lotto);
            if (Prize.getPrize(matchCount, matchBonus) == prize) {
                winningCount++;
            }
        }
        return winningCount;
    }

    private int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isMatchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
