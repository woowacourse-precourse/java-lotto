package lotto.lotto;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator{

    @Override
    public List<Integer> generateLottoNumber() {
        return List.of(1,2,3,4,5,6);
    }
}
