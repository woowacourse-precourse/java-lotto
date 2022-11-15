package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Application {
    static final int LOTTO_START = 1;
    static final int LOTTO_END = 45;
    static final int LOTTO_PICK_NUM = 6;
    public static void main(String[] args) {
        printInputMoney();

        int money = getMoneyInputFromUser();
        int numberOfLotteries = calculateNumberOfLotteries(money);

        List<Lotto> lotteries = getLotteries(numberOfLotteries);

        WinLotto winLotto = getWinLotto();

        Map<Result, Integer> matches = new HashMap<>();
        printWins(lotteries, winLotto, matches);
        printProfit(matches, money);
    }

    private static void printProfit(Map<Result, Integer> matches, int money) {
        int profit = calculateProfit(matches);
        double profitPercent = calculateProfitPercent(profit, money);
        System.out.println("총 수익률은 " + profitPercent + "%입니다");
    }

    public static double calculateProfitPercent(int profit, int money) {
        return round((double) profit / money * 100, 1);
    }

    private static int calculateProfit(Map<Result, Integer> matches) {
        int profit = 0;
        for (Entry<Result, Integer> entry : matches.entrySet()) {
            profit += entry.getKey().price * entry.getValue();
        }
        return profit;
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    private static List<Lotto> getLotteries(int numberOfLotteries) {
        printNumberOfLotteries(numberOfLotteries);

        List<Lotto> lotteries = new LinkedList<>();
        randomPickLotteries(lotteries, numberOfLotteries);
        return lotteries;
    }

    private static WinLotto getWinLotto() {
        printInputWinLotto();
        WinLotto winLotto = getWinLottoInputFromUser();
        String bonusInput = getBonusInputFromUser();
        winLotto.validateBonusInput(bonusInput);
        winLotto.setBonus(Integer.parseInt(bonusInput));
        return winLotto;
    }

    private static void printWins(List<Lotto> lotteries, WinLotto winLotto, Map<Result, Integer> matches) {
        for (Lotto lotto : lotteries) {
            winLotto.matches(lotto, matches);
        }
        Result[] results = Result.values();
        for (Result result : results) {
            System.out.println(result.message + " - " + matches.get(result) + "개");
        }
    }


    private static String getBonusInputFromUser() {
        System.out.println(Message.INPUT_BONUS.message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static WinLotto getWinLottoInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        WinLotto winLotto = validateWinLottoInput(input);

        return winLotto;
    }

    public static WinLotto validateWinLottoInput(String input) {
        String[] input_split = input.split(",");
        for (String lottoNumber : input_split) {
            if (!isInteger(lottoNumber) || !inLottoRange(lottoNumber)) {
                throw new IllegalArgumentException(Message.ERROR_LOTTO_INPUT.message);
            }
        }
        return convertStringArrayToWinLotto(input_split);
    }

    private static WinLotto convertStringArrayToWinLotto(String[] input) {
        List<Integer> lottoNumbers = new LinkedList<>();
        for (String numberString : input) {
            lottoNumbers.add(Integer.parseInt(numberString));
        }
        return new WinLotto(lottoNumbers);
    }

    private static boolean inLottoRange(String input) {
        int lottoNumber = Integer.parseInt(input);
        if (lottoNumber >= 1 && lottoNumber <= 45) {
            return true;
        }
        return false;
    }

    private static void printInputWinLotto() {
        System.out.println(Message.INPUT_LOTTO_WIN.message);
    }

    public static void randomPickLotteries(List<Lotto> lotteries, int numberOfLotteries) {
        for (int i = 0; i < numberOfLotteries; i++) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_PICK_NUM);
            Collections.sort(uniqueNumbers);
            Lotto lotto = new Lotto(uniqueNumbers);
            lotteries.add(lotto);

            System.out.println(lotto);
        }
    }

    private static void printNumberOfLotteries(int numberOfLotteries) {
        System.out.println(numberOfLotteries + Message.OUTPUT_LOTTO_NUMBER.message);
    }

    public static int calculateNumberOfLotteries(int money) {
        return money / 1000;
    }

    private static int getMoneyInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return validateMoneyInput(input);
    }

    public static int validateMoneyInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(Message.ERROR_MONEY.message);
        }

        int inputInInt = Integer.parseInt(input);
        if (!inMoneyRange(inputInInt) || !divisibleByThousand(inputInInt)) {
            throw new IllegalArgumentException(Message.ERROR_MONEY.message);
        }

        return inputInInt;
    }

    public static boolean inMoneyRange(int inputInt) {
        if (inputInt >= 0) {
            return true;
        }
        return false;
    }

    public static boolean divisibleByThousand(int inputInt) {
        if (inputInt % 1000 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private static void printInputMoney() {
        System.out.println(Message.INPUT_MONEY.message);
    }
}
