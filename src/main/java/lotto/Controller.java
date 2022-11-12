package  lotto;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    public String inputMoney() {
        String money = readLine();
        return money;
    }

    public String inputLottoNumber() {
        String lottoNumbers = readLine();
        return lottoNumbers;
    }

    public String inputBonusNumber() {
        String bonusNumber = readLine();
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
}