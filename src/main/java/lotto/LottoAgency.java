package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoAgency {

    private NumberGenerator numberGenerator;
    private int amount;

    public LottoAgency(int amount, NumberGenerator numberGenerator) {
        this.amount = amount;
        this.numberGenerator = numberGenerator;
    }

    public List<List<Integer>> issue() {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int lottoIndex = 0; lottoIndex < amount; lottoIndex++) {
            lottos.add(generateNumbers());
        }

        return lottos;
    }

    private List<Integer> generateNumbers() {
        List<Integer> generated = numberGenerator.generate();
        if (isDuplicated(generated)) {
            this.numberGenerator = new NumberGeneratorRandom();
            return generateNumbers();
        }
        return generated;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
}
