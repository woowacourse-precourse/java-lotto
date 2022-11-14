package lotto;

import static lotto.domain.model.ErrorMessage.printErrorMessage;

import lotto.domain.controller.LottoController;
import lotto.domain.view.InputData;

public class LottoProgram {

    private static final LottoController lottoController = new LottoController();
    private LottoProgram(){}

    private static class LottoHolder {
        private static final LottoProgram INSTANCE = new LottoProgram();
    }

    public static LottoProgram getInstance(){
        return LottoHolder.INSTANCE;
    }

    public void start(){
        try{
            purchase();
            inputFirstPlace();
            inputBonus();
            calculateResult();
        } catch (IllegalArgumentException exception){
            printErrorMessage(exception);
        }


    }
    private void purchase(){
        lottoController.purchaseLotto(InputData.purchaseLotto());
    }

    private void inputFirstPlace(){
        lottoController.designateFirstPlace(InputData.designateFirstPlace());
    }

    private void inputBonus(){
        lottoController.designateBonus(InputData.designateBonus());
    }

    private void calculateResult() {
        lottoController.calculateStatisticsByUserLotto();
    }

}
