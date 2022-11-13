package lotto.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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
    class ValidatePrice{

        @Nested
        @DisplayName("정상 입력")
        class ValidateInput{
            @Test
            @DisplayName("1,000원 입력 -> 1개 출력")
            void 천원_입력_1개_출력(){
                // given
                String input = "1000";
                // when
                setSetIn(input);
                int lottoCount =  userInput.getLottoCount();
                // then
                assertThat(lottoCount).isEqualTo(1);
            }

            @Test
            @DisplayName("10,000d원 입력 -> 10개 출력")
            void 만원_입력_10개_출력(){
                // given
                String input = "10000";
                // when
                setSetIn(input);
                int lottoCount =  userInput.getLottoCount();
                // then
                assertThat(lottoCount).isEqualTo(10);
            }

            @Test
            @DisplayName("160,000원 입력 -> 160개 출력")
            void 십육만원_입력_160개_출력(){
                // given
                String input = "160000";
                // when
                setSetIn(input);
                int lottoCount =  userInput.getLottoCount();
                // then
                assertThat(lottoCount).isEqualTo(160);
            }
        }

        @Nested
        @DisplayName("비정상 입력")
        class InValidateInput{
            @Test
            @DisplayName("1000원 단위가 아닌 입력은 예외 발생")
            void 천원_단위_검증(){
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
            void 음수_검증(){
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
    class ValidateWinningNumber{
        @Test
        @DisplayName("숫자가 아닌 값 입력은 예외 발생")
        void 숫자_아닌_입력(){
            // given
            String input = "1,2,3,a,b,c";
            // when
            setSetIn(input);
            // then
            assertThatThrownBy(() -> userInput.getWinningNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("범위에 벗어난 값 입력은 예외 발생")
        void 범위에_벗어난_입력(){
            // given
            String input = "1,48,-1,9,2,3";
            // when
            setSetIn(input);
            // then
            assertThatThrownBy(() -> userInput.getWinningNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복 숫자 있는 리스트는 예외 발생")
        void 중복_숫자_입력(){
            // given
            String input = "1,1,2,3,4,5";
            // when
            setSetIn(input);
            // then
            assertThatThrownBy(() -> userInput.getWinningNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("지정 개수의 숫자 아닌 경우 예외 발생")
        void 잘못된_개수의_숫자_입력(){
            // given
            String input = "1,2,3";
            // when
            setSetIn(input);
            // then
            assertThatThrownBy(() -> userInput.getWinningNumber())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}