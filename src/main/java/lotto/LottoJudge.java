package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoJudge {

    private final Lotto matcher;
    private final LottoNumber bonus;

    public LottoJudge(List<Integer> matcher, int bonus) {
        validate(matcher, bonus);
        this.matcher = new Lotto(matcher);
        this.bonus = new LottoNumber(bonus);
    }

    private void validate(List<Integer> matcher, int bonus) {
        if (matcher.contains(bonus)) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT
                            + InvalidInputMessage.ERR_DUPLICATED_NUMBER
            );
        }
    }

    public LottoPlace judgePlace(Lotto userLotto) {
        int matcherCount = countByMatcher(userLotto);
        boolean isContainBonus = checkByBonus(userLotto);

        if (matcherCount == LottoPlace.FIRST.getMatchCount()) {
            return LottoPlace.FIRST;
        }
        if (matcherCount == LottoPlace.SECOND.getMatchCount()
                && isContainBonus == LottoPlace.SECOND.isBonusCheck()) {
            return LottoPlace.SECOND;
        }
        if (matcherCount == LottoPlace.THIRD.getMatchCount()) {
            return LottoPlace.THIRD;
        }
        if (matcherCount == LottoPlace.FORTH.getMatchCount()){
            return LottoPlace.FORTH;
        }
        if (matcherCount == LottoPlace.FIFTH.getMatchCount()){
            return LottoPlace.FIFTH;
        }
        return LottoPlace.NONE;
    }

    private int countByMatcher(Lotto userLotto) {
        Set<LottoNumber> notDuplicatedLottoNumbers = new HashSet<LottoNumber>();

        List<LottoNumber> matcherNumbers = matcher.getNumbers();
        List<LottoNumber> userNumbers = userLotto.getNumbers();

        notDuplicatedLottoNumbers.addAll(matcherNumbers);
        notDuplicatedLottoNumbers.addAll(userNumbers);

        return matcherNumbers.size() + userNumbers.size()
                - notDuplicatedLottoNumbers.size();
    }

    private boolean checkByBonus(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonus);
    }
}
