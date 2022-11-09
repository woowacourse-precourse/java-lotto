package lotto;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Model {
    private final int LOTTO_NUMBERS = 6;

    public List<List<Integer>> repeatGetLottoNumber(int BONUS_NUMBER) {
        List<List<Integer>> uncheckedLottos = new ArrayList<>();

        for (int temp = 0; temp < BONUS_NUMBER; temp++) {
            uncheckedLottos.add(getLottoNumber());
        }

        return uncheckedLottos;
    }

    private List<Integer> getLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < LOTTO_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);

            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        return lottoNumbers;
    }

}
