package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoInput;
import lotto.model.LottoResult;
import lotto.model.LottoStatistics;
import lotto.util.InputValidator;
import lotto.util.RandomLottoGenerator;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    InputController inputController;

    public void init(){
        this.inputController = new InputController(new LottoInput());
    }

    public void run(){
        init();
        inputController.getPurchaseAmount();
        createLotto();
        inputController.inputWinNumber();
        inputController.inputBonusNumber();
        printLottoStatistics();
    }

    private void printLottoStatistics() {
        LottoStatistics.calculateRank();
        ResultView.printStatistics();
    }


    private void createLotto() {
        LottoResult.lottos = new ArrayList<>();
        for(int i=0 ; i<LottoResult.count;i++) {
            Lotto lotto = new Lotto(RandomLottoGenerator.generateRandomNumber());
            LottoResult.lottos.add(lotto);
        }
        LottoResult.printLottoList();
    }



}
