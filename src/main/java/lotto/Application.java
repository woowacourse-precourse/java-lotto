package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.LottoResult.*;
import static lotto.Validation.*;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            final int payment = getPayment(readLine());
            System.out.printf("%n%d개를 구매했습니다.%n", payment / 1000);

            List<Lotto> lottos = getLottos(payment / 1000);

            System.out.println("\n당첨 번호를 입력해 주세요.");
            int[] winningNumbers = getWinningNumbers(readLine());

            System.out.println("\n보너스 번호를 입력해 주세요.");
            int bonusNumber = getBonusNumber(readLine());
            checkDuplicated(winningNumbers, bonusNumber);

            List<LottoResult> lottoResults = lottos.stream()
                    .map(lotto -> lotto.getResult(winningNumbers, bonusNumber))
                    .collect(Collectors.toList());

            String totalResult = getTotalResult(lottoResults, payment);
            System.out.println(totalResult);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPayment(String input) {
        validateInteger(input);
        validatePayment(input);
        return Integer.parseInt(input);
    }

    private static List<Lotto> getLottos(int amount) {
        List<Lotto> lottos = new LinkedList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(pickNumbers());
            System.out.println(lotto.getNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private static List<Integer> pickNumbers() {
        return new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));
    }

    private static int[] getWinningNumbers(String input) {
        final String[] winningNumbers = input.split("[\\s]*[,][\\s]*");
        validateSplitLengthSix(winningNumbers);
        validateInteger(winningNumbers);
        final int[] numbers = Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();

        validateRange(numbers);
        return numbers;
    }

    private static int getBonusNumber(String input) {
        validateInteger(input);
        validateRange(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    private static String getTotalResult(List<LottoResult> lottoResults, int payment) {
        StringBuilder sb = new StringBuilder("\n당첨 통계\n---\n");
        for (LottoResult lottoResult : List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST)) {
            sb.append(String.format(
                    "%s (%,d원) - %d개\n",
                    lottoResult.getDetails(),
                    lottoResult.getPrize(),
                    lottoResults.stream()
                            .filter(r -> r.equals(lottoResult))
                            .count()
            ));
        }

        sb.append(String.format("총 수익률은 %.1f%%입니다.", getEarningRatio(lottoResults, payment)));
        return sb.toString();
    }

    private static double getEarningRatio(List<LottoResult> lottoResults, int payment) {
        long sum = 0L;
        for (LottoResult lottoResult : lottoResults) {
            sum += lottoResult.getPrize();
        }
        return (double) sum / payment * 100;
    }
}
