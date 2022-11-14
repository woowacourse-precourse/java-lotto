package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoUser {
    private long money;
    private LottoSystem lottoSystem;


    public LottoUser(long money, LottoSystem lottoSystem) {
        validate(money);
        this.money = money;
        this.lottoSystem = lottoSystem;

    }

    private void validate(long money){
        if(money < 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0이상이여야 합니다");
        }
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
    }

}
