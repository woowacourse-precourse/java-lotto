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

        if (matcherCount == 6) {
            return LottoPlace.MATCHED_6;
        }
        if (matcherCount == 5) {
            if (isContainBonus) {
                return LottoPlace.MATCHED_5_WITH_BONUS;
            }
            return LottoPlace.MATCHED_5;
        }
        if (matcherCount == 4) {
            return LottoPlace.MATCHED_4;
        }
        if (matcherCount == 3) {
            return LottoPlace.MATCHED_3;
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
