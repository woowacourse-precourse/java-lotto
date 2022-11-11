package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.controller.LottoListController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoListControllerTest {

    @DisplayName("발행한 로또 수량이 맞는지 테스트")
    @Test
    void samelottocount() {
        LottoListController lottoListController = new LottoListController(10000);
        assertThat(lottoListController.getLOTTO_COUNT()).isEqualTo(10);
    }

    @DisplayName("발행한 로또 수량만큼 로또가 발급됬는지 테스트")
    @Test
    void lottolist() {
        LottoListController lottoListController = new LottoListController(10000);
        assertThat(lottoListController.getLOTTO_LIST().size()).isEqualTo(10);
    }


}
