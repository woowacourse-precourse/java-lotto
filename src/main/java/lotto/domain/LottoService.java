package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LottoService {



    public List<Lotto> generateLottoList(int numberOfLotto) {

        List<Lotto> lottoList = new LinkedList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = generateLotto();
            lottoList.add(lotto);
        }

        return lottoList;
    }

    public Lotto generateLotto() {

        List<Integer> lottoNumbers = generateLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);

        return lotto;
    }

    public List<Integer> generateLottoNumbers() {

        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedLottoNumbers = sortedLottoNumbers(lottoNumbers);

        return sortedLottoNumbers;
    }

    public List<Integer> sortedLottoNumbers(List<Integer> lottoNumbers) {

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
