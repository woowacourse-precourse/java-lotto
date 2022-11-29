package lotto.utils.number;

import java.util.List;

@FunctionalInterface
public interface LottoNumbersGenerator {

    List<Integer> generate(int size);
}
