package lotto;

import io.Input;
import io.Output;
import io.Sentence;
import java.util.ArrayList;
import java.util.List;

public class Bonus {

    private static Lotto bonusLotto;

    public static Lotto inputBonus(Input input, Output output, Lotto answer) {
        String bonusInput = input.getInput(Sentence.INPUT_BONUS.getValue(), output);
        bonusLotto = inputValidity(bonusInput, answer);
        return bonusLotto;
    }

    public static Lotto inputValidity(String input, Lotto answer) {
        checkBonusNum(input);
        return (checkBonusNotInWinning(checkBonusInRange(input), answer));
    }

    private static void checkBonusNum(String input) {
        long count = input.chars()
            .filter(Character::isDigit)
            .count();
        if (count != input.length()) {
            throw new IllegalArgumentException("[ERROR] Bonus input is not numeric");
        }
    }

    private static int checkBonusInRange(String input) {
        if (!(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 45)) {
            throw new IllegalArgumentException("[ERROR] Bonus input is out of range");
        }
        return Integer.parseInt(input);
    }

    private static Lotto checkBonusNotInWinning(int input, Lotto answer) {
        List<Integer> wrappedBonus = new ArrayList<>();
        wrappedBonus.add(input);
        while (wrappedBonus.size() < 6) {
            wrappedBonus.add(0);
        }
        Lotto bonusLotto = new Lotto(wrappedBonus);
        if (LottoCalculator.getCountOfSameNumber(bonusLotto, answer) == 1) {
            throw new IllegalArgumentException("[ERROR] Bonus input is included in answer");
        }
        return bonusLotto;
    }
}
