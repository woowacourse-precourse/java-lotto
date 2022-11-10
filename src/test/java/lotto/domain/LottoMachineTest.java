package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("6개의 번호를 갖는 로또가 발행됐는지 테스트")
    @Test
    void issueLottoTest() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> numbers = lottoMachine.issueLotto();
        assertThat(numbers.size()).isEqualTo(6);
    }
}
