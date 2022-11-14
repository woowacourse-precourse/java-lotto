package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import utils.IsCollection;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoughtLottosTest {
    @DisplayName("로또 번호를 생성할 때 지정된 범위에서 번호가 만들어지는지 확인.")
    @RepeatedTest(50)
    void createBoughtLottos() {
        BoughtLottos boughtLottos = new BoughtLottos(100);

        int amount = boughtLottos.getAmount();
        List<Lotto> Lottos = boughtLottos.getLottos();

        assertThat(amount).isEqualTo(100);

        Lottos.forEach(lotto -> {
            assertThat(IsCollection.isNumbersInRange(lotto.getNumbers(), 1, 45)).isTrue();
        });
    }
}
