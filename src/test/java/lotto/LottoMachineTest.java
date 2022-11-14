package lotto;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {

    @Test
    void 금액_비정상_입력_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        List<String> inputs = Arrays.asList("1100", "12300", "300", "abcd");

        for (String input: inputs) {
            assertThatThrownBy(() -> lottoMachine.validateMoney(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 금액_정상_입력_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        List<String> inputs = Arrays.asList("1000", "12000", "3000", "14000");

        for (String input: inputs) {
            assertThatNoException()
                    .isThrownBy(() -> lottoMachine.validateMoney(input));
        }
    }

    @Test
    void 로또_개수_정상_테스트() {
        LottoMachine lottoMachine = new LottoMachine();
        List<String> inputs = Arrays.asList("1000", "62000", "7000");
        List<Integer> rightAnswers = Arrays.asList(1, 62, 7);

        for (int i = 0; i < inputs.size(); i++) {
            assertThat(lottoMachine.getLottoCount(inputs.get(i)))
                    .isEqualTo(rightAnswers.get(i));
        }
    }

}
