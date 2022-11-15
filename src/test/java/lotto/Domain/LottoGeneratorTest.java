package lotto.Domain;

import lotto.Domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    @DisplayName("사용자가 구입할 수 있는 수량 만큼 로또를 생성한다.")
    void issueLotto() {
        //given
        String userPrice = "3000";
        int expectAmount = 3;
        LottoGenerator lottoGenerator = new LottoGenerator(userPrice);

        //when
        int amount = lottoGenerator.issueLotto().size();

        //then
        assertEquals(expectAmount, amount);
    }

    @Test
    @DisplayName("구입 금액에 숫자 이외의 문자가 있다면 예외가 발생한다.")
    void haveOnlyNumbers() {
        //given
        String price = "1240won";
        //then
        assertThatThrownBy(() -> new LottoGenerator(price)) //when
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    void divideByThousand() {
        //given
        String price = "124";
        //then
        assertThatThrownBy(() -> new LottoGenerator(price)) //when
                .isInstanceOf(IllegalArgumentException.class);
    }
}