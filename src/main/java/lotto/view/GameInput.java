package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.ValidateUtils;

public class GameInput {

    public static int inputUserPay() {
        String money = Console.readLine().trim();
        ValidateUtils.checkTypeNumber(money);
        ValidateUtils.checkMoneyUnit(Integer.parseInt(money));
        return Integer.parseInt(money);
    }

    public static List<Integer> inputWinLottoNumbers() {
        String answerList = Console.readLine().trim();
        String[] answers = answerList.split(",");
        ValidateUtils.checkDelimiter(answers.length);
        ValidateUtils.checkArraySize(answers.length, 6);
        List<Integer> answerLotto = new ArrayList<>();
        for (String answer : answers) {
            int number = Integer.parseInt(answer);
            ValidateUtils.checkRangeNumber(number);
            ValidateUtils.checkDuplicateNumber(answerLotto, number);
            answerLotto.add(number);
        }
        return answerLotto;
    }

    public static int inputBonusLottoNumber() {
        String bonus = Console.readLine().trim();
        ValidateUtils.checkTypeNumber(bonus);
        ValidateUtils.checkArraySize(bonus.length(), 1);
        ValidateUtils.checkRangeNumber(Integer.parseInt(bonus));
        return Integer.parseInt(bonus);
    }
}
