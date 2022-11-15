package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    public static final String COMMA_REGEX = "\\s*,\\s*";

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
            int score = calculateScore(userLotto.get(i), winningNumber);
            boolean bonusScore = userLotto.get(i).isContain(bonusNumber);

            if (3 <= score && score <= 6) {
                result.put((Reward.getRanKing(score, bonusScore)), result.get(Reward.getRanKing(score, bonusScore)) + 1);
            }
        }
        return result;
    }

    public static Map<Reward, Integer> makeBlankResult() {
        Map<Reward, Integer> blankResult = new EnumMap<>(Reward.class) {{
            put(Reward.FIFTH, 0);
            put(Reward.FOURTH, 0);
            put(Reward.THIRD, 0);
            put(Reward.SECOND, 0);
            put(Reward.FIRST, 0);
        }};

        return blankResult;
    }

    public static int calculateScore(Lotto userLotto, Lotto winningNumber) {
        int score = userLotto.getNumbers()
                .stream()
                .filter(s -> winningNumber.isContain(s))
                .mapToInt(n -> 1)
                .sum();

        return score;
    }

    public static int calculateAmount(String input) {
        int money = Integer.parseInt(input);

        return money / 1000;
    }

    public static Lotto calculateWinningNumber(String input) {
        Lotto lotto = new Lotto(Stream.of(input.split(COMMA_REGEX))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList()));

        return lotto;
    }
}
