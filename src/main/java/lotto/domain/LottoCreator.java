package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCreator {

    private static final int LOTTO_SIZE = 6;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    public static List<Lotto> saveLotto(final int lottoQuantity) {
        List<Lotto> lottoContainer = new ArrayList<>();
        for (int currentSize = 0; currentSize < lottoQuantity; ++currentSize) {
            lottoContainer.add(createLotto());
        }
        return lottoContainer;
    }

    private static Lotto createLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_SIZE));

        List<Integer> sortedNumbers = sortLottoNumbers(lottoNumbers);
        return new Lotto(sortedNumbers);
    }

    private static List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        for(int index = 0; index < lottoNumbers.size(); index++) {
            for(int anotherIndex = index + 1; anotherIndex < lottoNumbers.size(); ++anotherIndex) {
                sortTwoNumbers(lottoNumbers, index, anotherIndex);
            }
        }
        return lottoNumbers;
    }

    private static void sortTwoNumbers(List<Integer> lottoNumbers, int index, int anotherIndex) {
        if(lottoNumbers.get(index) > lottoNumbers.get(anotherIndex)) {
            Integer temp = lottoNumbers.get(index);
            lottoNumbers.set(index, lottoNumbers.get(anotherIndex));
            lottoNumbers.set(anotherIndex, temp);
        }
    }
}
