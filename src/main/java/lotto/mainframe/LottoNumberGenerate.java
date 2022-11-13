package lotto.mainframe;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerate {

    private Lotto lotto;

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void generateLotto(int lottoAmount) {
        List<Integer> lottoNumbers;
        for (int i = 0; i < lottoAmount; i++) {
            lottoNumbers = generateLottoNumbers();
            List<Integer> orderedList = lottoNumbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
            lotto = new Lotto(orderedList);
            lotto.addLotto();
        }
    }
}
