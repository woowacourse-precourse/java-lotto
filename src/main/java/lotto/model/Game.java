package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final Integer price = 1000;
    public static final Integer maximumLottoNumber = 45;
    public static final Integer numberToDraw = 6;


    private Lotto winningLotto;
    private Integer bonus = 0;

    public Game(){

    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setWinningLotto(List<Integer> winningNumbers){
        winningLotto = new Lotto(winningNumbers);
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
        if (winningLotto.contains(bonus)) throw new IllegalArgumentException();
    }




}
