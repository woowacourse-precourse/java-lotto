package lotto.domain.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 발행 기능 클래스 테스트")
public class LottoIssuerTest {

    List<Lotto> lottos = new ArrayList<>();
    int purchaseAmount = 8000;

    @BeforeEach
    void setLottos() {
        lottos = LottoIssuer.issueLottos(purchaseAmount);
    }

    @Test
    @DisplayName("로또발행 - 입력된 금액만큼 발행된다.")
    void issueLottos_LottosCountTest() {
        assertThat(lottos.size()).isEqualTo(purchaseAmount / LottoIssuer.PRICE_OF_LOTTO);
    }

    @Test
    @DisplayName("로또발행 - 각각 6개의 숫자가 발행된다.")
    void issueLottos_NumbersCountTest() {
        int lottoNumberCount = 6;

        lottos.forEach(l -> assertThat(l.getNumbers().size()).isEqualTo(lottoNumberCount));
    }

    @Test
    @DisplayName("로또발행 - 각 숫자는 1~45 범위에 해당한다.")
    void issueLottos_RangeTest() {
        for (Lotto oneLotto : lottos) {
            List<Integer> numbers = oneLotto.getNumbers();
            numbers.forEach(n -> assertThat(checkRange(n)).isTrue());
        }
    }

    @Test
    @DisplayName("로또발행 - 각 숫자는 중복되지 않는다.")
    void issueLottos_DuplicatedTest() {
        for (Lotto oneLotto : lottos) {
            Set<Integer> checkDuplicate = new HashSet<>();

            List<Integer> numbers = oneLotto.getNumbers();
            numbers.forEach(n -> assertThat(checkDuplicate.add(n)).isTrue());
        }
    }

    boolean checkRange(int number) {
        if (1 <= number && number <= 45) {
            return true;
        }

        return false;
    }
}
