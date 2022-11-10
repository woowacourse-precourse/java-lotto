package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.ValueValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputAgent {

    public int inputUserMoney() {
        String lottoPurchaseMoney = Console.readLine();
        ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
        return Integer.parseInt(lottoPurchaseMoney);
    }

    public List<Integer> inputWinningNumbers() {
        String[] lottoNumbers = Console.readLine().split(",");
        List<Integer> convertedLottoNumbers = new ArrayList<>();
        for (String value : lottoNumbers) {
            convertedLottoNumbers.add(Integer.parseInt(value));
        }
        ValueValidator.validateInputLottoNumber(convertedLottoNumbers);
        return convertedLottoNumbers;
    }

    public int inputWinningBonusNumber() {
        List<Integer> bonusNumber = Collections.singletonList(Integer.parseInt(Console.readLine()));
        ValueValidator.validateInputLottoNumber(bonusNumber);
        return bonusNumber.get(0);
    }
}
