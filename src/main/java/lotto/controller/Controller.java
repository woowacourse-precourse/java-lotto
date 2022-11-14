package lotto.controller;

import lotto.console.InputConsole;
import lotto.console.OutputConsole;
import lotto.domain.LottoManager;

public class Controller {
    private InputConsole input = new InputConsole();
    private OutputConsole output = new OutputConsole();
    private LottoManager lottoManager = new LottoManager();

    public void findLottoCount(){
        String inputMoney = input.Money();
        int lottoCount = lottoManager.countLotto(inputMoney);
        output.lottoCount(lottoCount);
    }
    
}
