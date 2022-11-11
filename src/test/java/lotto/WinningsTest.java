package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningsTest {

    @DisplayName("당첨 금액 출력")
    @Test
    void 당첨_금액_출력() {
        Assertions.assertThat(Winnings.오천.winnings()).isEqualTo(5000);
        Assertions.assertThat(Winnings.오만.winnings()).isEqualTo(50000);
        Assertions.assertThat(Winnings.백오십만.winnings()).isEqualTo(1500000);
        Assertions.assertThat(Winnings.삼천만.winnings()).isEqualTo(30000000);
        Assertions.assertThat(Winnings.이십억.winnings()).isEqualTo(2000000000);
    }

}