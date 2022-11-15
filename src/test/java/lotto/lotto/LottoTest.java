package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @Nested
    class BuyLottoTest {
        @DisplayName("10개의 로또를 구매하였을 때 정상적으로 10개의 복권을 구매한다.")
        @Test
        void buyLottoCountTest() {
            // given
            int buyCount = 10;
            int result = 10;

            // when
            List<Lotto> lottos = Lotto.buyLotto(buyCount);

            // then
            Assertions.assertThat(lottos.size())
                    .isEqualTo(result);
        }
    }

    @Nested
    class CreateLottoTest {
        @DisplayName("Lotto 생성 시 매개변수로 넘긴 번호를 받아온다")
        @Test
        void getNumbersTest() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            List<Integer> result = List.of(1, 2, 3, 4, 5, 6);

            // when
            List<Integer> numbers = lotto.getNumbers();

            // then
            Assertions.assertThat(numbers)
                    .containsAll(result);
        }

        @DisplayName("중복이 있거나 당첨번호를 6자리로 하지 않았을 경우 예외 발생")
        @Test
        void duplicationNumbersTest_exception() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

            // when & then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력한 보너스 번호가 당첨번호에 없다면 true를 반환한다")
        @Test
        void duplicationBonusNumberTest() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 7;
            boolean result = true;

            // when
            boolean checkBonus = lotto.duplicationBonusNumber(bonusNumber);

            // then
            Assertions.assertThat(checkBonus)
                    .isEqualTo(result);
        }


        @DisplayName("입력한 보너스 번호가 이미 당첨번호에 존재하면 예외 발생")
        @Test
        void duplicationBonusNumberTest_exception() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 6;

            // when & then
            assertThatThrownBy(() -> lotto.duplicationBonusNumber(bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class LottoNumberRangeTest {
        Lotto lotto;

        @BeforeEach
        void createNumbers() {
            lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }

        @AfterEach
        void clearNumbers() {
            lotto = null;
        }

        @DisplayName("입력한 로또 번호가 1~45의 값이 아니면 예외 발생1")
        @Test
        void validationNumberInRange_exception_1() {
            // given
            int checkNumber = 46;

            // when & then
            assertThatThrownBy(() -> lotto.validationNumberInRange(checkNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력한 로또 번호가 1~45의 값이 아니면 예외 발생2")
        @Test
        void validationNumberInRange_exception_2() {
            // given
            int checkNumber = -1;

            // when & then
            assertThatThrownBy(() -> lotto.validationNumberInRange(checkNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @DisplayName("입력한 로또 번호가 1~45의 값이 아니면 예외 발생3")
        @Test
        void validationNumberInRange_exception_3() {
            // given
            int checkNumber = 0;

            // when & then
            assertThatThrownBy(() -> lotto.validationNumberInRange(checkNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력한 로또 번호가 1~45의 값이라면 아무 일도 일어나지 않는다.")
        @Test
        void validationNumberInRange_1() {
            // given
            int checkNumber = 1;

            // when & then
            lotto.validationNumberInRange(checkNumber);
        }


    }
}
