package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {
    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않으면 예외를 던지는지 테스트한다")
    @Test
    void validateCanDivideIntoOneThousand() {
        //given
        int value = 1200;
        int price = 1000;
        //when
        //then
        assertThatThrownBy(() -> {
                      if (value % price == 0) {
                          return;
                      }
                      System.out.println("[ERROR] 금액은 1000원 단위로만 입력 가능합니다.");
                      throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로만 입력 가능합니다.");
                  })
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageContaining("[ERROR]");
    }

    @DisplayName("구매금액을 로또 금액으로 나누었을때 로또 수량이 잘 반환되는지 테스트")
    @Test
    void calculateLottoCount() {
        //given
        int value = 2000;
        int price = 1000;
        //when
        int lottoCount = value / price;
        //then
        assertThat(lottoCount).isEqualTo(2);
    }
}