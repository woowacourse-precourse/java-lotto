package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("6개의 번호를 갖는 로또가 발행됐는지 테스트")
    @Test
    void issueLottoSizeTest() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> numbers = lottoMachine.issueLotto();
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("발행된 로또에 중복이 있는지 테스트")
    @Test
    void issueLottoDuplicateTest() {
        LottoMachine lottoMachine = new LottoMachine();
        Set<Integer> numbers = new HashSet<>(lottoMachine.issueLotto());
        assertThat(numbers.size()).isEqualTo(6);
    }
}
