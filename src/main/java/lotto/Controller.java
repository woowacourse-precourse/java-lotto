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

    public String inputBonusNumber() {
        ErrorUtil errorUtil = new ErrorUtil();
        OutputView outputView = new OutputView();
        outputView.printInputBonusNumber();
        String bonusNumber = readLine();
        errorUtil.errorInputBonusNumber(bonusNumber);
        errorUtil.errorInputCountBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public List<Integer> lottoNumber() {
        DataProcessing dataProcessing = new DataProcessing();
        String[] arrayNumbers = dataProcessing.splitLottoNumber(inputLottoNumber());
        List<Integer> numbers = new ArrayList<>();
        for (int i=0;i<arrayNumbers.length;++i)
            numbers.add(i);
        return numbers;
    }

    public void lottoRaffle() {
        DataProcessing dataProcessing = new DataProcessing();
        OutputView outputView = new OutputView();
        int countLotto = dataProcessing.countLotto(dataProcessing.conversionMoney(inputMoney()));
        outputView.printBuyCountLotto(countLotto);
        outputView.printRandomLottoNumber(dataProcessing.countCreateRandomNumbers(countLotto));
        lottoNumber();
        inputBonusNumber();
    }
}