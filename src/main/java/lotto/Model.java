package lotto;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class Model {
    private final int LOTTO_NUMBERS = 6;

    private void getLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < LOTTO_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);

            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
    }

}
