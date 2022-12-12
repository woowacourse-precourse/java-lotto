package lotto.domain;

import lotto.utils.RandomNumbersGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    public LottoTicket generate(int quantity) {
        List<Lotto> lottos = IntStream.range(0, quantity)
                .mapToObj(i -> new Lotto(generateLottoNumbers()))
                .collect(Collectors.toList());
        return new LottoTicket(lottos);
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
