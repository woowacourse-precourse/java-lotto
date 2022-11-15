package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final Integer price = 1000;
    public static final Integer maximumLottoNumber = 45;
    public static final Integer numberToDraw = 6;

    private List<Integer> winningNumbers = new ArrayList<>();
    private Integer bonus = 0;

    public Game(){

    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
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
