package lottoMachine.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    void Enum_로또_범위_시작은_1입니다() {
        int start = Numbers.LOTTO_NUMBER_START.getValue();

        assertThat(start).isEqualTo(1);
    }

    @Test
    void Enum_로또_범위_끝은_45입니다() {
        int end = Numbers.LOTTO_NUMBER_END.getValue();

        assertThat(end).isEqualTo(45);
    }

    @Test
    void Enum_로또_가격은_1000입니다() {
        int lottoPrice = Numbers.LOTTO_PRICE.getValue();

        assertThat(lottoPrice).isEqualTo(1000);
    }

    @Test
    void Enum_당첨번호_사이즈는_6입니다() {
        int winningNumberSize = Numbers.WINNING_NUMBER_SIZE.getValue();

        assertThat(winningNumberSize).isEqualTo(6);
    }

    @Test
    void Enum_보너스번호_사이즈는_1입니다() {
        int bonusNumberSize = Numbers.BONUS_NUMBER_SIZE.getValue();

        assertThat(bonusNumberSize).isEqualTo(1);
    }
}
