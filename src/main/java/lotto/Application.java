package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final String INPUT_PAYMENT_SENTENCE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_SENTENCE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_SENTENCE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_SENTENCE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_SENTENCE = "당첨 통계\n---";
    private static final String FIFTH_PLACE_SENTENCE = "3개 일치 (5,000원) - ";
    private static final String FOURTH_PLACE_SENTENCE = "4개 일치 (50,000원) - ";
    private static final String THIRD_PLACE_SENTENCE = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_PLACE_SENTENCE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_PLACE_SENTENCE = "6개 일치 (2,000,000,000원) - ";

    public static void main(String[] args) {
        int payment = inputPrice();
        List<Lotto> lotteries = purchaseLotteries(payment);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonus = inputBonusNumber();

        List<Integer> rankCount = getRankCount(
                lotteries,
                winningNumbers,
                bonus
        );

        String rateOfReturn = getRateOfReturn(rankCount, payment);

        printStatistics(rankCount, rateOfReturn);
    }

    public static int inputPrice() {
        // 구입 금액 입력
        System.out.println(INPUT_PAYMENT_SENTENCE);
        int payment;
        try {
            payment = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        System.out.println();
        return payment;
    }

    public static List<Integer> inputWinningNumbers() {
        // 당첨 번호 입력
        System.out.println(INPUT_WINNING_NUMBERS_SENTENCE);
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println();
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        // 보너스 번호 입력
        System.out.println(INPUT_BONUS_NUMBER_SENTENCE);
        int bonus = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonus;
    }

    public static List<Integer> generateSortedRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public static List<Lotto> purchaseLotteries(int payment) {
        List<Lotto> lotteries = new ArrayList<>(); // 로또들을 저장할 list 생성

        int amount = payment / 1000;
        System.out.println(amount + PURCHASE_SENTENCE);
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = generateSortedRandomNumbers();
            System.out.println(numbers.toString());
            Lotto lotto = new Lotto(numbers);
            lotteries.add(lotto);
        }
        System.out.println();
        return lotteries;
    }

    public static List<Integer> checkLottery(
            Lotto lotto,
            List<Integer> winningNumbers,
            int bonus
    ) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> hitCountAndBonusHitCount = Arrays.asList(0, 0);
        int cnt = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                cnt++;
            }
        }
        hitCountAndBonusHitCount.set(0, cnt);
        if (numbers.contains(bonus)) {
            hitCountAndBonusHitCount.set(1, 1);
        }
        return hitCountAndBonusHitCount;
    }

    public static int getRankIndex(
            int hitCount,
            int bonusHitCount
    ) {
        if (hitCount == 3) return 5;
        if (hitCount == 4) return 4;
        if (hitCount == 5 && bonusHitCount == 0) return 3;
        if (hitCount == 5 && bonusHitCount == 1) return 2;
        if (hitCount == 6) return 1;
        return 0;
    }

    public static List<Integer> getRankCount(
            List<Lotto> lotteries,
            List<Integer> winningNumbers,
            int bonus
    ) {
        List<Integer> rankCountList = Arrays.asList(0, 0, 0, 0, 0, 0);
        lotteries.forEach(lotto -> {
            List<Integer> hitCountAndBonusHitCount = checkLottery(lotto, winningNumbers, bonus);
            int hitCount = hitCountAndBonusHitCount.get(0);
            int bonusHitCount = hitCountAndBonusHitCount.get(1);
            int rankIndex = getRankIndex(hitCount, bonusHitCount);
            rankCountList.set(rankIndex, rankCountList.get(rankIndex) + 1);
        });
        return rankCountList;
    }

    public static String getRateOfReturn(
            List<Integer> rankCount,
            int payment
    ) {
        int priceSum = rankCount.get(1) * WinningReward.FIRST.getPrice()
                + rankCount.get(2) * WinningReward.SECOND.getPrice()
                + rankCount.get(3) * WinningReward.THIRD.getPrice()
                + rankCount.get(4) * WinningReward.FOURTH.getPrice()
                + rankCount.get(5) * WinningReward.FIFTH.getPrice();
        double rateOfReturn = (double) priceSum / payment * 100;
        return String.format("%.1f", rateOfReturn);
    }

    public static void printStatistics(
            List<Integer> rankCount,
            String rateOfReturn
    ) {
        System.out.println(WINNING_STATISTICS_SENTENCE);
        System.out.println(FIFTH_PLACE_SENTENCE + rankCount.get(5) + "개");
        System.out.println(FOURTH_PLACE_SENTENCE + rankCount.get(4) + "개");
        System.out.println(THIRD_PLACE_SENTENCE + rankCount.get(3) + "개");
        System.out.println(SECOND_PLACE_SENTENCE + rankCount.get(2) + "개");
        System.out.println(FIRST_PLACE_SENTENCE + rankCount.get(1) + "개");
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
