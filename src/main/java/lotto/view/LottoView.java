package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoEnum;
import lotto.model.RANKING;

public class LottoView {

    private final LottoController controller = new LottoController();
    private List<Lotto> lotteries;
    private Lotto luckyLotto;
    private int luckyNumber;

    public void addLotteries() {
        System.out.println("구매금액을 입력해주세요.");
        String line = Console.readLine();
        if (!line.matches("^\\d+000$")) {
            System.out.println("[ERROR] 천원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        try {
            lotteries = controller.createLotteries(Integer.parseInt(line) / 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 최소1장 이상 구매가능합니다. ");
            throw new IllegalArgumentException();
        }
    }

    public void printLotteries() {
        System.out.printf("%d개를 구매했습니다.\n", lotteries.size());
        for (final Lotto lotto : lotteries) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (final Integer number : lotto.getNumbers()) {
            builder.append(number);
            if (number.intValue() == lotto.getNumbers()
                .get(LottoEnum.TOTAL_LOTTO_NUMBER.getValue() - 1)) {
                continue;
            }
            builder.append(", ");
        }
        builder.append("]");
        System.out.println(builder);
    }

    public void addLuckyLotto() {
        try {
            System.out.println("당첨 번호를 입력해주세요.");
            List<Integer> numbers = new LinkedList<>();
            for (final String value : Console.readLine().split(",")) {
                numbers.add(Integer.parseInt(value));
            }
            luckyLotto = new Lotto(numbers);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요");
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호 형식이 맞지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void addBonusNumber() {
        try {
            System.out.println("보너스 번호를 입력하세요");
            String line = Console.readLine();
            luckyNumber = Integer.parseInt(line);
            if (luckyLotto.getNumbers().contains(luckyNumber)) {
                System.out.println("[ERROR] 보너스 번호가 당첨 번호에 포함되어 있습니다.");
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요");
            throw new IllegalArgumentException();
        }
    }

    public void printStatsOfWin() {
        List<RANKING> rankings = controller.generateRankings(lotteries, luckyLotto, luckyNumber);
        Map<RANKING, Integer> rankingToCount = createRankingToCount(rankings);
        double earningRate = controller.generateEarningsRate(lotteries, luckyLotto, luckyNumber);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", rankingToCount.get(RANKING.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", rankingToCount.get(RANKING.FORTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", rankingToCount.get(RANKING.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n",
            rankingToCount.get(RANKING.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", rankingToCount.get(RANKING.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningRate);
    }

    private Map<RANKING, Integer> createRankingToCount(final List<RANKING> rankings) {
        Map<RANKING, Integer> rankingToCount = new HashMap<>();
        for (final RANKING ran : RANKING.values()) {
            rankingToCount.put(ran, 0);
        }
        for (final RANKING ranking : rankings) {
            int newCount = rankingToCount.get(ranking) + 1;
            rankingToCount.put(ranking, newCount);
        }
        return rankingToCount;
    }
}
