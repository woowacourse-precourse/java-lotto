package  lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    public String inputMoney() {
        OutputView outputView = new OutputView();
        outputView.printInputMoney();
        return readLine();
    }

    public String inputLottoNumber() {
        OutputView outputView = new OutputView();
        outputView.printInputLottoNumber();
        return readLine();
    }

    public int inputBonusNumber(List<Integer> lottoNumber) {
        ErrorUtil errorUtil = new ErrorUtil();
        OutputView outputView = new OutputView();
        outputView.printInputBonusNumber();
        String bonusNumber = readLine();
        lottoNumber.add(Integer.parseInt(bonusNumber));
        errorUtil.errorInputBonusNumber(bonusNumber);
        errorUtil.errorOverlapLottoNumber(lottoNumber);
        lottoNumber.remove(6);
        return Integer.parseInt(bonusNumber);
    }


    public void lottoRaffle() {
        DataProcessing dataProcessing = new DataProcessing();
        OutputView outputView = new OutputView();
        int countLotto = dataProcessing.countLotto(dataProcessing.conversionMoney(inputMoney()));
        outputView.printBuyCountLotto(countLotto);
        List<List<Integer>> boxRandomNumber = dataProcessing.countCreateRandomNumbers(countLotto);
        outputView.printRandomLottoNumber(boxRandomNumber);
        Lotto lotto = new Lotto(dataProcessing.lottoNumber(inputLottoNumber()));
        int bonusNumber = inputBonusNumber(lotto.getNumbers());
        List<Integer> countWin = dataProcessing.countWinLotto(lotto.getNumbers(), boxRandomNumber, countLotto, bonusNumber);
        int[] resultWin = dataProcessing.resultWinLotto(countWin);
        outputView.printWinResultLotto(resultWin);
        outputView.printResultReturn(dataProcessing.totalReturn(countLotto, resultWin));
    }
}