package lotto.domain;

import lotto.view.InputLotto;
import lotto.view.InputPrintView;
import lotto.view.OutputLotto;

public class Game {
    public final static int PRICE_SIZE = 6;
    private int lottoCount;
    private Lotto awardLotto;
    private GameCount gameCount;
    private int totalPrize;
    private LottoBonusNumber lottoBonusNumber;
    private UserLotto generatedLotto;
    public Game(){
        gameCount = new GameCount(PRICE_SIZE);
        generatedLotto = new UserLotto();
        totalPrize = 0;
    }
    public void inputLottoCount(){
        lottoCount = InputLotto.moneyInput();
    }
    public void generateLotto(){
        for(int i =0;i<lottoCount;i++) {
            generatedLotto.addUserLotto();
            OutputLotto.numberPrint(generatedLotto.getUserLotto().get(i).getNumbers());
        }
    }
    public void generateLottoBonusNumber(){
        lottoBonusNumber = new LottoBonusNumber(this);
    }
    public void generateAwardLotto(){
        InputPrintView.inputView_First();
        awardLotto= new Lotto(InputLotto.getInput());
    }
    public void updateGame(LottoProperties lottoProperties){
        gameCount.addIndex(lottoProperties.getIndex());
        totalPrize+=lottoProperties.getPrice();
    }
    public Lotto getAwardLotto(){
        return awardLotto;
    }
    public GameCount getGameCount(){
        return gameCount;
    }
    public double getResult(){
        return ((double)totalPrize/(double) (lottoCount*1000))*100;
    }
    public UserLotto getGeneratedLotto(){
        return generatedLotto;
    }
    public LottoBonusNumber getLottoBonusNumber(){
        return lottoBonusNumber;
    }
}
