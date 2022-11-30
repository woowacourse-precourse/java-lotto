package lotto.helper.stub;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.consts.LottoConst;
import lotto.utils.number.LottoNumbersGenerator;

public class StubNumbersGenerator implements LottoNumbersGenerator {

    @Override
    public List<Integer> generate(int size) {
        return IntStream.rangeClosed(LottoConst.MIN_NUMBER_VALUE, 6)
                .boxed()
                .collect(Collectors.toList());
    }
}
