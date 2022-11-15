package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateUserLottoNumbers {
인
    public static final String DO_NOT_PERMIT_SAME_LOTTONUMBERS = "구매한 로또번호가 하나 이상 완전히 같은 수 없습니다.";
    List<Lotto> userBuyLottosGroup;

    public CreateUserLottoNumbers() {
        userBuyLottosGroup = new ArrayList<>();
    }

    public List<Lotto> createUserLottoNumber(int amount) {
        for(int i = 0; i<amount; i++){
            List<Integer> sample = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            userBuyLottosGroup.add(new Lotto(sample));
        }
        return userBuyLottosGroup;
    }

}

