package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.GenerateLottoNumbers.generateLottoNumber;
import static lotto.view.InputLotto.*;
import static lotto.view.OutputLotto.*;

public class GameSet {
    final static int PRICE_SIZE = 6;
    Lotto awardLotto;
    final int lottoCount;
    private List<Lotto> generatedLotto = new ArrayList<>();
    private int totalPrize;
    private int bonusNumber;
    private int[] gameCount;
    public GameSet(){
        gameCount = new int[PRICE_SIZE];
        totalPrize = 0;
        lottoCount = moneyInput();
    }
    public void generateLotto(){
        for(int i =0;i<lottoCount;i++) {
            generatedLotto.add(new Lotto(generateLottoNumber()));
            numberPrint(generatedLotto.get(i).getNumbers());
        }
    }
    public void generateAwardLotto(){
        inputView_First();
        awardLotto= new Lotto(getInput());
        inputView_Second();
        bonusNumber = getInput().get(0);
    }
    public void updateGameSet(LottoProperties lottoProperties){
        gameCount[lottoProperties.getIndex()]++;
        totalPrize+=lottoProperties.getPrice();
    }
    public Lotto getAwardLotto(){
        return awardLotto;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
    public int[] getGameCount(){
        return gameCount;
    }
    public double getResult(){
        return ((double)totalPrize/(double) (lottoCount*1000))*100;
    }
    public List<Lotto> getGeneratedLotto(){
        return generatedLotto;
    }
}
