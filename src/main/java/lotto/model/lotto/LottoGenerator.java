package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    public Lotto generate(List<Integer> numbers) {
        List<Integer> numbersArrayList = new ArrayList<>(numbers);
        numbersArrayList.sort(Comparator.naturalOrder());

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(int number : numbersArrayList) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new Lotto(lottoNumbers);
    }

    public Lotto autoGenerate() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER, Lotto.LOTTO_NUMBER_LENGTH));
        return generate(numbers);
    }
}
