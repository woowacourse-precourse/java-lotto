package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.GuideMessage.*;
import static lotto.ErrorMessage.*;

public class Application {
    private static final int INVALID_PURCHASE_MONEY = -1;
    private static final int LOTTO_TICKET_MONEY = 1000;
    private static final int NEGATIVE_RANGE = 0;
    private static final int LOTTO_NUMBER_FIRST_RANGE = 1;
    private static final int LOTTO_NUMBER_LAST_RANGE = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int NO_OUT_OF_RANGE_SIZE = 0;

    private static final int INVALID_BONUS_NUMBER = -1;

    public static int getLottoPurchaseMoney() {
        System.out.println(INPUT_REQUEST_MESSAGE.getMessage());
        String userInput = Console.readLine();
        boolean valid = validateUserInput(userInput);
        if (valid) {
            int lottoPurchaseMoney = Integer.parseInt(userInput);
            return lottoPurchaseMoney;
        }
        return INVALID_PURCHASE_MONEY;
    }

    public static boolean validateUserInput(String userInput) throws IllegalArgumentException {
        boolean valid = checkLottoPurchaseMoneyValid(userInput);
        if (valid) {
            int lottoPurchaseMoney = Integer.parseInt(userInput);
            checkLottoPurchaseMoneyRange(lottoPurchaseMoney);
        }
        return valid;
    }

    public static boolean checkLottoPurchaseMoneyValid(String userInput) throws IllegalArgumentException {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (Exception e) {
            IllegalArgumentException exception = new IllegalArgumentException();
            System.out.println(NOT_NUMBER_INPUT_MESSAGE.getMessage());
            return false;
        }
    }

    public static void checkLottoPurchaseMoneyRange(int lottoPurchaseMoney) throws IllegalArgumentException {
        if (lottoPurchaseMoney % LOTTO_TICKET_MONEY != 0 || lottoPurchaseMoney < NEGATIVE_RANGE) {
            throw new IllegalArgumentException(INVALID_PURCHASE_MONEY_MESSAGE.getMessage());
        }
    }

