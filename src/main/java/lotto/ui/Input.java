package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.ValidateUtils;

public class Input {

     public void inputUserPay() {
         String money = Console.readLine().trim();
         ValidateUtils.checkMoneyUnit(Integer.parseInt(money));
     }

     public List<Integer> inputWinLottoNumbers() {
         String answerList = Console.readLine().trim();
         String[] answers = answerList.split(",");
         ValidateUtils.checkDelimiter(answers.length);
         ValidateUtils.checkArraySize(answers.length, 6);
         List<Integer> answerLotto = new ArrayList<>();
         for(String answer : answers) {
             int number = Integer.parseInt(answer);
             ValidateUtils.checkRangeNumber(number);
             ValidateUtils.checkDuplicateNumber(answerLotto, number);
             answerLotto.add(number);
         }
         return answerLotto;
     }

     public void inputBonusLottoNumber() {
         String bonus = Console.readLine().trim();
         ValidateUtils.checkArraySize(1, 6);
         ValidateUtils.checkRangeNumber(Integer.parseInt(bonus));
     }
}
