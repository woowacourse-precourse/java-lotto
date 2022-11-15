package lotto.controller;

import lotto.domain.*;
import lotto.util.InputChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private UserLotto userLotto;
    private InputView inputView;
    private InputChecker inputChecker;
    private OutputView outputView;
    private WinningLotto winningLotto;
    private WinningResult winningResult;

    public LottoGame(){
        inputView=new InputView();
        inputChecker=new InputChecker();
        outputView=new OutputView();
        winningResult=new WinningResult();
    }
    public void startGame() throws IllegalArgumentException{
        getMoneyInput();
        getLottoNumberInput();
        winningResult.calcCorrectCountLottos(userLotto, winningLotto);
        outputView.printLottoResultAll(winningResult);
        outputView.printRateOfReturn(winningResult, userLotto.getMoney());
    }
    public void getMoneyInput() throws IllegalArgumentException{
        String input=inputView.inputMoney();
        if(inputChecker.checkInputMoney(input)){
            userLotto=new UserLotto(Integer.parseInt(input));
            System.out.printf("%d%s\n", userLotto.getLottoCount(), outputView.printLottoPurchaseCount());
            outputView.printLottoNumbersAll(userLotto.getLottos());
        }
    }
    public void getLottoNumberInput() throws IllegalArgumentException {
        Lotto winningLottoNumbers=getLottoWinningNumbersInput();

        int bonus=getBonusNumberInput(winningLottoNumbers);
        if(bonus!=-1){
            winningLotto=new WinningLotto(winningLottoNumbers, bonus);
        }
    }
    public Lotto getLottoWinningNumbersInput() throws IllegalArgumentException{
        String input=inputView.inputWinningNumber();
        if(input.contains(" ")){
            throw new IllegalArgumentException(ErrorMessage.INPUT_LOTTO_NUMBERS_CONTAIN_BLANK.print());
        }
        List<String> inputWinningLottoNumbers = Arrays.asList(input.split(","));
        List<Integer> changeStringToIntegerLottoNumbers=new ArrayList<>();
        if(inputChecker.checkInputWinningLottoNumbersIsNumeric(inputWinningLottoNumbers)){
            for(String number : inputWinningLottoNumbers){
                changeStringToIntegerLottoNumbers.add(Integer.parseInt(number));
            }
        }
        return new Lotto(changeStringToIntegerLottoNumbers);
    }
    public Integer getBonusNumberInput(Lotto winningLotto) throws IllegalArgumentException{
        String input=inputView.inputBonusNumber();
        int bonus=-1;
        if(inputChecker.checkInputBonusNumber(input, winningLotto.getLotto())){
            bonus=Integer.parseInt(input);
        }
        return bonus;
    }
}
