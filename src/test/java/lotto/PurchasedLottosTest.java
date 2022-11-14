package lotto;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasedLottosTest {
    @DisplayName("구매한 로또들의 번호는 오름차순으로 정렬되어있다.")
    @Test
    void checkPurchasedLottoisSorted() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(6);
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);

        Lotto lotto = new Lotto(numbers);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        PurchasedLottos purchasedLottos = new PurchasedLottos(lottos);
        List<Integer> purchasedNumbers = purchasedLottos.getPurchasedLottos().get(0).getNumbers();
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());

        assertThat(purchasedNumbers).isEqualTo(sortedNumbers);
    }
}
