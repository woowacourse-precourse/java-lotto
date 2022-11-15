package lotto.domain;

import lotto.exception.ErrorHandler;
import lotto.utils.GenerateLottoNumbers;
import lotto.view.InputLotto;
import lotto.view.InputPrintView;
import lotto.view.OutputLotto;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public final static int PRICE_SIZE = 6;
    private final int lottoCount;
    private Lotto awardLotto;
    private int[] gameCount;
    private int totalPrize;
    private int bonusNumber;
    private List<Lotto> generatedLotto = new ArrayList<>();
    public Game(){
        gameCount = new int[PRICE_SIZE];
        totalPrize = 0;
        lottoCount = InputLotto.moneyInput();
    }
    public void generateLotto(){
        for(int i =0;i<lottoCount;i++) {
            generatedLotto.add(new Lotto(GenerateLottoNumbers.generateLottoNumber()));
            OutputLotto.numberPrint(generatedLotto.get(i).getNumbers());
        }
    }
    public void generateAwardLotto(){
        InputPrintView.inputView_First();
        awardLotto= new Lotto(InputLotto.getInput());
        InputPrintView.inputView_Second();
        bonusNumber = InputLotto.getInput().get(0);
        isBonusUnique(bonusNumber);
    }
    public void updateGame(LottoProperties lottoProperties){
        gameCount[lottoProperties.getIndex()]++;
        totalPrize+=lottoProperties.getPrice();
    }
    private void isBonusUnique(int bonusNumber){
        if(awardLotto.getNumbers().contains(bonusNumber)){
            ErrorHandler.mutualInputException();
        }
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
