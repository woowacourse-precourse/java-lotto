package lotto.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {

    UserInput userInput = new UserInput();

    private void setSetIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Nested
    @DisplayName("금액 입력 및 로또 개수 출력 로직 검증")
    class ValidatePrice {

        @Nested
        @DisplayName("정상 입력")
        class ValidateInput {
            @Test
            @DisplayName("1,000원 입력 -> 1개 출력")
            void 천원_입력_1개_출력() {
                // given
                String input = "1000";
                // when
                setSetIn(input);
                int lottoCount = userInput.getLottoCount();
                // then
                assertThat(lottoCount).isEqualTo(1);
            }

            @Test
            @DisplayName("10,000d원 입력 -> 10개 출력")
            void 만원_입력_10개_출력() {
                // given
                String input = "10000";
                // when
                setSetIn(input);
                int lottoCount = userInput.getLottoCount();
                // then
                assertThat(lottoCount).isEqualTo(10);
            }

            @Test
            @DisplayName("160,000원 입력 -> 160개 출력")
            void 십육만원_입력_160개_출력() {
                // given
                String input = "160000";
                // when
                setSetIn(input);
                int lottoCount = userInput.getLottoCount();
                // then
                assertThat(lottoCount).isEqualTo(160);
            }
        }

        @Nested
        @DisplayName("비정상 입력")
        class InValidateInput {
            @Test
            @DisplayName("1000원 단위가 아닌 입력은 예외 발생")
            void 천원_단위_검증() {
                // given
                String input = "1600";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() -> userInput.getLottoCount())
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("음수 입력은 예외 발생")
            void 음수_검증() {
                // given
                String input = "-10000";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() -> userInput.getLottoCount())
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("당첨 숫자 입력 로직 검증")
    class ValidateWinningNumber {

        @Nested
        @DisplayName("정상 입력")
        class Valid {

            @Test
            @DisplayName("1,2,3,4,5,6 입력 -> [1,2,3,4,5,6] 리스트 반환")
            void 정상_입력() {
                // given
                String input = "1,2,3,4,5,6";
                setSetIn(input);
                // when
                List<Integer> result = userInput.getWinningNumbersCandidate();
                // then
                assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
            }
        }

        @Nested
        @DisplayName("비정상 입력")
        class Invalid {
            @Test
            @DisplayName("영어 입력시 예외 발생")
            void 영어_입력() {
                // given
                String input = "1,2,3,a,b,c";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() -> userInput.getWinningNumbersCandidate())
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("한국어 입력시 예외 발생")
            void 한국어_입력() {
                // given
                String input = "1,2,3,ㄱ,가,나";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() -> userInput.getWinningNumbersCandidate())
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("기호 입력시 예외 발생")
            void 기호_입력() {
                // given
                String input = "1,2,3,+,-,*";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() -> userInput.getWinningNumbersCandidate())
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("보너스 숫자 입력 로직 검증")
    class Bonus {

        @Nested
        @DisplayName("정상 입력")
        class Valid {

            @Test
            @DisplayName("'1' 입력 -> 1 반환")
            void 정상_입력() {
                // given
                String input = "1";
                setSetIn(input);
                // then
                int result = userInput.getBonusNumber();
                //
                assertThat(result).isEqualTo(1);
            }
        }

        @Nested
        @DisplayName("비정상 입력")
        class Invalid {

            @Test
            @DisplayName("영어 입력시 예외 발생")
            void 영어_입력() {
                // given
                String input = "a";
                setSetIn(input);
                // when
                // then
                assertThatThrownBy(() -> userInput.getBonusNumber())
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("한국어 입력시 예외 발생")
            void 한국어_입력() {
                // given
                String input = "가";
                setSetIn(input);
                // when
                // then
                assertThatThrownBy(() -> userInput.getBonusNumber())
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("기호 입력시 예외 발생")
            void 기호_입력() {
                // given
                String input = "+";
                setSetIn(input);
                // when
                // then
                assertThatThrownBy(() -> userInput.getBonusNumber())
                        .isInstanceOf(IllegalArgumentException.class);
            }

        }
    }
}