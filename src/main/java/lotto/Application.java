package lotto;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static int amount;
    private static int totalOutcome;

    private static List<LotteryHostAgency.WinningCriteria> results;

    private static List<Lotto> lottories;


    private static String validateInputAmountString(String inputString) {

        if (!Pattern.matches("^\\s?[1-9]+\\d*0{3}\\s?$", inputString))
            throw new IllegalArgumentException("[ERROR] The amount must be Interger that can be divisible by 1000.");

        return inputString;
    }

    private static String validateInputWinningNumbersString(String inputString) {
        if (!Pattern.matches("^\\s?(\\d+,)+\\d+\\s?$", inputString))
            throw new IllegalArgumentException("[ERROR] The Winning numbers are invalid.");
        return inputString;
    }

    private static String validateInputBonusNumberString(String inputString) {
        if (!Pattern.matches("^\\s?\\d+\\s?$", inputString))
            throw new IllegalArgumentException(("[ERROR] The Bonus number is invalid."));

        return inputString;
    }

    private static List<Lotto> purchaseLotteries() {
        LotteryStore ls = new LotteryStore();

        System.out.println("구입금액을 입력해 주세요.");
        String amountString = validateInputAmountString(readLine());
        amount = Integer.parseInt(amountString);

        List<Lotto> results = ls.purchaseLotteries(amount);
        System.out.printf("%d개를 구매했습니다.\n", results.size());
        results.parallelStream().forEach(System.out::println);

        return results;
    }

    private static List<Integer> setInputWinningNumbers() {
        List<Integer> results = new ArrayList<>();
        System.out.println("당첨 번호를 입력해주세요.");
        String inputNumbersString = validateInputWinningNumbersString(readLine());
        Arrays.stream(inputNumbersString.split(","))
                .mapToInt(Integer::parseInt)
                .forEach(x -> results.add(x));
        return results;
    }

    private static int setInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(validateInputBonusNumberString(readLine()));

    }

    private static void printWiningStats(List<LotteryHostAgency.WinningCriteria> lotteryResults) {
        totalOutcome = lotteryResults.stream().mapToInt(x -> x.amount).sum();
        printResults(lotteryResults);
        printEarningRate(lotteryResults);

    }

    private static void printResults(List<LotteryHostAgency.WinningCriteria> lotteryResults) {
        Map<String, Long> resultMap = lotteryResults.parallelStream().collect(
                Collectors.groupingBy(LotteryHostAgency.WinningCriteria::name, Collectors.counting()));

        System.out.println("당첨 통계\n---");
        Arrays.stream(LotteryHostAgency.WinningCriteria.values())
                .forEach((v) -> {
                    printOneResultByWinningCriteria(resultMap, v);
                });

    }

    private static void printOneResultByWinningCriteria(Map<String, Long> resultMap, LotteryHostAgency.WinningCriteria v) {
        NumberFormat currencyFormat = NumberFormat.getInstance(Locale.KOREA);
        long count = resultMap.getOrDefault(v.name(), 0L);
        if (v == LotteryHostAgency.WinningCriteria.NOTHING) return;
        if (v == LotteryHostAgency.WinningCriteria.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", v.matches, currencyFormat.format(v.amount), count);
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", v.matches, currencyFormat.format(v.amount).replace("$", ""), count);
    }

    private static void printEarningRate(List<LotteryHostAgency.WinningCriteria> lotteryResults) {
        NumberFormat percentFormat = NumberFormat.getPercentInstance(Locale.KOREA);
        percentFormat.setMaximumFractionDigits(1);
        percentFormat.setMinimumFractionDigits(1);
        System.out.printf("총 수익률은 %s입니다.", percentFormat.format(((float) totalOutcome) / amount));
    }


    public static void main(String[] args) {
        LotteryHostAgency lha = new LotteryHostAgency();
        lottories = purchaseLotteries();

        List<Integer> inputNumbers = setInputWinningNumbers();
        int inputBonusNumber = setInputBonusNumber();

        lha.setDrawalNumbers(inputNumbers, inputBonusNumber);
        results = lottories.parallelStream().map(lha::getResult).collect(Collectors.toList());
        printWiningStats(results);
    }
}
