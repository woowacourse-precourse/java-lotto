package lotto.application.util.inputagent;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.util.inputvalidator.InputValidator;
import lotto.application.util.inputvalidator.InputValidatorImpl;

import java.util.ArrayList;
import java.util.List;


public class InputAgentImpl implements InputAgent {

    private final InputValidator inputValidator = InputValidatorImpl.getInputValidatorInstance();

    @Override
    public int inputUserPurchaseMoney() {
        String lottoPurchaseMoney = Console.readLine();
        inputValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);

        return Integer.parseInt(lottoPurchaseMoney);
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        String lottoNumber = Console.readLine();
        inputValidator.winningNumbersAreNumeric(lottoNumber.substring(lottoNumber.length() - 1));

        String[] lottoNumbers = lottoNumber.split(",");
        List<Integer> convertedLottoNumbers = new ArrayList<>();

        inputValidator.validateWinningNumbersAreInteger(lottoNumbers);

        for (String value : lottoNumbers) {
            convertedLottoNumbers.add(Integer.parseInt(value));
        }

        inputValidator.validateInputLottoNumbers(convertedLottoNumbers);

        return convertedLottoNumbers;
    }

    @Override
    public int inputBonusNumber(List<Integer> winningLottoNumbers) {
        String inputBonusNumber = Console.readLine();
        inputValidator.validateInputBonusLottoNumber(inputBonusNumber, winningLottoNumbers);

        return Integer.parseInt(inputBonusNumber);
    }
}