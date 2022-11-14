package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.Lotto.validateNumberRange;

public class Bonus {
    public static int BonusNumber;
    public static void askBonusNumber() {
        System.out.println("\n"+Constant.ASK_BONUS_NUMBER);
        String Bonus = Console.readLine();
        BonusNumber = Integer.parseInt(Bonus);
        List<Integer> JackpotNumbers = Game.inputJackpotNum();
        Lotto lotto = new Lotto(JackpotNumbers);

        validateNumberRange(BonusNumber);
        BonusValidate(BonusNumber,lotto.getNumbers());
    }

    private static void BonusValidate(int BonusNumber, List<Integer> numbers) {
        if (numbers.contains(BonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
        }
    }
}
