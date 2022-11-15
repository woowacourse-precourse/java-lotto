package lotto;

import domain.Lotto;
import domain.LottoRank;
import domain.Player;
import lottoService.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
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
        assertThatThrownBy(() -> lottoService.isValidRange(lotto.getNumbers()))
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
        assertThatThrownBy(() -> lottoService.isNumber(testWinningLottoNumber))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoService.isNumber(testWinningLottoNumber2))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoService.isNumber(testWinningLottoNumber3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 로또번호와 당첨번호 비교")
    @Test
    void 사용자_로또번호_당첨번호_비교() {
        //given
        Player player = new Player();
        List<Integer> playerRandomLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto playerLotto = new Lotto(playerRandomLottoNumbers);
        List<Integer> lottoWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);

        //when
        lottoService.comparePlayerLottoNumberAndWinningLottoNumber(lottoWinningNumbers, playerLotto, player, 6);

        //then
        assertThat(player.getLottoCount()).isEqualTo(5);
        assertThat(player.getIsWinningLottoNumberBonusNumber()).isTrue();
    }

    @DisplayName("사용자의 로또 결과를 잘 저장하는지 확인")
    @Test
    void 사용자_로또_결과_저장_테스트() {
        //given
        Player player1 = new Player();
        for (int i = 0; i < 4; i++) {
            player1.addLottoCount();
        }

        Player player2 = new Player();
        for (int i = 0; i < 6; i++) {
            player2.addLottoCount();
        }
        player2.bonusNumberIncludedWinningLottoNumber();

        //when
        lottoService.saveLottoResult(player1);
        lottoService.saveLottoResult(player2);

        //then
        assertThat(player1.getWinningLottoCount().get(LottoRank.WIN_LOTTO_4)).isEqualTo(1);
        assertThat(player2.getWinningLottoCount().get(LottoRank.WIN_LOTTO_5_BONUS)).isEqualTo(1);
    }

    @DisplayName("수익률을 정상적으로 출력하는지 확인")
    @Test
    void 수익률_테스트() {
        //given
        Player player = new Player();
        player.setLottoPrice(100000);
        player.addLottoRevenue(65432);

        //when
        String yield = lottoService.calculatePlayerYield(player);

        //then
        assertThat(yield).isEqualTo("65.4");
    }


    // 아래에 추가 테스트 작성 가능
}
