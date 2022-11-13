package lotto.mainframe;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerate {

    private Lotto lotto;

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void generateLotto(int lottoAmount) {
        List<Integer> lottoNumbers;
        for (int i = 0; i < lottoAmount; i++) {
            lottoNumbers = generateLottoNumbers();
            lottoNumbers.sort(Comparator.naturalOrder());
            lotto = new Lotto(lottoNumbers);
            lotto.addLotto();
        }
    }
}
