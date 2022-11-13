package lotto;

import static constance.Texts.*;
import static constance.Values.*;

import java.util.ArrayList;
import java.util.List;


public class Checker {
    public int checkNumber(String input) {

        int number = checkNumeric(input);

        this.checkNegative(number);

        return number;

    }

    public int checkNumeric(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(LOTTO_CHECKER_ERROR, input, LOTTO_CHECKER_ERROR_NON_NUMERIC));
        }
        return result;
    }

    public void checkNegative(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(String.format(LOTTO_CHECKER_ERROR, input, LOTTO_CHECKER_ERROR_NEGATIVE));
        }
    }

    public void checkPayment(int input) {
        if (input < 1000) {
            throw new IllegalArgumentException(String.format(LOTTO_CHECKER_ERROR, input, LOTTO_CHECKER_ERROR_LACK_OF_AMOUNT));
        }
    }

    public int checkAmountInput(String input) {

        int amount = checkNumber(input);

        this.checkPayment(amount);
        this.checkRemain(amount);

        return amount;
    }

    public void checkValidate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format(LOTTO_CHECKER_ERROR, numbers, LOTTO_CHECKER_ERROR_VALIDATE));
        }
        checkDuplicated(numbers);
    }

    public void checkDuplicated(List<Integer> numbers) {
        for (int i = 0; i < NUMBERS_SIZE; ++i) {
            int number = numbers.remove(0);
            if (numbers.contains(number)) {
                throw new IllegalArgumentException(String.format(LOTTO_CHECKER_ERROR, numbers, LOTTO_CHECKER_ERROR_DUPLICATED));
            }
            checkBoundary(number);
            numbers.add(number);
        }
    }

    public void checkDuplicated(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format(LOTTO_CHECKER_ERROR, numbers + " + " + bonusNumber, LOTTO_CHECKER_ERROR_DUPLICATED));
        }
    }

    public void checkBoundary(int number) {
        if (45 < number && number < 1) {
            throw new IllegalArgumentException(String.format(LOTTO_CHECKER_ERROR, number, LOTTO_CHECKER_ERROR_ILLEGAL));
        }
    }

    public List<Integer> checkNumbersInput(String input) {

        String[] inputs = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String s : inputs) {
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

}
