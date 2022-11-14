package lotto.domain;

import java.util.List;

public class GameSet {
    final int PRICE_SIZE = 6;
    final Lotto awardLotto;
    int bonusNumber;
    private int[] gameCount;
    public GameSet(Lotto awardLotto){
        gameCount = new int[PRICE_SIZE];
        this.awardLotto=awardLotto;
    }
    public void plusCount(int index){
        gameCount[index]++;
    }
    public Lotto getAwardLotto(){
        return awardLotto;
    }
    public void setBonusNumber(List<Integer> bonusNumber){
        this.bonusNumber=bonusNumber.get(0);
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
}
