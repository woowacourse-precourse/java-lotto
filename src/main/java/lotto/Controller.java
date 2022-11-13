package  lotto;

import java.util.ArrayList;
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

    public String inputBonusNumber(List<Integer> lottoNumber) {
        ErrorUtil errorUtil = new ErrorUtil();
        OutputView outputView = new OutputView();
        outputView.printInputBonusNumber();
        String bonusNumber = readLine();
        List<Integer> temp = lottoNumber;
        temp.add(Integer.parseInt(bonusNumber));
        errorUtil.errorInputBonusNumber(bonusNumber);
        errorUtil.errorOverlapLottoNumber(temp);
        System.out.println(lottoNumber);
        return bonusNumber;
    }

    public List<Integer> lottoNumber() {
        DataProcessing dataProcessing = new DataProcessing();
        ErrorUtil errorUtil = new ErrorUtil();
        String[] arrayNumbers = dataProcessing.splitLottoNumber(inputLottoNumber());
        List<Integer> numbers = new ArrayList<>();
        for (String arrayNumber : arrayNumbers) numbers.add(Integer.parseInt(arrayNumber));
        errorUtil.errorOverlapLottoNumber(numbers);
        return numbers;
    }

    public void lottoRaffle() {
        DataProcessing dataProcessing = new DataProcessing();
        OutputView outputView = new OutputView();
        int countLotto = dataProcessing.countLotto(dataProcessing.conversionMoney(inputMoney()));
        outputView.printBuyCountLotto(countLotto);
        List<List<Integer>> boxRandomNumber = dataProcessing.countCreateRandomNumbers(countLotto);
        outputView.printRandomLottoNumber(boxRandomNumber);
        List<Integer> lottoNumber = lottoNumber();
        Lotto lotto = new Lotto(lottoNumber);
        inputBonusNumber(lottoNumber);
        List<Integer> countWin = dataProcessing.countWinLotto(lottoNumber, boxRandomNumber, countLotto);
        System.out.println(countWin);
    }
}