package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserInterface {
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toStringLotto());
        }
    }

    public void printResult(Map<WinningResult, Integer> statistics, double revenue) {
        List<WinningResult> winningResults = Arrays.asList(WinningResult.values());
        Collections.reverse(winningResults);
        System.out.print("당첨 통계\n---");
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
        if (!validateInputOnlyNumber(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        if (!validateInputNumberAndComma(input)) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean validateInputOnlyNumber(String input) {
        return input.matches("[0-9]*");
    }

    private boolean validateInputNumberAndComma(String input) {
        return input.matches("[,0-9]*");
    }
}
