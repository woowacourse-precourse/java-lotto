package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Exception.ErrorType;

public class UI {

    public int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");

        String amount = Console.readLine();

        validateAmount(amount);

        return Integer.parseInt(amount);
    }

    public static void validateAmount(String amount) {

        isNumber(amount);

        int amountNumber = Integer.parseInt(amount);

        isNotZero(amountNumber);

        divisibleThousand(amountNumber);
    }

    public static void isNumber(String amount) {
        for (char letter : amount.toCharArray()) {
            if (letter < '0' || letter > '9') {
                System.out.println(ErrorType.NOT_NUMBER.getErrorMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    public static void isNotZero(int amountNumber) {
        if (amountNumber == 0) {
            System.out.println(ErrorType.ZERO_AMOUNT.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void divisibleThousand(int amountNumber) {
        if (amountNumber % 1000 != 0) {
            System.out.println(ErrorType.INDIVISIBLE_THOUSAND.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String winningNumbers = Console.readLine();

        validateWinningNumbers(winningNumbers);

        List<Integer> numbersOfWinner = StringToList(winningNumbers);

        return numbersOfWinner;
    }

    public void validateWinningNumbers(String winningNumbers) {

        String[] splitWinningNumbers = winningNumbers.split(",");

        isSixNumbers(splitWinningNumbers);

        for (String splitWinningNumber : splitWinningNumbers) {
            isOneToFourtyFive(splitWinningNumber);
        }

        isDuplicatedNumber(splitWinningNumbers);
    }

    public void isSixNumbers(String[] splitWinningNumbers) {
        if (splitWinningNumbers.length != 6) {
            System.out.println(ErrorType.NOT_SIX_NUMBERS.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void isOneToFourtyFive(String splitWinningNumber) {
        isNumber(splitWinningNumber);

        int winningNumber = Integer.parseInt(splitWinningNumber);

        if (winningNumber < 0 || winningNumber > 45) {
            System.out.println(ErrorType.NOT_ONE_TO_FOURTYFIVE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public void isDuplicatedNumber(String[] splitWinningNumbers) {

        for (String splitWinningNumber : splitWinningNumbers) {
            compareNumber(splitWinningNumbers, splitWinningNumber);
        }
    }

    public void compareNumber(String[] splitWinningNumbers, String splitWinningNumber) {
        int count = 0;

        for (String compareWinningNumber : splitWinningNumbers) {
            if (compareWinningNumber.equals(splitWinningNumber)) {
                count++;
            }
        }

        if (count >= 2) {
            System.out.println(ErrorType.DUPLICATED_NUMBER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> StringToList(String winningNumbers) {
        String[] splitWinningNumbers = winningNumbers.split(",");

        List<Integer> numbersOfWinner = new ArrayList<>();
        for (String splitWinningNumber : splitWinningNumbers) {
            int winningNumber = Integer.parseInt(splitWinningNumber);

            numbersOfWinner.add(winningNumber);
        }

        return numbersOfWinner;
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        isNumber(bonusNumber);
        isOneToFourtyFive(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    public void outputResult(int[] countOfRank, int amount) {
        System.out.println("당첨 통계");
        System.out.println("===");
        System.out.println("3개 일치 (5,000원) - " + countOfRank[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + countOfRank[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countOfRank[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countOfRank[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countOfRank[1] + "개");

        calculateYield(countOfRank, amount);
    }

    public static void calculateYield(int[] countOfRank, int amount) {
        long sum = 0;
        sum += 5000 * countOfRank[5];
        sum += 50000 * countOfRank[4];
        sum += 1500000 * countOfRank[3];
        sum += 30000000 * countOfRank[2];
        sum += 2000000000 * countOfRank[1];

        long yield = sum / amount + sum % amount;
        System.out.println("총 수익률은 " + Math.round(yield * 100) + "%입니다.");

    }
}