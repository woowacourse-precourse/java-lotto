package lotto;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasedLottosTest {
    private static final int EACH_LOTTO_PRICE = PurchasedLottos.PRICE;
    private PurchasedLottos purchasedLottos;
    private int purchasePrice;

    @BeforeEach
    void setPurchasedLotto() {
        purchasePrice = 2000;
        purchasedLottos = new PurchasedLottos(purchasePrice);
    }

    @DisplayName("로또 구입 금액이 로또 한 개당 가격에 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 구입금액이_로또_개당_가격의_배수가_아닌_경우_예외처리() {
        purchasePrice = 2500;

        assertThatThrownBy(() -> purchasedLottos = new PurchasedLottos(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
    }

    @DisplayName("구입한 로또의 개수는 (구입 금액 / 로또 개당 가격)과 일치한다.")
    @Test
    void 로또가_구입금액에_맞게_생성되는지_확인() {
        assertThat(purchasedLottos.getLottos().size()).isEqualTo(purchasePrice / EACH_LOTTO_PRICE);
    }

    @DisplayName("구매한 로또의 번호는 오름차순으로 정렬된다.")
    @Test
    void 로또_번호가_오름차순으로_정렬되는지_확인() {
        Lotto lotto = purchasedLottos.getLottos().get(0);
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        assertThat(numbers).isEqualTo(sortedNumbers);
    }
}
