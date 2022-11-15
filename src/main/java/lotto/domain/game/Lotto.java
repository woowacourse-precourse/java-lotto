package lotto.domain.game;

import java.util.List;

import static lotto.domain.game.LottoString.*;

public class Lotto {
    public static final int LOTTO_COUNT = 6;
    public static final int LOTTO_BONUS_COUNT = 1;
    public static int LOTTO_MIN_RANGE = 1;
    public static int LOTTO_MAX_RANGE = 45;
    private final List<Integer> lotto;

    public Lotto(List<Integer> winningNumbers) {
        validateSizeWinningNumber(winningNumbers);
        validateDuplicate(winningNumbers);
        validateRange(winningNumbers);
        this.lotto = winningNumbers;
    }

    public void validateSizeWinningNumber(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(NO_MATCH_LOTTO_COUNT.print(LOTTO_COUNT));
        }
    }

    public void validateDuplicate(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(DUPLICATION_WINNING_NUMBER.print(LOTTO_COUNT));
        }
    }

    public void validateRange(List<Integer> numbers){
        for (int number : numbers){
            if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE){
                throw new IllegalArgumentException(OVER_OR_UNDER_RANGE.print(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE));
            }
        }
    }

    public void validateRange(int number){
        if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException(OVER_OR_UNDER_RANGE.print(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE));
        }
    }

    public void validateDuplicateBonusAndWinningNumber(int number){
        if(lotto.contains(number)){
            throw new IllegalArgumentException(DUPLICATION_WINNING_NUMBER_AND_BONUS_NUMBER.print());
        }
    }


    public void setBonusNumber(int number){
        validateDuplicateBonusAndWinningNumber(number);
        validateRange(number);
        lotto.add(number);
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
