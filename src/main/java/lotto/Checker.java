package lotto;

import constance.Values;

import static constance.Values.Texts.*;
import static constance.Values.Constants.*;

import java.util.ArrayList;
import java.util.List;


public class Checker {

    public int checkNumber(String input) throws IllegalArgumentException {
        int number = checkNumeric(input);
        checkNegative(number);
        return number;
    }

    public int checkNumeric(String input) throws IllegalArgumentException {
        int result = -1;
        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            printAndThrowError(input, ERROR_NON_NUMERIC.message());
        }
        return result;
    }

    public int checkNegative(int input) throws IllegalArgumentException {
        if (input < 0) {
            printAndThrowError(String.valueOf(input), ERROR_NEGATIVE.message());
        }
        return input;
    }

    public int checkPayment(int input) throws IllegalArgumentException {
        if (input < 1000) {
            printAndThrowError(String.valueOf(input), ERROR_LACK_OF_AMOUNT.message());
        }
        return input;
    }

    public int checkAmountInput(String input) {
        int amount = -1;
        try {
            amount = checkNumber(input);
            amount = checkPayment(amount);
            amount = checkRemain(amount);
        } catch (IllegalArgumentException illegalArgumentException) {
            amount = -1;
        }
        return amount;
    }

    public void checkValidate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE.value()) {
            printAndThrowError(numbers.toString(), ERROR_VALIDATE.message());
        }
        checkBoundary(numbers);
        checkDuplicated(numbers);
    }

    public void checkDuplicated(List<Integer> numbers) {
        List<Integer> copyNumbers = new ArrayList<>();
        for (int number : numbers) {
            copyNumbers.add(number);
        }
        for (int i = 0; i < NUMBERS_SIZE.value(); ++i) {
            int number = copyNumbers.remove(0);
            if (copyNumbers.contains(number)) {
                printAndThrowError(numbers.toString(), ERROR_DUPLICATED.message());
            }
        }
    }

    public void checkDuplicated(List<Integer> numbers, int bonusNumber) {
        this.checkDuplicated(numbers);
        if (numbers.contains(bonusNumber)) {
            printAndThrowError(numbers + " + " + bonusNumber, ERROR_DUPLICATED.message());
        }
    }

    public void checkBoundary(List<Integer> numbers) {
        for (int number : numbers) {
            checkBoundary(number);
        }
    }

    public void checkBoundary(int number) {
        if (45 < number || number < 1) {
            printAndThrowError(String.valueOf(number), ERROR_ILLEGAL.message());
        }
    }

    public List<Integer> checkNumbersInput(String input) {
        String[] inputs = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : inputs) {
            s = s.strip();
            int number = this.checkNumber(s);
            numbers.add(number);
        }
        checkValidate(numbers);
        return numbers;
    }

    public int checkRemain(int input) {
        int remain;
        if (input % 1000 > 0) {
            remain = input % 1000;
            System.out.println(String.format(EXCEPTION_AMOUNT_REMAIN.message(), input, remain));
            input -= remain;
        }
        return input;
    }

    public int checkCoincide(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int coincideCount = 0;
        for (int winningNumber : winningNumbers) {
            if (userNumbers.contains(winningNumber)) {
                coincideCount += 1;
            }
        }
        return coincideCount;
    }

    public int checkBonusNumber(List<Integer> userNumbers, int bonusNumber) {
        int bonus = 0;
        if (userNumbers.contains(bonusNumber)) {
            bonus = 1;
        }
        return bonus;
    }

    public Result checkResult(Lotto lotto, WinningLotto winningLotto) {
        Result result;
        List<Integer> userNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int coincideCount;
        int bonusNumber;
        int bonus;
        coincideCount = checkCoincide(userNumbers, winningNumbers);
        bonusNumber = winningLotto.getBonusNumber();
        bonus = checkBonusNumber(userNumbers, bonusNumber);
        result = new Result(lotto, coincideCount, bonus);
        return result;
    }

    public List<Result> checkResults(List<Lotto> lotteries, WinningLotto winningLotto) {
        List<Result> results = new ArrayList<>();
        for (Lotto lotto : lotteries) {
            Result result = checkResult(lotto, winningLotto);
            results.add(result);
        }
        return results;
    }

    public int checkWinning(Result result) {
        int winning;
        int coincideCount;
        int winningBonus;
        coincideCount = result.getCoincideCount();
        winningBonus = result.getBonus();
        if (winningBonus > 0 && coincideCount == 5) {
            winningBonus = 2;
        }
        winning = Values.WINNINGS[coincideCount + winningBonus];
        return winning;
    }

    public int checkWinnings(List<Result> results) {
        int winnings = 0;
        int winning;
        for (Result result : results) {
            winning = checkWinning(result);
            winnings += winning;
        }
        return winnings;
    }

    public float checkLotteryStat(int winnings, int lotteryCount) {
        float lotteryStat = (float) winnings / (float) (lotteryCount * 1000) * 100;
        return lotteryStat;
    }

    public void printAndThrowError(String target, String errorMessage) {
        System.out.println(String.format(ERROR.message(), target, errorMessage));
        throw new IllegalArgumentException(errorMessage);
    }

}
