package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.view.LottoManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LottoManager 클래스")
@Nested
class LottoManagerTest {
    @DisplayName("readPurchaseAmount 메소드는")
    @Nested
    class Describe_readPurchaseAmount {
        @DisplayName("조건에 맞는 금액을 입력받는다면")
        @Nested
        class Context_with_Normal_Purchase_Amount {
            @DisplayName("구매 로또 개수를 저장하고 구매 완료 메시지 출력 메서드를 호출한다.")
            @Test
            void readPurchaseAmountTest() {
                assertSimpleTest(
                        () -> {
                            LottoManager lottoManager = new LottoManager();
                            System.setIn(new ByteArrayInputStream("8000".getBytes()));
                            OutputStream out = new ByteArrayOutputStream();
                            System.setOut(new PrintStream(out));
                            lottoManager.readPurchaseAmount();

                            assertThat(out.toString()).contains(
                                    "8개를 구매했습니다."
                            );
                        }
                );
            }
        }

        @DisplayName("입력 금액이 숫자로 구성되지 않는다면")
        @Nested
        class Context_with_Abnormal_Input_Pattern {
            @DisplayName("IllegalArgumentException을 발생시킨다.")
            @Test
            void validatePurchaseInputTest() {
                LottoManager lottoManager = new LottoManager();
                System.setIn(new ByteArrayInputStream("72,000".getBytes()));
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                assertThatThrownBy(() -> lottoManager.readPurchaseAmount())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]");
            }
        }

        @DisplayName("입력 금액이 1000원으로 나누어 떨어지지 않는다면")
        @Nested
        class Context_with_Abnormal_Input_Unit {
            @DisplayName("IllegalArgumentException을 발생시킨다.")
            @Test
            void validatePurchaseUnitTest() {
                LottoManager lottoManager = new LottoManager();
                System.setIn(new ByteArrayInputStream("72321".getBytes()));
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                assertThatThrownBy(() -> lottoManager.readPurchaseAmount())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]");
            }
        }

    }

    @DisplayName("readWinningNumbers 메소드는")
    @Nested
    class Describe_readWinningNumbers {
        @DisplayName("조건에 맞는 당첨 번호를 입력 받았다면")
        @Nested
        class Context_with_Normal_Winning_Numbers {
            @DisplayName("당첨 번호 배열에 입력 받은 배열을 업데이트한다.")
            @Test
            void readWinningNumbersTest() {
                assertSimpleTest(
                        () -> {
                            String actualInput = "1,2,3,4,5,6";
                            LottoManager lottoManager = new LottoManager();
                            System.setIn(new ByteArrayInputStream(actualInput.getBytes()));
                            lottoManager.readWinningNumbers();
                            assertThat(lottoManager.getWinningNumbers())
                                    .containsExactly(1, 2, 3, 4, 5, 6
                                    );
                        }
                );
            }
        }

        @DisplayName("콤마(,)로 구분된 6개의 숫자의 입력이 아니라면")
        @Nested
        class Context_with_Abnormal_Winning_Numbers_Pattern {
            @DisplayName("IllegalArgumentException을 발생시킨다.")
            @Test
            void validateWinningInputTest() {
                LottoManager lottoManager = new LottoManager();
                System.setIn(new ByteArrayInputStream("1,2,3,4,5,6,".getBytes()));
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                assertThatThrownBy(() -> lottoManager.readWinningNumbers())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]");
            }
        }

        @DisplayName("당첨 번호가 숫자 1~45 범위가 아닌 경우")
        @Nested
        class Context_with_Abnormal_Winning_Numbers_Range {
            @DisplayName("IllegalArgumentException을 발생시킨다.")
            @Test
            void validateEachNumberTest() {
                LottoManager lottoManager = new LottoManager();
                System.setIn(new ByteArrayInputStream("46,2,3,4,5,6".getBytes()));
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                assertThatThrownBy(() -> lottoManager.readWinningNumbers())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]");
            }
        }

        @DisplayName("당첨 번호 간 중복이 있는 경우")
        @Nested
        class Context_with_Abnormal_Winning_Numbers_Repetition {
            @DisplayName("IllegalArgumentException을 발생시킨다.")
            @Test
            void validateRepetitionTest() {
                LottoManager lottoManager = new LottoManager();
                System.setIn(new ByteArrayInputStream("1,2,1,4,5,6".getBytes()));
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                assertThatThrownBy(() -> lottoManager.readWinningNumbers())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]");
            }
        }
    }

    @DisplayName("readBonusNumbers 메소드는")
    @Nested
    class Describe_readBonusNumbers {
        @DisplayName("조건에 맞는 보너스 번호를 입력받아")
        @Nested
        class Context_with_Normal_Bonus_Number {
            @DisplayName("당첨 번호 배열에 보너스 번호를 업데이트한다.")
            @Test
            void readBonusNumbersTest() {
                assertSimpleTest(
                        () -> {
                            String actualInput = "42";
                            LottoManager lottoManager = new LottoManager();
                            System.setIn(new ByteArrayInputStream(actualInput.getBytes()));
                            lottoManager.readBonusNumber();

                            assertThat(lottoManager.getWinningNumbers())
                                    .contains(42
                                    );
                        }
                );
            }
        }

    }
}

