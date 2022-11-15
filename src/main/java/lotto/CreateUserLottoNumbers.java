package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateUserLottoNumbers {
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

