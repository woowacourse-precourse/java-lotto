package lotto;

import static lotto.Application.isInteger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Map<Result, Integer> matches(Lotto lotto, Map<Result, Integer> matchMap) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        initializeMatchMap(matchMap);
        boolean bonusMatch = isBonusMatch(lottoNumbers);
        numbersMatch(lottoNumbers, matchMap, bonusMatch);
        return matchMap;
    }

    private void numbersMatch(List<Integer> lottoNumbers, Map<Result, Integer> matchMap, boolean bonusMatch) {
        int matchCount = 0;
        for (Integer number : lottoNumbers) {
            if (getNumbers().contains(number)) {
                matchCount++;
            }
        }
        Result result = interpretMatchCountAndBonusMatch(matchCount, bonusMatch);
        if (result != null) {
            matchMap.put(result, matchMap.get(result) + 1);
        }
    }

    private boolean isBonusMatch(List<Integer> lottoNumbers) {
        boolean bonusMatch = false;
        if (lottoNumbers.contains(bonus)) {
            bonusMatch = true;
        }
        return bonusMatch;
    }

    private void initializeMatchMap(Map<Result, Integer> matchMap) {
        Result[] results = Result.values();
        for (Result result : results) {
            matchMap.put(result, matchMap.getOrDefault(result, 0));
        }
    }

    private Result interpretMatchCountAndBonusMatch(int matchCount, boolean bonusMatch) {
        if (matchCount == 3) {
            return Result.Three;
        }
        if (matchCount == 4) {
            return Result.Four;
        }
        if (matchCount == 5 && bonusMatch == false) {
            return Result.Five;
        }
        if (matchCount == 5 && bonusMatch == true) {
            return Result.FiveBonus;
        }
        if (matchCount == 6) {
            return Result.Six;
        }
        return null;
    }
}
