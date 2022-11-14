package lotto.view;

import lotto.dto.ScoreInfo;
import lotto.vo.Lotto;
import lotto.vo.LottoBuyingInfo;
import lotto.vo.Profit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("OutputView 테스트")
class OutputViewTest {
    private final OutputView outputView = new OutputViewImpl();

    @Nested
    @DisplayName("예외 메시지를 일정한 포멧 메시지로 만들어 출력하는 printErrorMessage 테스트")
    class PrintErrorMessageTest {
        @Test
        @DisplayName("주어진 예외의 메시지를 뽑아 일정한 포맷으로 변환한 후 출력할 수 있다.")
        void givenException_whenPrintingErrorMessage_thenPrintsMessageInFormat() {
            //given
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            String givenExceptionMessage = "테스트 예외 메시지입니다.";
            IllegalArgumentException given = new IllegalArgumentException(givenExceptionMessage);

            //when
            outputView.printErrorMessage(given);

            //then
            assertThat(out.toString())
                    .isEqualTo(String.format(OutputViewImpl.ERROR_MESSAGE_FORMAT, givenExceptionMessage));
        }
    }

    @Nested
    @DisplayName("입력한 가격으로 발행한 로또 개수를 출력하는 printLottoBuyingInfo 테스트")
    class PrintLottoBuyingInfoTest {
        @Test
        @DisplayName("발행한 로또 개수를 메시지 포맷에 담아 출력할 수 있다.")
        void givenLottoAmount_whenPrintingLottoBuyingInfo_thenPrintsLottoAmountMessage() {
            //given
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            LottoBuyingInfo lottoBuyingInfo = new LottoBuyingInfo("10000");

            //when
            outputView.printLottoBuyingInfo(lottoBuyingInfo);

            //then
            assertThat(out.toString())
                    .isEqualTo(String.format(OutputViewImpl.BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT, 10));
        }
    }

    @Nested
    @DisplayName("발행한 로또 번호를 전부 출력하는 printLottos 테스트")
    class PrintLottosTest {
        @Test
        @DisplayName("요청한 로또 개수 수만큼 발행한 로또 번호를 출력할 수 있다.")
        void givenLottoList_whenPrintingLottos_thenPrintsLottosMessage() {
            //given
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            List<Lotto> lottos = Arrays.asList(
                    new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                    new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                    new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                    new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42))
            );

            //when
            outputView.printLottos(lottos);

            //then
            assertThat(out.toString())
                    .isEqualTo(
                            "[8, 21, 23, 41, 42, 43]\n" +
                                    "[3, 5, 11, 16, 32, 38]\n" +
                                    "[7, 11, 16, 35, 36, 44]\n" +
                                    "[1, 8, 11, 31, 41, 42]\n\n"
                    );
        }
    }

    @Nested
    @DisplayName("당첨 등수별로 당첨 개수를 출력하는 printScoreMessage 테스트")
    class PrintScoreMessageTest {
        @Test
        @DisplayName("주어진 당첨 점보를 바탕으로 당첨 내역 메시지를 출력한다.")
        void givenScoreInfo_whenPrintingScoreMessage_thenPrintsScoreMessage() {
            // given
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            ScoreInfo scoreInfo = new ScoreInfo();

            // when
            outputView.printScoreMessage(scoreInfo);

            // then
            assertThat(out.toString())
                    .isEqualTo("당첨 통계\n" +
                            "---\n" +
                            "3개 일치 (5,000원) - 0개\n" +
                            "4개 일치 (50,000원) - 0개\n" +
                            "5개 일치 (1,500,000원) - 0개\n" +
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                            "6개 일치 (2,000,000,000원) - 0개\n"
                    );
        }
    }

    @Nested
    @DisplayName("수익률을 백분율로 출력하는 printProfitPercentageMessage 테스트")
    class PrintProfitPercentageMessageTest {
        @Test
        @DisplayName("수익률 값이 주어지면 수익률 메시지를 출력한다.")
        void givenProfitPercentage_whenPrintingProfitPercentageMessage_thenPrintsProfitMessage() {
            //given
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            Profit profit = new Profit(0.625)
                    .convertToPercentage()
                    .roundToFirstDigit();

            //when
            outputView.printProfitPercentageMessage(profit);

            //then
            assertThat(out.toString())
                    .isEqualTo(String.format(OutputViewImpl.PROFIT_MESSAGE_FORMAT, profit));
        }
    }
}