package lotto;

import java.util.*;

public class ValidLotto {

    private final Lotto matching;
    private final LottoNum bonus;
    private int matchingCount;

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

    public Prize lottoPlace(Lotto user) {

        boolean isContainBonus = checkByBonus(user);
        int matchingCount = countByMatcher(user);


        if (matchingCount == Prize.FIRST.getMatchCount()) {
            return Prize.FIRST;
        }
        if (matchingCount == Prize.SECOND.getMatchCount()
                && isContainBonus == Prize.SECOND.isBonusCheck()) {
            return Prize.SECOND;
        }
        if (matchingCount == Prize.THIRD.getMatchCount()) {
            return Prize.THIRD;
        }
        if (matchingCount == Prize.FORTH.getMatchCount()){
            return Prize.FORTH;
        }
        if (matchingCount == Prize.FIFTH.getMatchCount()){
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }

    private int countByMatcher(Lotto userLotto) {

        List<LottoNum> matcherNumbers = matching.getNumbers();
        List<LottoNum> userNumbers = userLotto.getNumbers();

        userNumbers.retainAll(matcherNumbers);

        return userNumbers.size();
    }

    private boolean checkByBonus(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonus);
    }
}
