package lotto;

import java.util.ArrayList;
import java.util.List;

public class CompareNumberWithBonus {
    public static List<Integer> jugementNumberWithBonus(int InputMoney) {
        List<Integer> resultNumber = new ArrayList<>();
        /**
         * 함수 분리
         */

        List<Integer> correctNumber = CorrectNumberGenerator.createCorrectNumber();
        int bonusNumber = BonusNumberGenerator.createBonusNumber(correctNumber);

        for(int i=0; i<InputMoney; i++) {
            List<Integer> UserPickNumber = UserNumberGenerator.createRandomNumbers();
            int returnNumber = CompareNumber.jugementNumber(UserPickNumber, correctNumber);
            if (UserPickNumber.contains(bonusNumber)) {
                returnNumber += 1;
            }
            resultNumber.add(returnNumber);
        }
//        System.out.println(resultNumber);
        return resultNumber;
    }
}
