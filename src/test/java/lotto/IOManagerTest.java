package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class IOManagerTest extends NsTest {

    @Override
    protected void runMain() {

    }

    @Nested
    @DisplayName("getNumbersFromUser 메서드는")
    class describe_getNumbersFromUser {


        @Nested
        @DisplayName("사용자로부터 당첨 숫자 목록을 입력받는데")
        class describe_its_parameter {

            @Test
            @DisplayName("알맞은 입력인 경우 이를 리스트로 반환한다")
            void return_numberList_when_receive_right_input() {
                run("1,2,3,4,5");
                assertThat(IoManager.getWinningNumbersFromUser().equals(List.of(1, 2, 3, 4, 5)));

                run("1");
                assertThat(IoManager.getWinningNumbersFromUser().equals(List.of(1)));
            }

            @Test
            @DisplayName("잘못된 입력인 경우 예외를 발생시킨다")
            void throw_Exception_when_input_is_wrong() {
                Assertions.assertThatThrownBy(() -> {
                    run(",12");
                    IoManager.getWinningNumbersFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("");
                    IoManager.getWinningNumbersFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("3,2,");
                    IoManager.getWinningNumbersFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("1,2,a,");
                    IoManager.getWinningNumbersFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("1,,2");
                    IoManager.getWinningNumbersFromUser();
                }).isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("getBonusNumberFromUser 메서드는")
    class describe_getBonusNumberFromUser {

        @Nested
        @DisplayName("사용자로부터 숫자를 입력받는데")
        class describe_its_parameter {

            @Test
            @DisplayName("알맞은 입력인 경우 이를 Integer 형태로 반환한다.")
            void return_number_when_receive_right_input() {
                run("1");
                assertThat(IoManager.getBonusNumberFromUser()).isEqualTo(1);

                run("52");
                assertThat(IoManager.getBonusNumberFromUser()).isEqualTo(52);
            }

            @Test
            @DisplayName("잘못된 입력인 경우 예외를 발생시킨다")
            void throw_Exception_when_input_is_wrong() {
                Assertions.assertThatThrownBy(() -> {
                    run(",");
                    IoManager.getBonusNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("abc");
                    IoManager.getBonusNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("");
                    IoManager.getBonusNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("a");
                    IoManager.getBonusNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);

                Assertions.assertThatThrownBy(() -> {
                    run("1,,2");
                    IoManager.getBonusNumberFromUser();
                }).isInstanceOf(IllegalArgumentException.class);
            }
        }
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
                IoManager.printScratchResult(result);

                assertThat(output()).contains(
                        "당첨 통계",
                        "---",
                        "총 수익률은 10.0%입니다.",
                        "6개 일치 (2,000,000,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개"
                );
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
                IoManager.printLottoPublishInfo(lottos);
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
                IoManager.printException(new IllegalArgumentException("에러메시지"));
                assertThat(output()).contains("[ERROR] 에러메시지");
            }
        }
    }
}
