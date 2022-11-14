package lotto;

import java.util.List;

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

        if(matcherCount == 6)
            return LottoPlace.MATCHED_6;
        if(matcherCount == 5) {
            if(isContainBonus)
                return LottoPlace.MATCHED_5_WITH_BONUS;
            return LottoPlace.MATCHED_5;
        }
        if(matcherCount == 4)
            return LottoPlace.MATCHED_4;
        if(matcherCount == 3)
            return LottoPlace.MATCHED_3;
        return LottoPlace.NONE;
    }

    private int countByMatcher(Lotto userLotto) {
        int count = 0;
        List<LottoNumber> matcherLotto = matcher.getNumbers();
        for (LottoNumber number : userLotto.getNumbers()) {
            if (matcherLotto.contains(number)) {
                ++count;
            }
        }
        return count;
    }

    private boolean checkByBonus(Lotto userLotto) {
        for (LottoNumber number : userLotto.getNumbers()) {
            if (bonus.equals(number)) {
                return true;
            }
        }
        return false;
    }
}
