package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    final static String BUY_LOTTO_QUESTION = "구입 금액을 입력해 주세요.";
    final static String RANK_STAT = "당첨 통계";
    final static String FIFTH_RANK = "3개 일치 (5,000원) - ";
    final static String FOURTH_RANK = "4개 일치 (50,000원) - ";
    final static String THIRD_RANK = "5개 일치 (1,500,000원) - ";
    final static String SECOND_RANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    final static String FIRST_RANK = "6개 일치 (2,000,000,000원) - ";
    final static String COUNTER = "개";

    public static void main(String[] args) {
        Generator generator = new Generator();
        Drawer drawer = new Drawer();
        try {
            Integer money = inputMoney();
            List<Lotto> lottoTickets = generator.generate(money);
            generator.printGeneratedLotto(lottoTickets);
            Lotto lotto = drawer.drawLotto();
            Integer bonusNumber = drawer.drawBonusNumber(lotto);
            List<Rank> ranks = drawer.compare(lottoTickets, lotto, bonusNumber);
            printRanks(ranks);
            System.out.println("총 수익률은 " + Drawer.Calculator.calculateYield(ranks, money) + "%입니다.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printRanks(List<Rank> ranks) {
        System.out.println(RANK_STAT);
        System.out.println("---");
        System.out.println(FIFTH_RANK + ranks.stream().filter(rank -> rank == Rank.FIFTH).count() + COUNTER);
        System.out.println(FOURTH_RANK + ranks.stream().filter(rank -> rank == Rank.FOURTH).count() + COUNTER);
        System.out.println(THIRD_RANK + ranks.stream().filter(rank -> rank == Rank.THIRD).count() + COUNTER);
        System.out.println(SECOND_RANK + ranks.stream().filter(rank -> rank == Rank.SECOND).count() + COUNTER);
        System.out.println(FIRST_RANK + ranks.stream().filter(rank -> rank == Rank.FIRST).count() + COUNTER);
    }

    public static Integer inputMoney() {
        System.out.println(BUY_LOTTO_QUESTION);
        String moneyText = Console.readLine();
        if (!moneyText.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하셨습니다.");
        }
        return Integer.valueOf(moneyText);
    }
}
