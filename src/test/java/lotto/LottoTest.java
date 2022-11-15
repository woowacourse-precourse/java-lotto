package lotto;

import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    public static final int PURCHASE_PRICE = 8000;

    LottoGenerator lottoGenerator = new LottoGenerator();

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

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("만들어진 로또 번호에 중복이 없는지 테스트")
    @Test
    void noDuplicatedNumber() {
        List<Lotto> lottos = lottoGenerator.generateLottos(1);

        assertThat(lottos).doesNotHaveDuplicates();
    }

    @DisplayName("만들어진 로또 번호가 오름차순인지 테스트")
    @Test
    void inAscendingOrder() {
        List<Lotto> lottos = lottoGenerator.generateLottos(1);

        List<Lotto> sortedLottos = lottos.stream()
                .sorted()
                .collect(Collectors.toList());

        assertThat(lottos).isEqualTo(sortedLottos);
    }

    @DisplayName("로또가 구입금액만큼 만들어지는지 테스트")
    @Test
    void lottoGenerateByPurchasePrice() {
        LottoSeller lottoSeller = new LottoSeller();
        List<Lotto> lottos = lottoSeller.sellLottos(PURCHASE_PRICE);

        assertThat(lottos.size()).isEqualTo(PURCHASE_PRICE / Lotto.PRICE);
    }
}
