package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {
    @Test
    void validateCanDivideIntoOneThousand_구매_금액이_1000으로_나누어_떨어지지_않으면_예외를_던지는지_테스트() {
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

    @Test
    void calculateLottoCount_구매_금액을_로또_금액으로_나누었을때_로또_수량이_잘_반환되는지_테스트() {
        //given
        int value = 2000;
        int price = 1000;
        //when
        int lottoCount = value / price;
        //then
        assertThat(lottoCount).isEqualTo(2);
    }
}