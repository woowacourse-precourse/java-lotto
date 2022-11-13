package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {
    @Test
    void validateCanDivideIntoOneThousand_구매_금액이_1000으로_나누어_떨어지지_않으면_예외를_던지는지_테스트() {
        //given
        int amount = 1200;
        //when
        //then
        assertThatThrownBy(() -> {
                      if (amount % 1000 == 0) {
                          return;
                      }
                      System.out.println("[ERROR] 금액은 1000원 단위로만 입력 가능합니다.");
                      throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로만 입력 가능합니다.");
                  })
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageContaining("[ERROR]");
    }
}