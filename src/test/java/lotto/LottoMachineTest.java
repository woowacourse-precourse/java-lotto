package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoMachineTest {

    @Test
    public void 로또_발행_오름차순_테스트(){
        LottoMachine lottoMachine = new LottoMachine();
        Lotto lotto = lottoMachine.createLotto();
        List<Integer> numbers = lotto.getNumbers();

        Assertions.assertThat(numbers.get(0))
                .isLessThan(numbers.get(1));
        Assertions.assertThat(numbers.get(4))
                .isLessThan(numbers.get(5));
    }
}