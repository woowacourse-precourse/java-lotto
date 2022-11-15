package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("로또 금액을 입력하면 개수가 리턴된다.")
    @Test
    void getLottoAmountByCost() {
        Game game = new Game();

        assertThat(game.getLottoAmount("15000")).isEqualTo(15);
    }

    @DisplayName("로또 금액이 천원 단위인지 확인한다.")
    @Test
    void isInputMultiThousands() {
        Game game = new Game();
        /*
        assertThat(game.validateMultiThousands("1111")).isEqualTo(false);
        assertThat(game.validateMultiThousands("12")).isEqualTo(false);
        assertThat(game.validateMultiThousands("9000")).isEqualTo(true);
         */
    }

    @DisplayName("로또 일반 번호 맞춘 개수를 확인한다.")
    @Test
    void getCorrectNormalNum() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.getNormalSameNum(List.of(6, 5, 4, 3, 2, 1)))
                .isEqualTo(6);
        assertThat(lotto.getNormalSameNum(List.of(9, 10, 11, 12, 13, 14)))
                .isEqualTo(0);
        assertThat(lotto.getNormalSameNum(List.of(26, 13, 14, 33, 2, 1)))
                .isEqualTo(2);
    }

    @DisplayName("로또 일반 번호 맞춘 개수와 보너스 번호 맞춘 여부로 등수 확인")
    @Test
    void getRankTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.getRank(2, true))
                .isEqualTo(Rank.NONE);
        assertThat(lotto.getRank(5, true))
                .isEqualTo(Rank.SECOND);
        assertThat(lotto.getRank(5, false))
                .isEqualTo(Rank.THIRD);
        assertThat(lotto.getRank(6, false))
                .isEqualTo(Rank.FIRST);
    }

    @DisplayName("수익률을 소수점 두째자리 까지 반올림하여 출력하는지 확인")
    @Test
    void getYieldTest() {
        Game game = new Game();

        assertThat(game.getYield(8000, 5000)).isEqualTo(62.5);
        assertThat(game.getYield(20000, 0)).isEqualTo(0);
        assertThat(game.getYield(3000, 200000000)).isEqualTo(6666666.7);
    }
}
