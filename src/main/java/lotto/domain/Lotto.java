package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateByRange(numbers);
        validateBySize(numbers);
        validateByDistinction(numbers);
    }

    private void validateByRange(List<Integer> numbers){
        for (Integer number : numbers){
            if (number > Constants.MAXIMUM_LOTTO_NUMBER.getValue() || number < Constants.MINIMUM_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 " + Constants.MINIMUM_LOTTO_NUMBER.getValue() + "와 "
                                + Constants.MAXIMUM_LOTTO_NUMBER.getValue() + "사이의 정수들이어야 합니다."
                );
            }
        }
    }

    private void validateBySize(List<Integer> numbers){
        if (numbers.size() != Constants.NUMBER_TO_DRAW.getValue()){
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 정확히 " + Constants.NUMBER_TO_DRAW.getValue() + "개의 정수여야 합니다."
            );
        }
    }

    private void validateByDistinction(List<Integer> numbers){
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호에는 중복되는 수가 없어야 합니다."
            );
        }
    }

    public Integer countMatched(List<Integer> winningNumbers){
        Integer number = 0;
        for (Integer winningNumber : winningNumbers){
               if (numbers.contains(winningNumber)) number += 1;
        }
        return number;
    }

    public Integer countBonus(Integer bonus)
    {
        if (numbers.contains(bonus)) return 1;
        return 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank getRank(List<Integer> winningNumbers, Integer bonus){
        Integer matchedCount = countMatched(winningNumbers);
        Integer bonusCount = countBonus(bonus);
        Rank lottoRank = Rank.NONE;
        for (Rank rank : Rank.asSortedList()){
            if (rank.getMatchedCount() <= matchedCount && rank.getBonusCount() <= bonusCount) {
                lottoRank = rank;
            }
        }
        return lottoRank;
    }

}
