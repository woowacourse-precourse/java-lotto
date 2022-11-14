package lotto.system;

import lotto.mock.MockLottoApplication;
import lotto.mock.MockLottoController;
import lotto.view.OutputViewImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoApplication 테스트")
class LottoApplicationTest {
    @Nested
    @DisplayName("주요 애플리케이션 구동을 담당하는 run 메소드 테스트")
    class runTest {
        @Test
        @DisplayName("run 메소드 실행 중 사용자 입력으로 인한 예외가 발생하면 적절한 포맷의 에러 메시지를 출력한다.")
        void givenLottoApplication_thenRunningControllerCausingException_thenPrintsFormattedMessage() {
            //given
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            LottoApplication lottoApplication = new MockLottoApplication();

            //when
            lottoApplication.run();

            //then
            assertThat(out.toString()).isEqualTo(String.format(OutputViewImpl.ERROR_MESSAGE_FORMAT, MockLottoController.MOCK_EXCEPTION_MESSAGE));
        }
    }
}