package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.LottoResult.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        final String payment = readLine();
        validatePayment(payment);

        final int pay = Integer.parseInt(payment);
        System.out.printf("%n%d개를 구매했습니다.%n", pay / 1000);
        List<Lotto> lottos = getLottos(pay / 1000);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        final String[] winningNumbers = readLine().split("[\\s]*[,][\\s]*");
        validateWinningNumbers(winningNumbers);
        final int[] winningNums = Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        final String bonusNumber = readLine();
        validateBonusNumber(bonusNumber);
        checkDuplicated(winningNums, Integer.parseInt(bonusNumber));
        final int bonusNum = Integer.parseInt(bonusNumber);

        final List<LottoResult> lottoResults = lottos.stream()
                .map(lotto -> LottoResult.getRanking(lotto, winningNums, bonusNum))
                .collect(Collectors.toList());
        printStatistics(lottoResults, pay);
    }

    private static void printStatistics(List<LottoResult> lottoResults, int payment) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n---\n");

        for (LottoResult lottoResult : List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST)) {
            int count = (int) lottoResults.stream()
                    .filter(r -> r.equals(lottoResult))
                    .count();
            sb.append(
                    String.format("%s (%,d원) - %d개\n",
                            lottoResult.getDetails(),
                            lottoResult.getPrize(),
                            count)
            );
        }

        int sum = lottoResults.stream()
                .mapToInt(LottoResult::getPrize)
                .sum();
        sb.append(String.format("총 수익률은 %.1f%%입니다.", (float) sum / payment * 100));
        System.out.println(sb);
    }

    private static List<Lotto> getLottos(int amount) {
        List<Lotto> lottos = new LinkedList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = pickNumbers();
            Lotto lotto = new Lotto(numbers);
            System.out.println(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static List<Integer> pickNumbers() {
        List<Integer> numbers = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Integer::compareTo);
        return numbers;
    }

    private static void validatePayment(String payment) {
        validateInteger(payment);
        if (Integer.parseInt(payment) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액이 입력되었습니다.");
        }
    }

    private static void validateWinningNumbers(String[] winningNumbers) {
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 잘못 입력되었습니다.");
        }
        Arrays.stream(winningNumbers)
                .forEach(Application::validateInteger);
        Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .forEach(Application::validateRange);
    }

    private static void validateBonusNumber(String bonusNumber) {
        validateInteger(bonusNumber);
        validateRange(Integer.parseInt(bonusNumber));
    }

    private static void checkDuplicated(int[] winningNumbers, int number) {
        if (Arrays.stream(winningNumbers)
                .anyMatch(i -> i == number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다.");
        }
    }

    private static void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 값이 아닙니다.");
        }
    }
}
