package lotto;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Target_Lotto {

    public static Lotto get_target() {
        System.out.println("당첨 번호를 입력해 주세요");
        String input = readLine();
        System.out.println();
        return String_to_Lotto(input);
    }

    public static Lotto String_to_Lotto(String input) {
        List<Integer> target = new ArrayList<>();
        String[] tmp = input.split(",");
        for (String a : tmp) {
            target.add(Integer.parseInt(a));
        }
        return new Lotto(target);
    }

    public static int bonus_num(Lotto lotto, int bonus) {

        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(Error.BonusRangeError.print());
        }
        if (lotto.numbers.contains(bonus)) {
            throw new IllegalArgumentException(Error.BonusMultiError.print());
        }
        return bonus;
    }

    public static int get_bonus() {
        System.out.println("보너스 번호를 입력해 주세요");
        int bonus = Integer.parseInt(readLine());
        return bonus;
    }
}
