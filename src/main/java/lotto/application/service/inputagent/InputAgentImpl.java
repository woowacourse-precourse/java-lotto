package lotto.application.service.inputagent;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.service.inputvalidator.InputValidatorImpl;

import java.util.ArrayList;
import java.util.List;

import static lotto.application.service.inputvalidator.InputValidatorImpl.winningNumberIsNumeric;

public class InputAgentImpl implements InputAgent {

    @Override
    public int inputUserPurchaseMoney() {
        String lottoPurchaseMoney = Console.readLine();
        InputValidatorImpl.validateLottoPurchaseMoney(lottoPurchaseMoney);

        return Integer.parseInt(lottoPurchaseMoney);
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        String lottoNumber = Console.readLine();
        winningNumberIsNumeric(lottoNumber.substring(lottoNumber.length() - 1));

        String[] lottoNumbers = lottoNumber.split(",");
        List<Integer> convertedLottoNumbers = new ArrayList<>();

        InputValidatorImpl.validateWinningNumbersAreInteger(lottoNumbers);

        for (String value : lottoNumbers) {
            convertedLottoNumbers.add(Integer.parseInt(value));
        }

        InputValidatorImpl.validateInputLottoNumber(convertedLottoNumbers);

        return convertedLottoNumbers;
    }

    @Override
    public int inputBonusNumber(List<Integer> winningLottoNumbers) {
        String inputBonusNumber = Console.readLine();
        InputValidatorImpl.validateInputBonusLottoNumber(inputBonusNumber, winningLottoNumbers);

        return Integer.parseInt(inputBonusNumber);
    }
}
