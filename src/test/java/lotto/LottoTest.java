package lotto;

import lotto.exception.LottoException;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("로또 번호의 범위인 1~45 사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 0, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByNotNumber(){
        assertThatThrownBy(() -> new LottoException().checkMoneyInput("1456dwas"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 천원 단위가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByNotThousand(){
        assertThatThrownBy(() -> new LottoException().checkMoneyInput("14500"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Nested
    class LottoWinningNumber {

        private Winner winner;

//        @BeforeEach
//        void setUp() {
//            winner = new Winner();
//        }

        @DisplayName("로또 당첨 번호의 형식을 벗어나면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,a,3,4,5","","1,02,01,3,4,5","1,2,3,4,5"})
        void createLottoWinningNumberByBadFormat(String situation) {
            assertThatThrownBy(() -> new Winner(situation))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 당첨 번호가 1~45 사이가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,0,3,4,5","1,46,2,3,4,5","1,2,3,4,5,500"})
        void createLottoWinningNumberByOverRange(String situation) {
            assertThatThrownBy(() -> new Winner(situation))
                    .isInstanceOf(IllegalArgumentException.class);
        }


        @DisplayName("로또 당첨 번호를 문자열 파싱을 통해 List 로 변환")
        @Test
        void changeLottoWinningNumberToList(){
            Winner winner = new Winner("11,45,2,13,24,35");
            List<Integer> lottoWinningNumber = winner.getLottoWinningNumber();
            assertThat(lottoWinningNumber).containsExactlyInAnyOrder(45,11,13,24,35,2);
        }
    }


}
