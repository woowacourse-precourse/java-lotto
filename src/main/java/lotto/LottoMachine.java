package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static int PRIZE_OFFSET = 2;
    static UserInput userInput = new UserInput();
    static Generator generator = new Generator();

    private List<Lotto> lottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public void start() {
        int money = userInput.getMoney();
        int amount = userInput.getAmount(money);

        lottos = generateLottos(amount);
        printLottos();

        winningLotto = userInput.getWinningLotto();
        bonusNumber = userInput.getBonusNumber(winningLotto);

        printResult(money);
    }

    private void printResult(int money) {
        System.out.println("당첨 통계");
        System.out.println("---");

        int totalPrize = 0;
        for (int i = Prize.values().length - PRIZE_OFFSET; i >= 0; i--) {
            Prize prize = Prize.values()[i];
            int winningCount = getWinningCount(prize);
            totalPrize += winningCount * prize.getPrizeMoney();
            String result = prize.getResultFormat(winningCount);
            System.out.println(result);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.", getRate(money, totalPrize));
    }

    private List<Lotto> generateLottos(int amount) {
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
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isMatchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private float getRate(int money, int totalPrize) {
        return (float) totalPrize / money * 100;
    }
}
