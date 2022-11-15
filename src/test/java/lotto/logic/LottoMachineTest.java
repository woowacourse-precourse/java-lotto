package lotto.logic;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    static LottoMachine lottoMachine;

    @BeforeAll
    static void init() {
        lottoMachine = LottoMachine.getInstance();
    }

    @DisplayName("로또 번호가 오름차순으로 정렬된 하나의 로또를 만든다.")
    @Test
    void generateLotto() {
        Lotto lotto = lottoMachine.generateLotto();

        List<Integer> numbers = new ArrayList<>();
        for (int size = LottoInfo.SIZE.value(), i = 0; i < size; i++) {
            numbers.add(lotto.get(i));
        }

        assertThat(numbers).isSorted();
    }

    @DisplayName("지불한 금액에 맞는 로또의 리스트를 만든다.")
    @Test
    void generateLottos() {
        long payment = 8_000L;
        List<Lotto> lottos = lottoMachine.generateLottos(payment);
        assertThat(lottos.size()).isEqualTo(payment / LottoInfo.PRICE.value());
    }

}
