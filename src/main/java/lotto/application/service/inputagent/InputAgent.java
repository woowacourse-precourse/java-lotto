package lotto.application.service.inputagent;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.service.inputvalidator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputAgent {

    public int inputUserMoney() {
        String lottoPurchaseMoney = Console.readLine();
        InputValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
        return Integer.parseInt(lottoPurchaseMoney);
    }

    public List<Integer> inputWinningNumbers() {
        String[] lottoNumbers = Console.readLine().split(",");
        List<Integer> convertedLottoNumbers = new ArrayList<>();
        InputValidator.validateIntegerValue(lottoNumbers);

        for (String value : lottoNumbers) {
            convertedLottoNumbers.add(Integer.parseInt(value));
        }
        InputValidator.validateInputLottoNumber(convertedLottoNumbers);
        return convertedLottoNumbers;
    }

    public int inputBonusNumber(List<Integer> winningLottoNumbers) {
        String inputBonusNumber = Console.readLine();
        InputValidator.validateInputBonusLottoNumber(inputBonusNumber, winningLottoNumbers);
        return Integer.parseInt(inputBonusNumber);
    }
}
