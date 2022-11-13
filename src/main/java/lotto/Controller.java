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
        lottoNumber.add(Integer.parseInt(bonusNumber));
        errorUtil.errorInputBonusNumber(bonusNumber);
        errorUtil.errorOverlapLottoNumber(lottoNumber);
        return bonusNumber;
    }

    public List<Integer> lottoNumber() {
        DataProcessing dataProcessing = new DataProcessing();
        ErrorUtil errorUtil = new ErrorUtil();
        String[] arrayNumbers = dataProcessing.splitLottoNumber(inputLottoNumber());
        List<Integer> numbers = new ArrayList<>();
        for (int i=0;i<arrayNumbers.length;++i)
            numbers.add(Integer.parseInt(arrayNumbers[i]));
        errorUtil.errorOverlapLottoNumber(numbers);
        return numbers;
    }

    public void lottoRaffle() {
        DataProcessing dataProcessing = new DataProcessing();
        OutputView outputView = new OutputView();
        int countLotto = dataProcessing.countLotto(dataProcessing.conversionMoney(inputMoney()));
        outputView.printBuyCountLotto(countLotto);
        outputView.printRandomLottoNumber(dataProcessing.countCreateRandomNumbers(countLotto));
        List<Integer> lottoNumber = lottoNumber();
        Lotto lotto = new Lotto(lottoNumber);
        inputBonusNumber(lottoNumber);
    }
}