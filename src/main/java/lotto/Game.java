package lotto;

import java.util.List;

public class Game {
    private int bonusNumber;
    private int lottoCount;

    private List<Integer> winningNumbers;


    public int getBonusNumber(){
        return this.bonusNumber;
    }

    public int getLottoCount(){
        return this.lottoCount;
    }

    public List<Integer> getWinningNumbers(){
        return this.winningNumbers;
    }

    public void changeBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public void changeLottoCount(int lottoCount){
        this.lottoCount = lottoCount;
    }

    public void changeWinningNumbers(List<Integer> winningNumbers){
        this.winningNumbers = winningNumbers;
    }
}