    public static List<Lotto> makeLottery(int lottoPurchaseMoney) {

        List<Lotto> lottery = new ArrayList<>();
        int lottoTicketCount = lottoPurchaseMoney / LOTTO_TICKET_MONEY;

        for (int iterator = 0; iterator < lottoTicketCount; iterator++) {
            lottery.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_FIRST_RANGE, LOTTO_NUMBER_LAST_RANGE, LOTTO_NUMBERS_SIZE)));
        }

        return lottery;
    }

    public static void printLotto(int lottoPurchaseMoney, List<Lotto> lottery) {
        int lottoTicketCount = lottoPurchaseMoney / LOTTO_TICKET_MONEY;
        System.out.printf(PURCHASE_LOTTO_TICKET_COUNT_MESSAGE.getMessage(), lottoTicketCount);
        for (Lotto lotto : lottery) {
            lotto.printLottoNumbers();
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(WINNING_NUMBERS_REQUEST_MESSAGE.getMessage());

        String userInput = Console.readLine();
        boolean valid = validateWinningNumbers(userInput);

        if (valid) {
            List<String> splitNumbers = Arrays.asList(userInput.split(","));
            List<Integer> winningNumbers = splitNumbers.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            return winningNumbers;
        }
        return null;
    }

    public static boolean validateWinningNumbers(String userInput) {
        boolean valid = checkWinningNumbersValid(userInput);
        if (valid) {
            List<String> splitNumbers = Arrays.asList(userInput.split(","));
            List<Integer> winningNumbers = splitNumbers.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            checkWinningNumbersRange(winningNumbers);
            checkWinningNumbersSize(winningNumbers);
        }
        return valid;
    }

    public static boolean checkWinningNumbersValid(String userInput) {
        try {
            List<String> str = new ArrayList<>(Arrays.asList(userInput.split(",")));
            return true;
        } catch (Exception e) {
            IllegalArgumentException exception = new IllegalArgumentException();
            System.out.println(INVALID_WINNING_NUMBERS_INPUT_MESSAGE.getMessage());
            return false;
        }
    }

    public static void checkWinningNumbersSize(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_SIZE_MESSAGE.getMessage());
        }
    }

    public static void checkWinningNumbersRange(List<Integer> winningNumbers) throws IllegalArgumentException {
        List<Integer> outOfRange = winningNumbers.stream().filter(number -> number > LOTTO_NUMBER_LAST_RANGE | number < LOTTO_NUMBER_FIRST_RANGE).collect(Collectors.toList());

        if (outOfRange.size() != NO_OUT_OF_RANGE_SIZE) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_RANGE_MESSAGE.getMessage());
        }
    }

    public static int getBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE.getMessage());
        String userInput = Console.readLine();
        int bonusNumber = Integer.parseInt(userInput);
        return bonusNumber;
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE.getMessage());
        String userInput = Console.readLine();
        boolean valid = validateBonusNumber(winningNumbers, userInput);
        if (valid) {
            int bonusNumber = Integer.parseInt(userInput);
            return bonusNumber;
        }
        return INVALID_BONUS_NUMBER;
    }

    public static boolean validateBonusNumber(List<Integer> winningNumbers, String userInput) throws IllegalArgumentException {
        boolean valid = checkBonusNumberValid(userInput);
        if (valid) {
            int bonusNumber = Integer.parseInt(userInput);
            checkBonusNumberRange(bonusNumber);
            checkWinningNumbersContainBonusNumber(winningNumbers, bonusNumber);
        }
        return valid;
    }

    public static boolean checkBonusNumberValid(String userInput) throws IllegalArgumentException {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (Exception e) {
            IllegalArgumentException exception = new IllegalArgumentException();
            System.out.println(NOT_NUMBER_INPUT_MESSAGE.getMessage());
            return false;
        }
    }

    public static void checkWinningNumbersContainBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_MESSAGE.getMessage());
        }
    }

    public static void checkBonusNumberRange(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < LOTTO_NUMBER_FIRST_RANGE || bonusNumber > LOTTO_NUMBER_LAST_RANGE) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    public static List<Integer> getWinningStats(List<Lotto> lottery, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> winningStats = new ArrayList<>(List.of(0, 0, 0, 0, 0));

        for (Lotto lotto : lottery) {
            int winningNumberCount = (int) lotto.getWinningNumberCount(winningNumbers);
            boolean isContainBonusNumber = lotto.isContainBonusNumber(bonusNumber);
            winningStats = calculateFifthPlace(winningNumberCount, winningStats);
            winningStats = calculateFourthPlace(winningNumberCount, winningStats);
            winningStats = calculateThirdPlace(winningNumberCount, winningStats, isContainBonusNumber);
            winningStats = calculateSecondPlace(winningNumberCount, winningStats, isContainBonusNumber);
            winningStats = calculateFirstPlace(winningNumberCount, winningStats);
        }

        return winningStats;
    }

    public static List<Integer> calculateFifthPlace(int winningNumberCount, List<Integer> winningStats) {
        if (winningNumberCount == 3) {
            winningStats.set(0, winningStats.get(0) + 1);
        }
        return winningStats;
    }

    public static List<Integer> calculateFourthPlace(int winningNumberCount, List<Integer> winningStats) {
        if (winningNumberCount == 4) {
            winningStats.set(1, winningStats.get(1) + 1);
        }
        return winningStats;
    }

    public static List<Integer> calculateThirdPlace(int winningNumberCount, List<Integer> winningStats, boolean isContainBonusNumber) {
        if (winningNumberCount == 5 && !isContainBonusNumber) {
            winningStats.set(2, winningStats.get(2) + 1);
        }
        return winningStats;
    }

    public static List<Integer> calculateSecondPlace(int winningNumberCount, List<Integer> winningStats, boolean isContainBonusNumber) {
        if (winningNumberCount == 5 && isContainBonusNumber) {
            winningStats.set(3, winningStats.get(3) + 1);
        }
        return winningStats;
    }

    public static List<Integer> calculateFirstPlace(int winningNumberCount, List<Integer> winningStats) {
        if (winningNumberCount == 6) {
            winningStats.set(4, winningStats.get(4) + 1);
        }
        return winningStats;
    }

    public static void main(String[] args) {
        int lottoPurchaseMoney = getLottoPurchaseMoney();
        if (lottoPurchaseMoney == INVALID_PURCHASE_MONEY) {
            return;
        }
        List<Lotto> lottery = makeLottery(lottoPurchaseMoney);
        printLotto(lottoPurchaseMoney, lottery);
        List<Integer> winningNumbers = getWinningNumbers();
        if (winningNumbers == null) {
            return;
        }
        int bonusNumber = getBonusNumber();
        if (bonusNumber == INVALID_BONUS_NUMBER) {
            return;
        }
        List<Integer> winningStats = getWinningStats(lottery, winningNumbers, bonusNumber);
    }
}