package lotto;

import java.util.*;

public class ValidLotto {

    private final Lotto matching;
    private final LottoNum bonus;

    public ValidLotto(List<Integer> matching, int bonus) {
        validate(matching, bonus);
        this.matching = new Lotto(matching);
        this.bonus = new LottoNum(bonus);
    }


    private void validate(List<Integer> matching, int bonus) {
        if (matching.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스숫자랑 본 당첨숫자랑 겹칩니다.");
        }
    }
}
