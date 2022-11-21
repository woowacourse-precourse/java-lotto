package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;



public class BonusLotto {
    private final int bonusNum;
    public BonusLotto(int bonusNum,Lotto lotto) {
        validate(bonusNum,lotto);
        this.bonusNum = bonusNum;
    }
    private void validate(int bonusNum,Lotto lotto) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException();
        }
        //보너스번호가 기존 번호랑 겹치면 안되는 검증 추가해야함
        if (lotto.getNumbers().contains(bonusNum)) {
            throw new IllegalArgumentException("당첨 숫자의 중복됐습니다.");
        }
    }
    public int getBonusNum() {
        return bonusNum;
    }

}
