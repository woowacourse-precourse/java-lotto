package lotto;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PurchasedLottosTest {
    @DisplayName("구매한 로또 목록 생성 성공")
    @Test
    void createPurchasedLottosSuccess() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto);

        assertThatCode(() -> new PurchasedLottos(lottos))
                .doesNotThrowAnyException();;
    }

    @DisplayName("구매한 로또들의 번호는 오름차순으로 정렬되어있다.")
    @Test
    void checkPurchasedLottoisSorted() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        PurchasedLottos purchasedLottos = new PurchasedLottos(List.of(lotto));

        List<Integer> purchasedNumbers = purchasedLottos.getPurchasedLottos().get(0).getNumbers();
        List<Integer> sortedNumbers = lotto.getNumbers().stream().sorted().collect(Collectors.toList());

        assertThat(purchasedNumbers).isEqualTo(sortedNumbers);
    }
}
