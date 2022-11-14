package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.LottoGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGroupTest {

    @DisplayName("발행한 로또 수량이 맞는지 테스트")
    @Test
    void samelottocount() {
        LottoGroup lottoGroup = new LottoGroup(10000);
        assertThat(lottoGroup.getLOTTO_COUNT()).isEqualTo(10);
    }

    @DisplayName("발행한 로또 수량만큼 로또가 발급됬는지 테스트")
    @Test
    void lottolist() {
        LottoGroup lottoGroup = new LottoGroup(10000);
        assertThat(lottoGroup.getLOTTO_LIST().size()).isEqualTo(10);
    }


}
