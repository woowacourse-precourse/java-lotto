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

    public Prize lottoPlace(Lotto user) {
        int matcherCount = countByMatcher(user);
        boolean isContainBonus = checkByBonus(user);

        if (matcherCount == Prize.FIRST.getMatchCount()) {
            return Prize.FIRST;
        }
        if (matcherCount == Prize.SECOND.getMatchCount()
                && isContainBonus == Prize.SECOND.isBonusCheck()) {
            return Prize.SECOND;
        }
        if (matcherCount == Prize.THIRD.getMatchCount()) {
            return Prize.THIRD;
        }
        if (matcherCount == Prize.FORTH.getMatchCount()){
            return Prize.FORTH;
        }
        if (matcherCount == Prize.FIFTH.getMatchCount()){
            return Prize.FIFTH;
        }
        return Prize.NONE;
    }

    private int countByMatcher(Lotto userLotto) {
        Set<LottoNum> notDuplicatedLottoNumbers = new HashSet<LottoNum>();

        List<LottoNum> matcherNumbers = matching.getNumbers();
        List<LottoNum> userNumbers = userLotto.getNumbers();

        notDuplicatedLottoNumbers.addAll(matcherNumbers);
        notDuplicatedLottoNumbers.addAll(userNumbers);

        return matcherNumbers.size() + userNumbers.size()
                - notDuplicatedLottoNumbers.size();
    }

    private boolean checkByBonus(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonus);
    }
}
