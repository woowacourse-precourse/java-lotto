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
    private static final String OUT_OF_RANGE_NUMBER_ERROR_MESSAGE = "[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String INVALID_FORMAT_ERROR_MESSAGE = "[ERROR] 올바른 입력 형태가 아닙니다.";
    private static final String INVALID_PAYMENT_ERROR_MESSAGE = "[ERROR] 구입 금앱은 1000원 단위여야 합니다.";
    private static final String INVALID_WINNING_NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호에 해당 보너스 번호가 이미 존재합니다.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 입력 값은 숫자여야 합니다.";

    public static void main(String[] args) {
        try {
            int payment = inputPrice();
            List<Lotto> lotteries = purchaseLotteries(payment);

            List<Integer> winningNumbers = inputWinningNumbers();
            int bonus = inputBonusNumber(winningNumbers);

            List<Integer> rankCount = getRankCount(
                    lotteries,
                    winningNumbers,
                    bonus
            );

            String rateOfReturn = getRateOfReturn(rankCount, payment);

            printStatistics(rankCount, rateOfReturn);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int inputPrice() {
        // 구입 금액 입력
        System.out.println(INPUT_PAYMENT_SENTENCE);
        String paymentInput = Console.readLine();
        validateNumber(paymentInput);
        int payment = Integer.parseInt(paymentInput);
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PAYMENT_ERROR_MESSAGE);
        }
        System.out.println();
        return payment;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_SENTENCE);
        List<Integer> winningNumbers;
        try {
            winningNumbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR_MESSAGE);
        }
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
        System.out.println();
        return winningNumbers;
    }

    public static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size()!=6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    public static void validateWinningNumbersRange(List<Integer> winningNumbers){
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(INPUT_BONUS_NUMBER_SENTENCE);
        String bonusInput = Console.readLine();
        validateBonusNumber(bonusInput, winningNumbers);
        int bonus = Integer.parseInt(bonusInput);
        System.out.println();
        return bonus;
    }

    public static void validateBonusNumber(
            String bonusInput,
            List<Integer> winningNumbers
    ) {
        // String의 input이 Integer로 제대로 변환되는지 확인
        validateNumber(bonusInput);

        int bonus = Integer.parseInt(bonusInput);

        // 1~45 범위의 수인지 확인
        validateValidRangeNumber(bonus);

        // 보너스 번호가 당첨 번호에 있는지 확인
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateNumber(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateValidRangeNumber(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR_MESSAGE);
        }
    }

    public static List<Integer> generateSortedRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> newNumbers = new ArrayList<>(numbers);
        Collections.sort(newNumbers);
        return newNumbers;
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
