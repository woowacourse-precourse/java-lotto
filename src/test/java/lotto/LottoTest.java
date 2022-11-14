package lotto;

import domain.Lotto;
import domain.Player;
import lottoService.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    LottoService lottoService = new LottoService();

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

    @DisplayName("사용자가 입력한 로또 구입 금액이 1000원 단위로 나누어 떨어지지 않을경우 예외가 발생한다.")
    @Test
    void 로또금액_1000원으로_나누어떨어지는지_테스트() {
        //given
        Player player = new Player();

        //when
        player.setLottoPrice(9500);

        //then
        assertThatThrownBy(() -> player.canDivideThousand())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위는 1~45여야만 한다.")
    @Test
    void 로또번호_범위_테스트() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 60);
        Lotto lotto = new Lotto(numbers);

        //then
        assertThatThrownBy(() ->  lottoService.isValidRange(lotto.getNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호는 숫자여야만 한다.")
    @Test
    void 로또번호_숫자_테스트() {
        //given
        String testWinningLottoNumber = "1,2,3,ㄱ,5,6";
        String testWinningLottoNumber2 = "#,!,$,4,5,6";
        String testWinningLottoNumber3 = "rk,2,3,4,5,6";

        //then
        assertThatThrownBy(() ->  lottoService.isNumber(testWinningLottoNumber))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->  lottoService.isNumber(testWinningLottoNumber2))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->  lottoService.isNumber(testWinningLottoNumber3))
                .isInstanceOf(IllegalArgumentException.class);
    }



    // 아래에 추가 테스트 작성 가능
}
