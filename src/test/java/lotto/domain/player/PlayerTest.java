package lotto.domain.player;

import lotto.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.domain.player.Player.LOTTO_PRICE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerTest {
    @DisplayName("구입금액만큼 로또 개수를 생성한다.")
    @ParameterizedTest
    @CsvSource({"8000", "50000", "13000"})
    void generateLotto(int money){
        Player player = new Player(money);
        assertThat(player.getLottoTickets().size()).isEqualTo(money/LOTTO_PRICE);
    }

    @DisplayName("구입금액이 천원 단위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"8500", "1234", "168239"})
    void noLottoPriceUnit(int money){
        assertThatThrownBy(() -> new Player(money)).isInstanceOf(IllegalArgumentException.class);
    }
}
