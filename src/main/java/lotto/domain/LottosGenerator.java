package lotto.domain;

import lotto.utils.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottosGenerator {
    private final List<Lotto> lottos;

    public LottosGenerator(LottoCount lottoCount) {
        this.lottos = generate(lottoCount.getCount());
    }

    private List<Lotto> generate(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = RandomNumbersGenerator.generate();
        sortNumbers(numbers);
        return numbers;
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
