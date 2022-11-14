package MyTest;

import lotto.domain.Lotto;
import lotto.domain.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {
    @DisplayName("정상 입력 테스트")
    @Test
    void normalInputTest() {
        //given
        String input = "80000";
        //then
        assertThat(new Purchase(input).getPurchaseAmount()).isEqualTo(80000);
    }

    @DisplayName("입력금액에 문자 포함시 예외 발생")
    @Test
    void includeCharacter() {
        //given
        String input = "ds1000";
        //then
        assertThatThrownBy(()->Purchase.validatePurchaseInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력금액이 1000원 단위가 아닐 경우 예외 발생")
    @Test
    void invalidUnit() {
        //given
        String input = "123423";
        //then
        assertThatThrownBy(()->Purchase.validatePurchaseInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백입력 시, 예외 발생")
    @Test
    void blankInput() {
        String input = "";
        assertThatThrownBy(()->new Purchase(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 12000원 이면, 생성된 로또들은 12개 입니다.")
    @Test
    void lottoCreatorTest() {
        //given
        String input = "12000";
        Purchase purchase = new Purchase(input);

        //when
        List<Lotto> lotteries = purchase.getLotteries();

        //then
        assertThat(12).isEqualTo(lotteries.size());
    }
}
