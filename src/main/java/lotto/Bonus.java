package lotto;

import io.Input;
import io.Output;
import io.Sentence;
import java.util.List;

public class Bonus {

    private static int BONUSNUMBER = 0;
    private static final int INCLUDED = 1;

    Bonus(int input) {
        validity(input);
        this.BONUSNUMBER = input;
    }

    public static List<Integer> InputAnswer(Input input, Output output, Lotto answer) {
        String bonusInput = input.getInput(Sentence.INPUTBONUS.getValue(), output);
        inputValidity(bonusInput, answer);
        List<Integer> retVal = null; // 임시

        //빈 리스트에 저 보너스 숫자 쳐넣고 로또로 묶어서 리턴.
        return retVal;
    }

    private static void inputValidity(String input, Lotto answer) {
        //input이 숫자가 맞는지, 로또 정답이랑 맞는지 비교한다.
        checkBonusNum(input);
//        checkBonusInRange(input);
        checkBonusNotInWinning(checkBonusInRange(input), answer);
    }

    private static void checkBonusNum(String input) {
        long count = input.chars()
            .filter(Character::isDigit)
            .count();
        if (count != input.length()) {
            throw new IllegalArgumentException("Bonus input is not numeric");
        }
    }

    private static int checkBonusInRange(String input) {
        if (!(Integer.parseInt(input) >= 1 && Integer.parseInt(input) >= 45)) {
            throw new IllegalArgumentException("Bonus input is out of range");
        }
        return Integer.parseInt(input);
    }

    private static void checkBonusNotInWinning(int input, Lotto answer) {
        if (answer.compareBonus(input) == INCLUDED) {
            throw new IllegalArgumentException("Bonus input is included in answer");
        }
        //컴페어 보너스를 로또 클래스에서 결과를 받자.
    }

}
