package lotto.domain;

import java.util.List;

public class GameSet {
    final int PRICE_SIZE = 6;
    final Lotto awardLotto;
    final int lottoCount;
    private int totalPrize;
    private int bonusNumber;
    private int[] gameCount;
    public GameSet(Lotto awardLotto,int lottoCount){
        gameCount = new int[PRICE_SIZE];
        this.awardLotto=awardLotto;
        this.lottoCount = lottoCount;
        totalPrize = 0;
    }
    public void plusTotalPrize(int prize){
        totalPrize+=prize;
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
    public int[] getGameCount(){
        return gameCount;
    }
    public int getTotalPrize(){
        return totalPrize;
    }
    public int getLottoCount(){
        return lottoCount;
    }
}
