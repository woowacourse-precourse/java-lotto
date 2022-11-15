package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {


    private List<Integer> winningNumbers = new ArrayList<>();
    private Integer bonus = 0;

    public Game(){

    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }


    private void validate(List<Integer> winningNumbers){
        validateWinningNumberBySize(winningNumbers);
        validateWinningNumberByDistinction(winningNumbers);
        validateWinningNumberByRange(winningNumbers);
    }

    private void validateWinningNumberByRange(List<Integer> winningNumbers){
        for (Integer number : winningNumbers){
            if (number > Constants.MAXIMUM_LOTTO_NUMBER.getValue() || number < Constants.MINIMUM_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void validateWinningNumberBySize(List<Integer> winningNumbers){
        if (winningNumbers.size() != Constants.NUMBER_TO_DRAW.getValue()){
            throw new IllegalArgumentException(ErrorMessages.WRONG_SIZE.getMessage());
        }
    }

    private void validateWinningNumberByDistinction(List<Integer> winningNumbers){
        Set<Integer> distinctNumbers = new HashSet<>(winningNumbers);
        if (distinctNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE.getMessage());
        }
    }

    public Integer getBonus(){
        return bonus;
    }

    public void setBonus(Integer bonus){
        validateBonusByRange(bonus);
        validateBonusByDistinction(bonus);
        this.bonus = bonus;
    }

    private void validateBonusByRange(Integer bonus){
        if (bonus > Constants.MAXIMUM_LOTTO_NUMBER.getValue() || bonus < Constants.MINIMUM_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.getMessage());
        }
    }

    private void validateBonusByDistinction(Integer bonus){
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE.getMessage());
        }
    }


}
