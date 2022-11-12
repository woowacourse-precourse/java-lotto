package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseLottosTest {
    @DisplayName("구매한 만큼 로또 번호 생성 - 6개의 로또가 서로 다르다")
    @Test
    void createDifferentPurchaseLottos() {
        PurchaseLottos purchaseLottos = new PurchaseLottos(6);
        long distinctCount = purchaseLottos.getPurchaseLottos().stream().distinct().count();
        assertThat(distinctCount == purchaseLottos.getPurchaseLottos().size()).isTrue();
    }

    @DisplayName("구매한 만큼 로또 번호 생성 - 6개의 로또가 모두 유효성 검사에 성공한다")
    @Test
    void createRandomLottoNumbers() {
        PurchaseLottos purchaseLottos = new PurchaseLottos(6);

        for (int index = 0; index < purchaseLottos.getPurchaseLottos().size(); index++) {
            List<Integer> lotto = purchaseLottos.getPurchaseLottos().get(index).getNumbers();

            assertThat(lotto.size()).isEqualTo(6);
            assertThat(lotto.stream().distinct().count() == lotto.size()).isTrue();
            assertThat(lotto.stream().allMatch(number -> number >= 1 && number <= 45)).isTrue();
        }
    }
}
