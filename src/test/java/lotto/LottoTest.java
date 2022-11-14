package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구입 할 수 있는 로또의 개수를 구한다")
    @ParameterizedTest
    @CsvSource(value = {"10000,10","15000,15","1000,1"})
    public void buyLottos(int price, int expected) throws Exception {
        //when
        Lotto lotto = new Lotto(price);
        int purchaseQuantity = lotto.purchaseQuantity();

        //then
        assertEquals(expected, purchaseQuantity);
    }

    @Test
    @DisplayName("1000원 미만의 금액으로 로또를 구매하려고 하면 오류")
    public void purchasePriceLimit() {
        //given
        int price = 900;

        //when
        Lotto lotto = new Lotto(price);

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lotto.purchaseQuantity())
                .withMessageMatching("1000원 이상의 금액을 입력해야합니다.");
    }

    // 아래에 추가 테스트 작성 가능
}
