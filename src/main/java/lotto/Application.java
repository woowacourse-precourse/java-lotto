package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    static final int LOTTO_PRICE = 1000;
    static int BONUS_NUMBER;
    static int numberOfPurchasedLotto;
    static int totalRevenue;
    static int initialAmount;
    static String revenuePercentage;
    static List<Lotto> purchasedLotto = new ArrayList<>();
    static List<Integer> match = new ArrayList<>();
    static Lotto winning_number_lotto;

    public static void main(String[] args) {start();}

    public static void start() {
        catchNumberException();
        setWinningNumberLotto();
        validateGivenNumbers();
        initializeBonusNumber();
        countMatchingNumber();
        getTotalRevenue();
        printThePercentage();
    }

    public static void setInitialNumber() {
        OutputView.printTheAmount();
        initialAmount = Integer.parseInt(Console.readLine());
    }

    public static void testFactorOfThousand() {
        if (initialAmount % LOTTO_PRICE != 0) {
            OutputView.printErrorMessageFactorOfThousand();
            throw new IllegalArgumentException();
        }
    }

    public static void setNumberOfPurchasedLotto() {
        testFactorOfThousand();
        numberOfPurchasedLotto = initialAmount / LOTTO_PRICE;
    }

    public static void catchNumberException() {
        try {
            setInitialNumber();
            setNumberOfPurchasedLotto();
        } catch (NumberFormatException e) {
            OutputView.printErrorMessageNumberException();
        }
        OutputView.printLottoNumbers(numberOfPurchasedLotto, purchasedLotto);
    }

    public static void setWinningNumberLotto() {
        OutputView.printWinningNumber();
        String inputNumbers = Console.readLine();
        String[] winningNumbersAsString = inputNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumbersAsString) winningNumbers.add(Integer.parseInt(number));
        winning_number_lotto = new Lotto(winningNumbers);
    }

    public static boolean isNotInRange(int number) {
        return number < 1 || number > 45;
    }

    public static boolean hasInvalidInput(List<Integer> numbers) {
        for (int number : numbers) {
            if (isNotInRange(number)) return true;
        }
        return false;
    }

    public static void validateGivenNumbers() {
        if (hasInvalidInput(winning_number_lotto.getNumbers())) {
            OutputView.printErrorMessageRange();
            throw new IllegalArgumentException();
        }
    }

    public static void initializeBonusNumber() {
        OutputView.printBonusNumber();
        BONUS_NUMBER = Integer.parseInt(Console.readLine());
        if (isNotInRange(BONUS_NUMBER)) {
            OutputView.printErrorMessageRange();
            throw new IllegalArgumentException();
        }
    }

    public static int returnMatchedNumber(Lotto lotto) {
        int count = 0;
        for (int number : winning_number_lotto.getNumbers()) {
            if (lotto.containsTheNumber(number)) count++;
        }
        return count;
    }

    public static boolean containsBonusNumber(Lotto lotto) {
        return lotto.containsTheNumber(BONUS_NUMBER);
    }

    public static void countMatchingNumber() {
        for (Lotto lotto : purchasedLotto) {
            int matchedNumber = returnMatchedNumber(lotto);
            boolean containsBonusNumber = containsBonusNumber(lotto);
            if (containsBonusNumber && matchedNumber == OutputView.places.THIRD_PLACE.numberMatch) {
                match.add(Integer.MAX_VALUE);
                continue;
            }
            match.add(matchedNumber);
        }
    }

    public static void getTotalRevenue() {
        OutputView.printAnnouncement();
        for (OutputView.places place : OutputView.places.values()) {
            int won = Collections.frequency(match, place.numberMatch);
            totalRevenue += won * place.prize;
            OutputView.printPlaceMessage(place, won);
        }
    }

    public static void printThePercentage() {
        revenuePercentage = String.format("%.1f", ((double) totalRevenue / initialAmount * 100));
        OutputView.printClosingStatement(revenuePercentage);
    }
}