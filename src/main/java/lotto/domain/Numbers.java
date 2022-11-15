package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.constant.LottoNumbers.*;

public class Numbers {
    private List<List<Integer>> lottoPublications;

    public Numbers() {
    }


    public List<List<Integer>> publishNumbers(int quantity) {
        lottoPublications = new ArrayList<>();

        for (int count = 0; count < quantity; count++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN.getNumber(), LOTTO_MAX.getNumber(), LOTTO_LENGTH.getNumber());
            lottoNumbers = sort(lottoNumbers);
            lottoPublications.add(lottoNumbers);
        }
        return lottoPublications;
    }

    private List<Integer> sort(List<Integer> lottoNumbers) {
        List<Integer> lottos = new ArrayList<>(lottoNumbers); //unmodifiableList -> 새로 객체 생성
        lottos.sort(Comparator.naturalOrder());

        return lottos;
    }

    public List<List<Integer>> getLottoPublications() {
        return lottoPublications;
    }
}
