package lotto;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinLotto;
import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("예외 테스트")
    @Nested
    class ExceptionTest {
        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_COUNT.getValue());
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.HAVE_DUPLICATED_NUMBER.getValue());
        }

        @DisplayName("로또 번호가 1~45 이내의 숫자가 아니면 예외가 발생한다.")
        @Test
        void createLottoByOverNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 30, 40, 42, 46)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBER.getValue());
        }

        @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
        @Test
        void createBonusNumber() {
            assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 6), 3))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_BONUS_NUMBER.getValue());
        }
    }


    @DisplayName("로또 생성 테스트")
    @Nested
    class CreateLottoTest {
        @DisplayName("자동으로 로또 번호를 생성한다.")
        @RepeatedTest(10)
        void createLotto() {
            Lotto generatedLotto = Lotto.create();
            List<Integer> numbers = generatedLotto.getNumbers();
            assertThat(numbers.size()).isEqualTo(6);
            for (Integer number : numbers) {
                assertThat(number).isGreaterThan(0).isLessThan(46);
            }
            assertThat(new HashSet<>(numbers).size()).isEqualTo(numbers.size());
        }

        @DisplayName("자동으로 생성된 로또 번호를 형식에 맞게 출력한다.")
        @RepeatedTest(10)
        void createLottoAndPrintNumbers() {
            Lotto generatedLotto = Lotto.create();
            String printResult = generatedLotto.printNumbers();

            assertThat(printResult.startsWith("[")).isTrue();
            assertThat(printResult.endsWith("]")).isTrue();

            String[] split = printResult.split(", ");
            assertThat(split.length).isEqualTo(6);
        }
    }


    @DisplayName("하나의 로또 번호에 대한 당첨 내역 테스트")
    @Nested
    class getSingleResult {
        WinLotto winLotto;
        @BeforeEach
        void init() {
            winLotto  = new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        }

        @DisplayName("6개 일치")
        @Test
        void match6() {
            Lotto generatedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Result result = winLotto.getResult(generatedLotto);
            assertThat(result).isEqualTo(new Result(6, false));
            assertThat(result).isEqualTo(new Result(6, true));

            assertThat(result.getResultStatus().getValue()).isEqualTo(2000000000);
        }

        @DisplayName("5개 일치 & 보너스볼 일치")
        @Test
        void match5AndMatchBonusBall() {
            Lotto generatedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            Result result = winLotto.getResult(generatedLotto);
            assertThat(result).isEqualTo(new Result(5, true));

            assertThat(result.getResultStatus().isHasBonusBall()).isTrue();
            assertThat(result.getResultStatus().getValue()).isEqualTo(30000000);
        }

        @DisplayName("5개 일치")
        @Test
        void match5() {
            Lotto generatedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
            Result result = winLotto.getResult(generatedLotto);
            assertThat(result).isEqualTo(new Result(5, false));

            assertThat(result.getResultStatus().isHasBonusBall()).isFalse();
            assertThat(result.getResultStatus().getValue()).isEqualTo(1500000);
        }

        @DisplayName("4개 일치")
        @Test
        void match4() {
            Lotto generatedLotto = new Lotto(List.of(1, 2, 3, 4, 40, 41));
            Result result = winLotto.getResult(generatedLotto);
            assertThat(result).isEqualTo(new Result(4, true));
            assertThat(result).isEqualTo(new Result(4, false));

            assertThat(result.getResultStatus().getValue()).isEqualTo(50000);
        }

        @DisplayName("3개 일치")
        @Test
        void match3() {
            Lotto generatedLotto = new Lotto(List.of(1, 2, 3, 40, 41, 45));
            Result result = winLotto.getResult(generatedLotto);
            assertThat(result).isEqualTo(new Result(3, true));
            assertThat(result).isEqualTo(new Result(3, false));

            assertThat(result.getResultStatus().getValue()).isEqualTo(5000);
        }

        @DisplayName("0~2개 일치")
        @Test
        void matchNone() {
            Lotto generatedLotto0 = new Lotto(List.of(8, 9, 10, 11, 12, 13));
            Lotto generatedLotto1 = new Lotto(List.of(1, 9, 10, 11, 12, 13));
            Lotto generatedLotto2 = new Lotto(List.of(1, 2, 10, 11, 12, 13));

            Result result0 = winLotto.getResult(generatedLotto0);
            Result result1 = winLotto.getResult(generatedLotto1);
            Result result2 = winLotto.getResult(generatedLotto2);

            assertThat(result0).isEqualTo(new Result(0, false));
            assertThat(result1).isEqualTo(new Result(1, false));
            assertThat(result2).isEqualTo(new Result(2, false));

            assertThat(result0.getResultStatus().getValue()).isEqualTo(0);
            assertThat(result1.getResultStatus().getValue()).isEqualTo(0);
            assertThat(result2.getResultStatus().getValue()).isEqualTo(0);
        }
    }

}
