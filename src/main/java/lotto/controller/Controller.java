package lotto.controller;

import lotto.console.InputConsole;
import lotto.console.OutputConsole;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;

import java.util.List;

public class Controller {
    private InputConsole input = new InputConsole();
    private OutputConsole output = new OutputConsole();
    private LottoManager lottoManager = new LottoManager();

    private Lotto lotto;
    public int findLottoCount(){
        String inputMoney = input.Money();
        int lottoCount = lottoManager.countLotto(inputMoney);
        output.lottoCount(lottoCount);
        return lottoCount;
    }

    public void makeRandomNum(int lottoCount){
        List<List<Integer>> randomNumbers = lottoManager.makeRandomNumbers(lottoCount);
        output.randomNumbers(randomNumbers);
    }


    
}
