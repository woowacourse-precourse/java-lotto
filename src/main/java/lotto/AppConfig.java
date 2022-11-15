package lotto;

import lotto.controller.LottoSystemController;
import lotto.domain.LottoVendingMachine;
import lotto.domain.LottoVendingMachineImple;
import lotto.domain.ReturnRatioCalculator;
import lotto.domain.ReturnRatioCalculatorImple;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningNumbersImple;
import lotto.domain.WinningResultCalculator;
import lotto.domain.WinningResultCalculatorImple;
import lotto.domain.WinningStatusCalculator;
import lotto.domain.WinningStatusCalculatorImple;
import lotto.view.inputView.InputView;
import lotto.view.inputView.InputViewImple;
import lotto.view.outputView.OutputView;
import lotto.view.outputView.OutputViewImple;

public class AppConfig {
    //의존관계 주입은 여기서만 한다
    public LottoVendingMachine createLottoVendingMachine(){
        return new LottoVendingMachineImple();
    }

    public WinningResultCalculator createWinningResultCalculator(){
        return new WinningResultCalculatorImple(createWinningStatusCalculator()
                ,createReturnRatioCalculator());
    }

    private ReturnRatioCalculator createReturnRatioCalculator(){
        return new ReturnRatioCalculatorImple();
    }

    private WinningStatusCalculator createWinningStatusCalculator(){
        return new WinningStatusCalculatorImple();
    }

    public WinningNumbers createWinningNumbers(){
        return new WinningNumbersImple();
    }

    public LottoSystemController createLottoSystemController(){
        return new LottoSystemController(createLottoVendingMachine()
                ,createWinningNumbers()
                ,createWinningResultCalculator()
                ,creatOutputView()
                ,createInputView());
    }

    private InputView createInputView(){
        return new InputViewImple();
    }

    private OutputView creatOutputView(){
        return new OutputViewImple();
    }

}
