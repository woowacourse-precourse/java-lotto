package lotto;

import static lotto.Application.isInteger;

import java.util.List;
import java.util.Scanner;

public class WinLotto extends Lotto {
    int bonus;

    public WinLotto(List<Integer> numbers) {
        super(numbers);
        validate(numbers);
    }

    public int validateBonusInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(Message.ERROR_BONUS.message);
        }
        int inputInt = Integer.parseInt(input);
        validateLottoNumberRange(inputInt);
        validateBonusNumberUniqueness(inputInt);
        return inputInt;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void validateBonusNumberUniqueness(int bonus) {
        if (getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_DUPLICATE.message);
        }
    }

    private void validate(List<Integer> numbers) {
        validateEachLottoNumbersRange(numbers);
    }

    public void validateEachLottoNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateLottoNumberRange(number);
        }
    }

    private void validateLottoNumberRange(Integer number) {
        if (number < Application.LOTTO_START || number > Application.LOTTO_END) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_INPUT.message);
        }
    }

    public String matches(Lotto lotto) {
        int matchCount = 0;
        boolean bonusMatch = false;

        List<Integer> lottoNumbers = lotto.getNumbers();
        for (Integer number : lottoNumbers) {
            if (getNumbers().contains(number)) {
                matchCount++;
            }
        }
        if (matchCount == 5 && lottoNumbers.contains(bonus)) {
            bonusMatch = true;
        }
        return interpretMatchCountAndBonusMatch(matchCount, bonusMatch);
    }

    private String interpretMatchCountAndBonusMatch(int matchCount, boolean bonusMatch) {
        if (matchCount == 3) {
            return Result.Three.message;
        }
        if (matchCount == 4) {
            return Result.Four.message;
        }
        if (matchCount == 5 && bonusMatch == false) {
            return Result.Five.message;
        }
        if (matchCount == 5 && bonusMatch == true) {
            return Result.FiveBonus.message;
        }
        if (matchCount == 6) {
            return Result.Six.message;
        }
        return null;
    }
}
