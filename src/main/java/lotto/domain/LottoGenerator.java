package lotto.domain;

import lotto.utils.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final LottoQuantity lottoQuantity;

    public LottoGenerator(LottoQuantity lottoQuantity) {
        this.lottoQuantity = lottoQuantity;
    }

    public Lottos generate() {
        List<Lotto> lottos = new ArrayList<>();
        int quantity = lottoQuantity.getCount();
        for(int i = 0; i < quantity; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = RandomNumbersGenerator.generate();
        return sortNumbers(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
             .sorted(Comparator.comparing(Integer::intValue))
             .collect(Collectors.toList());
    }
}
