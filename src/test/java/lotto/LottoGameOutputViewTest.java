package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Lotto;
import domain.LottoGrade;
import dto.ScratchResult;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.LottoGameInputView;
import view.LottoGameOutputView;
import view.OutputView;

public class LottoGameOutputViewTest extends NsTest {

    private static OutputView lottoGameView;

    @BeforeAll
    private static void initialize() {
        lottoGameView = LottoGameOutputView.getInstance();
    }

    @Override
    protected void runMain() {

    }

    @Nested
    @DisplayName("printScratchResult 메서드는")
    class describe_printScratchResult {

        @Nested
        @DisplayName("ScratchResult 객체를 입력받아")
        class describe_its_parameter {

            @Test
            @DisplayName("정해진 형식에 따라 출력한다.")
            void return_number_when_receive_right_input() {
                Map<LottoGrade, Integer> lottoGradeIntegerMap = Map.of(LottoGrade.FIRST, 1, LottoGrade.SECOND, 2);
                long totalEarning = LottoGrade.FIRST.prize + LottoGrade.SECOND.prize * 2;
                double earningRate = 10;
                ScratchResult result = new ScratchResult(lottoGradeIntegerMap, totalEarning, earningRate);
                lottoGameView.printScratchResult(result);

                assertThat(output()).contains("당첨 통계", "---", "총 수익률은 10.0%입니다.", "6개 일치 (2,000,000,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개");
            }
        }
    }

    @Nested
    @DisplayName("printLottoPublishInfo 메서드는")
    class describe_printLottoPublishInfo {

        @Nested
        @DisplayName("로또 리스트 객체를 입력받아")
        class describe_its_parameter {

            @Test
            @DisplayName("각 로또의 숫자를 오름차순으로 출력한다.")
            void return_number_when_receive_right_input() {
                Lotto LottoA = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                Lotto LottoB = new Lotto(List.of(1, 2, 9, 4, 5, 6));
                Lotto LottoC = new Lotto(List.of(1, 2, 16, 4, 5, 6));

                List<Lotto> lottos = List.of(LottoA, LottoB, LottoC);
                lottoGameView.printLottoPublishInfo(lottos);
                assertThat(output()).contains("3개를 구매했습니다.", "[1, 2, 3, 4, 5, 6]", "[1, 2, 4, 5, 6, 9]",
                        "[1, 2, 4, 5, 6, 16]");
            }
        }
    }

    @Nested
    @DisplayName("printException 메서드는")
    class describe_printException {

        @Nested
        @DisplayName("예외 객체를 입력받아")
        class describe_its_parameter {

            @Test
            @DisplayName("[ERROR] 에러 메시지 형태로 출력한다")
            void return_number_when_receive_right_input() {
                lottoGameView.printException(new IllegalArgumentException("에러메시지"));
                assertThat(output()).contains("[ERROR] 에러메시지");
            }
        }
    }
}
