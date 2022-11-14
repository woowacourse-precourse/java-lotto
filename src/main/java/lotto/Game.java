package lotto;

public class Game {
    private int bonusNumber;
    private int lottoCount;


    public int getBonusNumber(){
        return this.bonusNumber;
    }

    public int getLottoCount(){
        return this.lottoCount;
    }

    public void changeBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public void changeLottoCount(int lottoCount){
        this.lottoCount = lottoCount;
    }
}
