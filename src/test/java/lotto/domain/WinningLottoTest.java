package lotto.domain;

import lotto.domain.vo.LottoTicketResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoTest {

    @Test
    @DisplayName("당첨로또 객체가 생성되어야 한다.")
    void createWinningLotto() {
        // given
        String numbers = "1,2,3,4,5,6";
        String bonusNumber = "7";

        // when
        WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);

        // then
        assertThat(winningLotto)
                .usingRecursiveComparison()
                .isEqualTo(new WinningLotto("1,2,3,4,5,6", "7"));
    }

    @Test
    @DisplayName("당첨번호에 보너스번호가 중복되면 Excetion이 나야 한다.")
    void duplicate() {
        // given
        String numbers = "1,2,3,4,5,6";
        String bonusNumber = "6";

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new WinningLotto(numbers, bonusNumber));
        assertEquals("[ERROR] 보너스 번호에 중복 된 숫자가 포함되어있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨번호에 해당하는지 로또번호를 확인하면 결과를 던져줘야한다.")
    void winningLottoConfirm() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        lottos.add(new Lotto(List.of(8, 9, 10, 11, 12, 13)));

        // when
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        List<LottoTicketResult> result = winningLotto.confirmWinning(lottos);

        // then
        assertThat(result.get(0))
                .usingRecursiveComparison()
                .isEqualTo(new LottoTicketResult(6, false));
        assertThat(result.get(1))
                .usingRecursiveComparison()
                .isEqualTo(new LottoTicketResult(5, true));
        assertThat(result.get(2))
                .usingRecursiveComparison()
                .isEqualTo(new LottoTicketResult(5, false));
        assertThat(result.get(3))
                .usingRecursiveComparison()
                .isEqualTo(new LottoTicketResult(4, false));
        assertThat(result.get(4))
                .usingRecursiveComparison()
                .isEqualTo(new LottoTicketResult(3, false));
        assertThat(result.get(5))
                .usingRecursiveComparison()
                .isEqualTo(new LottoTicketResult(0, false));
    }
}