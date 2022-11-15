package lotto;

import lotto.View.Data;

import static lotto.Model.Error.printError;

public class Start {

    private static final Controller Controller = new Controller();
    private Start(){}

    private static class LottoHolder {
        private static final Start INSTANCE = new Start();
    }

    public static Start getInstance(){
        return LottoHolder.INSTANCE;
    }

    public void start(){
        try{
            purchase();
            inputFirstPlace();
            inputBonus();
            calResult();
        } catch (IllegalArgumentException exception){
            printError(exception);
        }


    }
    private void purchase(){
        Controller.purchaseLotto(Data.BuyLotto());
    }

    private void inputFirstPlace(){
        Controller.FirstPlace(Data.FirstRate());
    }

    private void inputBonus(){
        Controller.Bonus(Data.Bonus());
    }

    private void calResult() {
        Controller.calRateUser();
    }
}
