package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.dto.PurchaseAmountDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private User user;
    private WinningLotto winningLotto;
    private final LottoService lottoService = new LottoService();

    @BeforeEach
    void setUp() {
        PurchaseAmountDto purchaseAmountDto = PurchaseAmountDto.of(8_000);
        user = User.of(purchaseAmountDto);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 11;
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("[정상] calculateLottoRanks 기능을 통해 구매한 로또의 등수를 확인 할 수 있다.")
    void calculateLottoRanks() {
        lottoService.calculateRankings(user, winningLotto);
        assertThat(user.getRankings()).isNotEmpty();
        assertThat(user.getRankings().size()).isEqualTo(8);
    }

    @Test
    @DisplayName("[예외] calculateLottoRanks 기능을 호출하기전에는 빈 리스트이다.")
    void calculateLottoRanks_Before() {
        assertThat(user.getRankings()).isEmpty();
    }
}
