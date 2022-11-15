package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static int amount;
    private static int totalOutcome;

    private static List<LotteryHostAgency.WinningCriteria> results;

    private static List<Lotto> lottories;

    private static int getTotalOutcome() {
        return totalOutcome;

    }

    private static float getEarningRate() {
        // TODO : 함수 구현
        return 0;
    }

    private static void printWiningStats(List<LotteryHostAgency.WinningCriteria> lotteryResults) {
        // TODO : 함수 구현
    }

    private static String validateInputAmountString(String inputString) {

        if (!Pattern.matches("^\\s?[1-9]+\\d*0{3}\\s?$", inputString))
            throw new IllegalArgumentException("[ERROR] The amount must be Interger that can be divisible by 1000.");

        return inputString;
    }

    private static String validateInputWinningNumbersString(String inputString) {
        if (!Pattern.matches("^\\s?(\\d+\\s)+\\d+\\s?$", inputString))
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
        int amount = Integer.parseInt(amountString);

        List<Lotto> results = ls.purchaseLotteries(amount);
        System.out.printf("%d개를 구매했습니다.\n", results.size());
        results.parallelStream().forEach(System.out::println);

        return results;
    }

    private static List<Integer> setInputWinningNumbers() {
        List<Integer> results = new ArrayList<>();

        System.out.println("당첨 번호를 입력해주세요.");
        String inputNumbersString = validateInputWinningNumbersString(readLine());
        Arrays.stream(inputNumbersString.split("\\s"))
                .mapToInt(Integer::parseInt)
                .forEach(x -> results.add(x));
        return results;
    }

    private static int setInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(validateInputBonusNumberString(readLine()));

    }

    private static void printResults() {

    }

    public static void main(String[] args) {
        LotteryHostAgency lha = new LotteryHostAgency();
        lottories = purchaseLotteries();

        List<Integer> inputNumbers = setInputWinningNumbers();
        int inputBonusNumber = setInputBonusNumber();

        lha.setDrawalNumbers(inputNumbers, inputBonusNumber);
        List<LotteryHostAgency.WinningCriteria> results = lottories.parallelStream().map(lha::getResult).collect(Collectors.toList());
        printWiningStats(results);
    }
}
