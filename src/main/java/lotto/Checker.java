package lotto;

import static constance.Texts.*;
import static constance.Values.*;

import java.util.ArrayList;
import java.util.List;


public class Checker {
    public int checkNumber(String input) throws IllegalArgumentException{

        int number = checkNumeric(input);

        this.checkNegative(number);

        return number;

    }

    public int checkNumeric(String input) throws IllegalArgumentException{
        int result = -1;
        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            String errorMessage = String.format(LOTTO_CHECKER_ERROR, input, LOTTO_CHECKER_ERROR_NON_NUMERIC);
            printAndThrowError(errorMessage);
        }
        return result;
    }

    public void checkNegative(int input) throws IllegalArgumentException{
        if (input < 0) {
            String errorMessage = String.format(LOTTO_CHECKER_ERROR, input, LOTTO_CHECKER_ERROR_NEGATIVE);
            printAndThrowError(errorMessage);
        }
    }

    public void checkPayment(int input) throws IllegalArgumentException{
        if (input < 1000) {
            String errorMessage = String.format(LOTTO_CHECKER_ERROR, input, LOTTO_CHECKER_ERROR_LACK_OF_AMOUNT);
            printAndThrowError(errorMessage);
        }
    }

    public int checkAmountInput(String input) {

        int amount=-1;

        try{
            amount = checkNumber(input);

            this.checkPayment(amount);
            this.checkRemain(amount);
        } catch (IllegalArgumentException illegalArgumentException) {
            amount=-1;
        }

        return amount;
    }

    public void checkValidate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            String errorMessage = String.format(LOTTO_CHECKER_ERROR, numbers, LOTTO_CHECKER_ERROR_VALIDATE);
            printAndThrowError(errorMessage);
        }
        checkBoundary(numbers);
        checkDuplicated(numbers);
    }

    public void checkDuplicated(List<Integer> numbers) {
        List<Integer> copyNumbers = new ArrayList<>();
        for (int number : numbers) {
            copyNumbers.add(number);
        }
        for (int i = 0; i < NUMBERS_SIZE; ++i) {
            int number = copyNumbers.remove(0);
            if (copyNumbers.contains(number)) {
                String errorMessage = String.format(LOTTO_CHECKER_ERROR, numbers, LOTTO_CHECKER_ERROR_DUPLICATED);
                printAndThrowError(errorMessage);
            }
        }
    }

    public void checkDuplicated(List<Integer> numbers, int bonusNumber) {
        this.checkDuplicated(numbers);
        if (numbers.contains(bonusNumber)) {
            String errorMessage = String.format(LOTTO_CHECKER_ERROR, numbers + " + " + bonusNumber, LOTTO_CHECKER_ERROR_DUPLICATED);
            printAndThrowError(errorMessage);
        }
    }

    public void checkBoundary(List<Integer> numbers) {
        for (int number : numbers) {
            checkBoundary(number);
        }
    }

    public void checkBoundary(int number) {
        if (45 < number && number < 1) {
            String errorMessage = String.format(LOTTO_CHECKER_ERROR, number, LOTTO_CHECKER_ERROR_ILLEGAL);
            printAndThrowError(errorMessage);
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
            System.out.println(String.format(LOTTO_CHECKER_EXCEPTION_AMOUNT_REMAIN, input, remain));
            input -= remain;
        }
        return input;
    }

    public int checkCoincide(List<Integer> userNumbers, List<Integer> winningNumbers) {
        System.out.println(String.format("!--User:%s\n!--Winning%s", userNumbers, winningNumbers));
        int coincideCount = 0;
        for (int winningNumber : winningNumbers) {
            System.out.println(String.format("!--winningNumber:%d\n!--user contains wN?%b", winningNumber, userNumbers.contains(winningNumber)));
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
        System.out.println(result);
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
        if (winningBonus != 0) {
            winningBonus = 2;
        }

        winning = WINNINGS[coincideCount + winningBonus];
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

    public void printAndThrowError(String errorMessage) {
        System.out.println(errorMessage);
        throw new IllegalArgumentException(errorMessage);
    }

}
