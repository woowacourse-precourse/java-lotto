package lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    @Test
    @DisplayName("주어진 profit 값을 백분율로 바꾸어 반환할 수 있다.")
    void givenProfit_whenConvertingToPercentage_thenReturnsProfitOfPercentageValue() {
        //given
        Profit profit = new Profit(0.625);
        //when
        Profit target = profit.convertToPercentage();

        //then
        assertThat(target.getValue()).isEqualTo(62.5);
    }

    @Test
    @DisplayName("주어진 profit 값을 소수점 둘째 자리에서 반올림하여 반환할 수 있다.")
    void givenProfit_whenRoundingToFirstDigit_thenReturnsProfitOfRoundedValue() {
        //given
        Profit profit = new Profit(0.625);

        //when
        Profit target = profit.roundToFirstDigit();

        //then
        assertThat(target.getValue()).isEqualTo(0.6);
    }

    @Test
    @DisplayName("백분율 변환과 소수점 둘째 자리 반올림을 메소드 체인으로 연속 호출할 수 있다.")
    void givenProfit_whenCallingMethodChaining_thenReturnsProfitOfRoundedPercentageValue() {
        //given
        Profit profit = new Profit(1.7927);

        //when
        Profit target = profit
                .convertToPercentage()
                .roundToFirstDigit();

        //then
        assertThat(target.getValue()).isEqualTo(179.3);
    }
}