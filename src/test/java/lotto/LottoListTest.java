package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.LottoList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoListTest {

    @DisplayName("발행한 로또 수량이 맞는지 테스트")
    @Test
    void samelottocount() {
        LottoList lottoList = new LottoList(10000);
        assertThat(lottoList.getLOTTO_COUNT()).isEqualTo(10);
    }

    @DisplayName("발행한 로또 수량만큼 로또가 발급됬는지 테스트")
    @Test
    void lottolist() {
        LottoList lottoList = new LottoList(10000);
        assertThat(lottoList.getLOTTO_LIST().size()).isEqualTo(10);
    }


}
