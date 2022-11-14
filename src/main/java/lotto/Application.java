package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    static final int REWARD_FIRST = 2000000000;
    static final int REWARD_SECOND = 30000000;
    static final int REWARD_THIRD = 1500000;
    static final int REWARD_FOURTH = 50000;
    static final int REWARD_FIFTH = 5000;

    public static void main(String[] args) {

        String purchaseAmount;
        Integer numberOfLottoes;
        List<Lotto> lottoes;
        List<Integer> winningNumbers;
        Integer bonus;
        List<Integer> stats = new ArrayList<>();
        Grade grade;

        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Console.readLine();
        numberOfLottoes =
                getTheNumberOfLottoesAsMuchThePurchaseAmount(
                        Integer.parseInt(purchaseAmount)
                );
        System.out.println(numberOfLottoes + "개를 구매했습니다.");

        lottoes = createLottoes(numberOfLottoes);
        printLottoes(lottoes);

        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = getWinningNumbers(Console.readLine());
        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = getBonus(Console.readLine());

        System.out.println("당첨 통계");
        System.out.println("---");
        stats = makeStats(lottoes, winningNumbers, bonus);
        printStats(stats);
        System.out.println("총 수익률은 " + calculateYield(stats, purchaseAmount) + "%입니다.");
    }

    public static Integer getTheNumberOfLottoesAsMuchThePurchaseAmount(Integer purchaseAmount) {
        validateNumber(purchaseAmount);
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / 1000;
    }

    public static List<Lotto> createLottoes(Integer numberOfLottoes) {
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0; i < numberOfLottoes; i++) {
            lottoes.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoes;
    }

    public static List<Integer> parseIntegerList(String numberText) {
        return Arrays.stream(numberText.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> getWinningNumbers(String numberText) {
        List<Integer> winningNumbers = parseIntegerList(numberText);

        validateSize(winningNumbers);
        validateNumbers(winningNumbers);
        validateRanges(winningNumbers);
        validateDuplicatedNumber(winningNumbers);

        return winningNumbers;
    }

    public static Integer getBonus(String numberText) {
        List<Integer> bonus = parseIntegerList(numberText);

        validateBonus(bonus);
        validateNumbers(bonus);
        validateRanges(bonus);

        return bonus.get(0);
    }

    public static void printLottoes(List<Lotto> lottoes) {
        for (int i = 0; i < lottoes.size(); i++) {
            lottoes.get(i).display();
        }
    }

    public static void printStats(List<Integer> stats) {
        System.out.println("3개 일치 (5,000원) - " + stats.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + stats.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + stats.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + stats.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + stats.get(0) + "개");
    }

    public static List<Integer> makeStats(List<Lotto> lottoes, List<Integer> winning, Integer bonus) {
        List<Integer> stats = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            stats.add(0);
        }

        for (int i = 0; i < lottoes.size(); i++) {
            Grade grade = Grade.find(match(lottoes.get(i), winning, bonus));
            stats = renew(stats, grade.toString());
        }
        return stats;
    }

    public static List<Integer> renew(List<Integer> stats, String rank) {
        List<Integer> newStats = renewWhenRankIs1Or2Or3(stats, rank);
        if (rank.equals("4등")) {
            newStats.set(3, newStats.get(3) + 1);
        }
        if (rank.equals("5등")) {
            newStats.set(4, newStats.get(4) + 1);
        }
        return newStats;

    }

    public static List<Integer> renewWhenRankIs1Or2Or3(List<Integer> stats, String rank) {
        if (rank.equals("1등")) {
            stats.set(0, stats.get(0) + 1);
        }
        if (rank.equals("2등")) {
            stats.set(1, stats.get(1) + 1);
        }
        if (rank.equals("3등")) {
            stats.set(2, stats.get(2) + 1);
        }
        return stats;
    }

    public static List<Integer> match(Lotto lotto, List<Integer> winning, Integer bonus) {
        return Arrays.asList(lotto.compareTo(winning), lotto.compareToAdditional(bonus));
    }

    public static String calculateYield(List<Integer> stats, String purchase) {
        float purchaseAmount = (float) Integer.parseInt(purchase);
        float yield = (float) (stats.get(0) * REWARD_FIRST
                + stats.get(1) * REWARD_SECOND
                + stats.get(2) * REWARD_THIRD
                + stats.get(3) * REWARD_FOURTH
                + stats.get(4) * REWARD_FIFTH
        ) / purchaseAmount * 100;
        return String.format("%.1f", yield);
    }

    public static void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000의 배수가 아닙니다.");
        }
    }

    public static void validateNumber(Integer number) {
        if (number > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] Integer.MAX_VALUE 보다 큰 값을 입력할 수 없습니다.");
        }
        if (number < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR] Integer.MIN_VALUE 보다 작은 값을 입력할 수 없습니다.");
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            validateNumber(numbers.get(i));
        }
    }

    public static void validateRange(Integer number) {
        if (number > 45) {
            throw new IllegalArgumentException("[ERROR] 45보다 큰 수를 입력할 수 없습니다.");
        }
        if (number < 1) {
            throw new IllegalArgumentException("[ERROR] 1보다 작은 수를 입력할 수 없습니다.");
        }
    }

    public static void validateRanges(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            validateRange(numbers.get(i));
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() > 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 6개 보다 많이 입력할 수 없습니다.");
        }
        if (numbers.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 6개 보다 적게 입력할 수 없습니다.");
        }
    }

    public static void validateBonus(List<Integer> numbers) {
        if (numbers.size() > 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 1개 보다 많이 입력할 수 없습니다.");
        }
        if (numbers.size() < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력하지 않았습니다.");
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 허용되지 않습니다.");
        }
    }
}
