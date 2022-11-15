package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.UserLotto;
import lotto.util.GenerateLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenerateLottoNumbersTest {
    private static final int PRICE_OF_LOTTO = 1000;

    @DisplayName("로또 구매 수량 반환 기능 테스트")
    @Test
    public void getPurchaseQuantityTest() {
        // given
        int buyingPrice = 10000;

        // when
        int result = GenerateLottoNumbers.getPurchaseQuantity(buyingPrice);

        // then
        assertThat(result).isEqualTo(buyingPrice / PRICE_OF_LOTTO);
    }

    @DisplayName("로또 리스트 정렬 테스트")
    @Test
    public void sortedListTest() {
        // given
        List<Integer> unsortedList = List.of(3, 2, 1, 6, 5, 4);
        List<Integer> sortedList = new ArrayList<>();
        List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);

        // when
        sortedList = GenerateLottoNumbers.sortedList(unsortedList);

        // then
        assertThat(sortedList).isEqualTo(answer);
    }

    @DisplayName("로또 구매 테스트")
    @Test
    public void purchaseTest() {
        // given
        int quantity = 10;
        List<UserLotto> lottos = new ArrayList<>();

        // when
        lottos = GenerateLottoNumbers.purchaseLotto(quantity);

        // then
        assertThat(lottos.size()).isEqualTo(quantity);
    }

}