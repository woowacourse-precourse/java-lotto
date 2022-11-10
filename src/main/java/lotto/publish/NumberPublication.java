package lotto.publish;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoNumbers.*;

public class NumberPublication {
    private List<List<Integer>> lottoPublications;

    public NumberPublication() {
    }

    public List<List<Integer>> publishNumbers(int quantity) {
        lottoPublications = new ArrayList<>();
        for(int count = 0; count < quantity; count++) {
            List<Integer> lottoNumbers = generateLotto();
            lottoPublications.add(lottoNumbers);
        }
        return lottoPublications;
    }

    public List<Integer> generateLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while(lottoNumbers.size() != LOTTO_LENGTH.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(LOTTO_MIN.getNumber(), LOTTO_MAX.getNumber());
            if(!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        return lottoNumbers;
    }

    public List<List<Integer>> getLottoPublications() {
        return lottoPublications;
    }
}
