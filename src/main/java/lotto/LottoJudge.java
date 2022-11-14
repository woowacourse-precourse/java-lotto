package lotto;

import java.util.List;

public class LottoJudge {

    private final Lotto matcher;
    private final LottoNumber bonus;

    public LottoJudge(List<Integer> matcher, int bonus){
        validate(matcher, bonus);
        this.matcher = new Lotto(matcher);
        this.bonus = new LottoNumber(bonus);
    }

    private void validate(List<Integer> matcher, int bonus){
        if(matcher.contains(bonus))
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT
                    + InvalidInputMessage.ERR_DUPLICATED_NUMBER
            );
    }


}
