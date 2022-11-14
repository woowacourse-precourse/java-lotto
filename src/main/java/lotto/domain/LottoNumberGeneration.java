package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGeneration {

    private Lotto lotto;

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void generateLotto(int lottoAmount) {
        List<Integer> lottoNumbers;
        for (int lottoCount = 0; lottoCount < lottoAmount; lottoCount++) {
            lottoNumbers = generateLottoNumbers();
            List<Integer> orderedList = lottoNumbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
            lotto = new Lotto(orderedList);
            lotto.addLotto();
        }
    }
}
