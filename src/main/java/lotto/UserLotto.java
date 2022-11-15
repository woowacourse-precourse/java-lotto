package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class UserLotto extends Lotto {
    public UserLotto() {
        super(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, MAX_SIZE));
    }


}
