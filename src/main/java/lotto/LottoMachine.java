package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static int PRIZE_OFFSET = 2;
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
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    private void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");

        int totalPrize = 0;
        for (int i = Prize.values().length - PRIZE_OFFSET; i >= 0; i--) {
            Prize prize = Prize.values()[i];
            int winningCount = getWinningCount(prize);
            totalPrize += winningCount * prize.getPrizeMoney();
            String result = String.format(prize.getResultFormat(winningCount));
            System.out.println(result);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.\n", getRate(totalPrize));
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

    private float getRate(int totalPrize) {
        return (float) totalPrize / money * 100;
    }
}
