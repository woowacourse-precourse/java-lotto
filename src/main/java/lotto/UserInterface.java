package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserInterface {
    public void printLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toStringLotto());
        }
    }

    public void printResult(Map<WinningResult, Integer> statistics, double revenue) {
        List<WinningResult> winningResults = Arrays.asList(WinningResult.values());
        Collections.reverse(winningResults);
        System.out.print("\n당첨 통계\n---");
        for (WinningResult wr : winningResults) {
            printStatistics(wr, wr.getMatchCount(), wr.getReward(), statistics.getOrDefault(wr, 0));
        }
        printRevenueRate(revenue);
    }

    private void printStatistics(WinningResult wr, int matchCount, int reward, int winningCount) {
        if (wr.equals(WinningResult.LOSER)) {
            return;
        }
        if (wr.equals(WinningResult.SECOND)) {
            System.out.printf("\n%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matchCount, reward, winningCount);
            return;
        }
        System.out.printf("\n%d개 일치 (%,d원) - %d개", matchCount, reward, winningCount);
    }

    private void printRevenueRate(double revenue) {
        System.out.printf("\n총 수익률은 %.1f%%입니다.\n", revenue * 100);
    }

    public int inputOnlyNumber() {
        String input = Console.readLine();
        validateInputOnlyNumber(input);
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        validateInputNumberAndComma(input);
        return Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void validateInputOnlyNumber(String input) {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException(Error.ONLY_NUMBER_ERROR.getMessage());
        }
    }

    private void validateInputNumberAndComma(String input) {
        if (!input.matches("[,0-9]*")) {
            throw new IllegalArgumentException(Error.INVALID_FORMAT.getMessage());
        }
    }
}
