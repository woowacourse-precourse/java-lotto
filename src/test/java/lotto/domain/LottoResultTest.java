package lotto.domain;

import static lotto.exception.ValidatorTest.WINNING_NUMBERS;
import static lotto.service.LottoServiceTest.BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("로또 번호가 6개 일치")
    @Test
    void test1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoResult result = getLottoResult(lotto);
        assertThat(result).isEqualTo(LottoResult.SIX);
    }


    @DisplayName("로또 번호가 5개 일치 및 보너스 번호 일치")
    @Test
    void test2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoResult result = getLottoResult(lotto);
        assertThat(result).isEqualTo(LottoResult.FIVE_WITH_BONUS);
    }

    @DisplayName("로또 번호가 5개 일치")
    @Test
    void test3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        LottoResult result = getLottoResult(lotto);
        assertThat(result).isEqualTo(LottoResult.FIVE);
    }

    @DisplayName("로또 번호가 4개 일치")
    @Test
    void test4() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 44, 45));
        LottoResult result = getLottoResult(lotto);
        assertThat(result).isEqualTo(LottoResult.FOUR);
    }

    @DisplayName("로또 번호가 3개 일치")
    @Test
    void test5() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        LottoResult result = getLottoResult(lotto);
        assertThat(result).isEqualTo(LottoResult.THREE);
    }

    @DisplayName("로또 번호가 2개 일치")
    @Test
    void test6() {
        Lotto lotto = new Lotto(List.of(1, 2, 42, 43, 44, 45));
        LottoResult result = getLottoResult(lotto);
        assertThat(result).isEqualTo(LottoResult.TWO);
    }


    @DisplayName("로또 번호가 1개 일치")
    @Test
    void test7() {
        Lotto lotto = new Lotto(List.of(1, 41, 42, 43, 44, 45));
        LottoResult result = getLottoResult(lotto);
        assertThat(result).isEqualTo(LottoResult.ONE);
    }


    @DisplayName("로또 번호가 0개 일치")
    @Test
    void test8() {
        Lotto lotto = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        LottoResult result = getLottoResult(lotto);
        assertThat(result).isEqualTo(LottoResult.ZERO);
    }

    @DisplayName("잘못된 당첨번호 일치 갯수를 제공하면 예외반환")
    @Test
    void test9() {
        assertThatThrownBy(() -> LottoResult.of(-1, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호 일치 갯수는 0~6개 입니다");
    }

    private LottoResult getLottoResult(Lotto lotto) {
        return LottoResult.of(lotto.getNumberOfMatchesByWinningNumbers(WINNING_NUMBERS),
                lotto.containBonusNumber(BONUS_NUMBER));
    }



}