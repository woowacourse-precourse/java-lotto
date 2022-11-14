package lotto.domain.game;

import java.util.List;

import static lotto.domain.game.LottoString.*;

public class Lotto {
    private final List<Integer> lotto;
    public static final int LOTTO_COUNT = 6;
    public static final int LOTTO_BONUS_COUNT = 1;

    public Lotto(List<Integer> winningNumbers) {
        validateSizeWinningNumber(winningNumbers);
        validateDuplicate(winningNumbers);
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

    public void validateDuplicateBonusAndWinningNumber(int number){
        if(lotto.contains(number)){
            throw new IllegalArgumentException(DUPLICATION_WINNING_NUMBER_AND_BONUS_NUMBER.print());
        }
    }

    public void setBonusNumber(int number){
        validateDuplicateBonusAndWinningNumber(number);
        lotto.add(number);
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
