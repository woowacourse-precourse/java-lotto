package lotto;

import java.util.List;

public class Game {
    private int bonusNumber;
    private int lottoCount;

    private int hitThree;
    private int hitFour;
    private int hitFive;
    private int hitFiveAndBonus;
    private int hitSix;
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

    public void changehitThree(int hitThree){
        this.hitThree = hitThree;
    }

    public void changehitFour(int hitFour){
        this.hitFour = hitFour;
    }
    public void changehitFive(int hitFive){
        this.hitFive = hitFive;
    }
    public void changehitFiveAndBonus(int hitFiveAndBonus){
        this.hitFiveAndBonus = hitFiveAndBonus;
    }
    public void changehitSix(int hitSix){
        this.hitSix = hitSix;
    }

    public int getHitThree(){
        return this.hitThree;
    }
    public int getHitFour(){
        return this.hitFour;
    }
    public int getHitFive(){
        return this.hitFive;
    }
    public int getHitFiveAndBonus(){
        return this.hitFiveAndBonus;
    }
    public int getHitSix(){
        return this.hitSix;
    }

}
