package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WInnerTest {

    @DisplayName("로또를 구매해서 DB에 저장하고 예상했던 개수와 일치하면 통과")
    @Test
    void buyLottoTest() {
        assertThat(Winner.getPrize(3)).isEqualTo(5000);
        assertThat(Winner.getPrize(4)).isEqualTo(50000);
        assertThat(Winner.getPrize(5)).isEqualTo(1500000);
        assertThat(Winner.getPrize(50)).isEqualTo(30000000);
        assertThat(Winner.getPrize(6)).isEqualTo(2000000000);
    }
}


