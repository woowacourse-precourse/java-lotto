package lotto.domain;

import lotto.dto.WinningLottoNumberDto;
import lotto.dto.WinningNumberCountDto;
import lotto.exception.PayMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @Test
    @DisplayName("금액에 대한 수량 계산 테스트")
    void moneyOfQuantity() {
        // given
        int pay = 8000;
        int expectedQuantity = 8;

        // when
        int quantity = Lotto.moneyOfQuantity(pay);

        // then
        assertThat(quantity).isEqualTo(expectedQuantity);
    }

    @Test
    @DisplayName("유효하지 않은 금액이 들어와 PayMoneyException 발생")
    void moneyOfQuantity_throw_PayMoneyException() {
        // given
        int pay = 8001;

        // when && then
        assertThatThrownBy(() -> Lotto.moneyOfQuantity(pay))
                .isInstanceOf(PayMoneyException.class);
    }

    @Test
    @DisplayName("수량에 대한 로또 생성 기능 테스트")
    void createLottoNumbers() {
        // given
        int quantity = 8;
        int expectedSize = 8;

        // when
        List<Lotto> lottos = Lotto.createLottoNumbers(quantity);

        // then
        assertAll(
                () -> assertThat(lottos.size()).isEqualTo(expectedSize),
                () -> assertThat(lottos).allMatch(lotto -> lotto.getNumbers().size() == 6),
                () -> assertThat(lottos.stream()
                        .allMatch(lotto -> lotto.getNumbers().stream()
                                .allMatch(number -> number >= 1 && number <= 45)))
                        .isTrue()
        );
    }

    @Test
    @DisplayName("구매한 로또 번호와 당첨 로또 번호를 비교하여 당첨된 횟수를 반환하는 테스트")
    void winningLottoNumberCount() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLottoNumberDto winningLottoNumber = WinningLottoNumberDto
                .createWinningLottoNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        int expectedWinningNumberCount = 6;

        // when
        WinningNumberCountDto winningNumberCount = lotto.winningLottoNumberCount(winningLottoNumber);

        // then
        assertThat(winningNumberCount).isNotNull();
        assertThat(winningNumberCount.getWinningCount()).isEqualTo(expectedWinningNumberCount);
    }
}
