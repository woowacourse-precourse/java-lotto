package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    public static List<Lotto> publishLotto(int count) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lotto;
    }

    public static Map<Reward, Integer> calculateResult(List<Lotto> userLotto, Lotto winningNumber, int bonusNumber) {
        Map<Reward, Integer> result = makeBlankResult();

        for (int i = 0; i < userLotto.size(); i++) {
            int bingo = calculateBingo(userLotto, winningNumber, i);
            boolean bonus = userLotto.get(i).isContain(bonusNumber);

            if (3 <= bingo && bingo <= 6) {
                result.put((Reward.getRanKing(bingo, bonus)), result.get(Reward.getRanKing(bingo, bonus)) + 1);
            }
        }
        return result;
    }

    public static Map<Reward, Integer> makeBlankResult() {
        Map<Reward, Integer> result = new EnumMap<>(Reward.class) {{
            put(Reward.FIFTH, 0);
            put(Reward.FOURTH, 0);
            put(Reward.THIRD, 0);
            put(Reward.SECOND, 0);
            put(Reward.FIRST, 0);
        }};

        return result;
    }

    public static int calculateBingo(List<Lotto> userLotto, Lotto winningNumber, int idx) {
        int bingo = userLotto.get(idx)
                .getNumbers()
                .stream()
                .filter(s -> winningNumber.isContain(s))
                .mapToInt(n -> 1)
                .sum();

        return bingo;
    }
}
