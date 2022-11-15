package lotto.model.lotto;

import lotto.model.customer.Customer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    void 로또번호_생성_검증() {
        //given
        //when
        Lotto lotto = LottoGenerator.generate();

        //then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);

    }
}