package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateUserLottoNumbers {
    List<Lotto> userLottosNumber;

    public CreateUserLottoNumbers() {
        userLottosNumber = new ArrayList<>();
    }

    public List<Lotto> createUserLottoNumber() {
        List<Integer> sample = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(sample);
        userLottosNumber.add(new Lotto(sample));
        return userLottosNumber;
    }

}

