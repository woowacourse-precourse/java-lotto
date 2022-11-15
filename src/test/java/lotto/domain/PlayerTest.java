package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사용자 입력 유효성 검사 테스트")
class PlayerTest {
    private final Player player = new Player();

    @DisplayName("입력한 금액만큼 로또가 생성되는지 확인한다.")
    @Test
    void generateLottoByPurchasedAmount() {
        player.purchaseCost = 5000;
        player.purchaseLotto();

        assertThat(player.getLottos()).hasSize(5);
    }
}
