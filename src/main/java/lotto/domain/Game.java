package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    public static final Integer price = 1000;
    public static final Integer maximumLottoNumber = 45;
    public static final Integer numberToDraw = 6;
    public static final Integer minimumLottoNumber = 1;

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
            if (number > maximumLottoNumber || number < minimumLottoNumber) throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumberBySize(List<Integer> winningNumbers){
        if (winningNumbers.size() != numberToDraw){
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumberByDistinction(List<Integer> winningNumbers){
        Set<Integer> distinctNumbers = new HashSet<>(winningNumbers);
        if (distinctNumbers.size() != winningNumbers.size()) throw new IllegalArgumentException();
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
        if (bonus > maximumLottoNumber || bonus < 1) throw new IllegalArgumentException();
    }

    private void validateBonusByDistinction(Integer bonus){
        if (winningNumbers.contains(bonus)) throw new IllegalArgumentException();
    }


}
