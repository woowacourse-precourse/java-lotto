package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.controller.LottoListController;
import lotto.controller.LottoSameCountController;
import lotto.controller.UserNumbersController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSameCountControllerTest {

    @DisplayName("당첨 개수를 정확히 계산하는지 테스트")
    @Test
    void lottosamecountcontrollertest() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                LottoListController lottoListController = new LottoListController(3000);
                UserNumbersController userNumbersController = new UserNumbersController("1,3,4,6,2,5",
                    "7");
                LottoSameCountController lottoSameCountController = new LottoSameCountController(
                    lottoListController, userNumbersController);
                assertThat(userNumbersController.getNUMBERS().getNumbers()).isEqualTo(
                    List.of(1, 2, 3, 4, 5, 6));
                assertThat(lottoSameCountController.getRANK_COUNT_LIST().get(0)).isEqualTo(0);
                assertThat(lottoSameCountController.getRANK_COUNT_LIST().get(1)).isEqualTo(1);
                assertThat(lottoSameCountController.getRANK_COUNT_LIST().get(2)).isEqualTo(0);
                assertThat(lottoSameCountController.getRANK_COUNT_LIST().get(3)).isEqualTo(1);
                assertThat(lottoSameCountController.getRANK_COUNT_LIST().get(4)).isEqualTo(1);

            }, List.of(1, 5, 2, 3, 4, 7),
            List.of(3, 5, 1, 16, 32, 38),
            List.of(3, 5, 1, 16, 4, 38)
        );
    }

}
