package lotto.helper.stub;

import java.util.List;
import lotto.utils.number.LottoNumbersGenerator;

public class WrongNumbersGenerator implements LottoNumbersGenerator {

    @Override
    public List<Integer> generate(int size) {
        return List.of(0, 46);
    }
}
