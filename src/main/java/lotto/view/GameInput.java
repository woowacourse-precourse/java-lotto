package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;


public class GameInput {

    public static int inputUserPay() {
        String money = Console.readLine().trim();
        ValidateUtils.checkNumberType(money);
        ValidateUtils.checkUnit(Integer.parseInt(money));
        return Integer.parseInt(money);
    }

    public static List<Integer> inputLottoNumbers() {
        String inputList = Console.readLine().trim();
        String[] inputs = inputList.split(",");

        ValidateUtils.checkSeparator(inputs.length);
        ValidateUtils.checkInputSize(inputs.length, 6);

        List<Integer> answer = new ArrayList<>();
        for (String input : inputs) {
            int lottoNumber = Integer.parseInt(input);
            ValidateUtils.checkNumberRange(lottoNumber);
            ValidateUtils.checkDuplicatedRange(answer, lottoNumber);
            answer.add(lottoNumber);
        }
        return answer;
    }

    public static int inputBonusLottoNumber() {
        String bonus = Console.readLine().trim();
        ValidateUtils.checkNumberType(bonus);
        ValidateUtils.checkInputSize(bonus.length(), 1);
        ValidateUtils.checkNumberRange(Integer.parseInt(bonus));
        return Integer.parseInt(bonus);
    }
}
