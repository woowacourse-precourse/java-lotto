package lotto;

import lotto.exception.LottoException;
import lotto.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

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

    @Nested
    class BonusTest{

        @DisplayName("보너스 번호가 숫자가 아닐 때 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"a","b","big","small"})
        void createBonusByNotNumber(String situation){
            assertThatThrownBy(() -> new Bonus(situation))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 번호가 1~45 사이가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"46","0","1234","200"})
        void createBonusByOverRange(String situation){
            assertThatThrownBy(() -> new Bonus(situation))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class JudgmentTest{

        private Judgment judgment;

        @BeforeEach
        void setUp(){
            judgment = new Judgment();
        }

        @DisplayName("로또 번호와 당첨 번호를 비교하고 몇 개가 같은지 알 수 있다.")
        @Test
        void 로또_번호_당첨_번호_비교_테스트(){
            int correctCount = judgment.correctCountLottoNumberAndWinnerNum(List.of(1, 2, 3, 4, 5, 6), List.of(2, 3, 12,43,45));
            assertThat(correctCount).isEqualTo(2);
        }

        @DisplayName("로또 번호와 보너스 번호를 비교")
        @Test
        void 로또_번호_보너스_번호_비교_테스트(){
            boolean found = judgment.isBonusNumberInLottoNumber(List.of(1, 2, 3, 4, 5, 6), 3);
            assertThat(found).isEqualTo(true);
        }
    }



}
