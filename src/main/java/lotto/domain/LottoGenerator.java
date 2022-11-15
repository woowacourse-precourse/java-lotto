package lotto.domain;

import lotto.utils.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public LottoGenerator(LottoQuantity lottoCount) {
        generate(lottoCount.getCount());
    }

    private Lottos generate(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = RandomNumbersGenerator.generate();
        sortNumbers(numbers);
        return numbers;
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
