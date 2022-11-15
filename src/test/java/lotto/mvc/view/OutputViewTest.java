package lotto.mvc.view;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.common.CommonOutputTestSettings;
import lotto.domain.number.Lotto;
import lotto.domain.player.LottoPurchaseAmount;
import lotto.domain.player.Player;
import lotto.mvc.dto.output.OutputExceptionMessageDto;
import lotto.mvc.dto.output.OutputLottoStatisticsDto;
import lotto.mvc.dto.output.OutputPlayerInfoDto;
import lotto.mvc.model.LottoResult;
import lotto.mvc.model.LottoStore;
import lotto.util.number.LottoNumberFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OutputViewTest extends CommonOutputTestSettings {

    @Nested
    @DisplayName("renderPlayerLotto 메소드는")
    class RenderPlayerLottoMethodTest {

        @Test
        @DisplayName("만약 OutputPlayerInfoDto가 주어지면 DTO에 저장된 메세지를 출력한다.")
        void success_test() {
            LottoStore lottoStore = new LottoStore(new LottoPurchaseAmount("1000"));
            OutputPlayerInfoDto outputPlayerInfoDto = new OutputPlayerInfoDto(lottoStore);

            OutputView.renderPlayerLotto(outputPlayerInfoDto);

            assertThat(testOut.toString())
                    .contains("개를 구매했습니다.")
                    .contains("[")
                    .contains("]");
        }
    }

    @Nested
    @DisplayName("renderLottoStatistics 메소드는")
    class RenderLottoStatisticsMethodTest {

        @Test
        @DisplayName("만약 OutputLottoStatisticsDto가 주어지면 DTO에 저장된 메세지를 출력한다.")
        void success_test() {
            Player player = new Player(new LottoPurchaseAmount("1000"));
            Lotto winningLotto = new Lotto("1,2,3,4,5,6");
            LottoResult lottoResult = new LottoResult(player, winningLotto, LottoNumberFactory.numberOf(1));

            OutputView.renderLottoStatistics(new OutputLottoStatisticsDto(lottoResult));

            assertThat(testOut.toString())
                    .contains("당첨 통계").contains("---")
                    .contains("3개 일치 (5,000원) -").contains("4개 일치 (50,000원) -")
                    .contains("5개 일치 (1,500,000원) -")
                    .contains("5개 일치, 보너스 볼 일치 (30,000,000원) -")
                    .contains("6개 일치 (2,000,000,000원) -");
        }
    }

    @Nested
    @DisplayName("renderExceptionMessage 메소드는")
    class RenderExceptionMessageMethodTest {

        @Test
        @DisplayName("만약 OutputExceptionMessageDto가 주어지면 DTO에 저장된 메세지를 출력한다.")
        void success_test() {
            OutputView.renderExceptionMessage(new OutputExceptionMessageDto("[ERROR]"));

            assertThat(testOut.toString())
                    .contains("[ERROR]");
        }
    }
}