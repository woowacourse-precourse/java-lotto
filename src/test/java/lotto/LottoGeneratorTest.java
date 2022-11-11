package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    private final int NUM_OF_LOTTO = 5;
    private final int LOTTO_SIZE = 6;
    private LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("주어진 로또의 개수 만큼 로또가 생성되었는지 확인한다.")
    @Test
    void getNumOfLotto() {
        List<Lotto> lotto = lottoGenerator.generateLottoList(NUM_OF_LOTTO);
        assertThat(lotto.size()).isEqualTo(NUM_OF_LOTTO);
    }


    @DisplayName("생성된 로또가 중복되지 않는 6개의 숫자로 이루어져 있는지 확인한다.")
    @Test
    void getLottoNum() {
        List<Lotto> lotto = lottoGenerator.generateLottoList(NUM_OF_LOTTO);

        for (int i = 0; i < NUM_OF_LOTTO; i++) {
            //로또는 null이 아니다.
            assertThat(lotto.get(i)).isNotNull();

            //로또는 6개의 숫자로 이루어져있다.
            List<Integer> lottoNum = lotto.get(i).getLottoNum();
            assertThat(lottoNum.size()).isEqualTo(LOTTO_SIZE);

            //로또의 번호는 중복되지 않는다.
            Set<Integer> notDuplicated = new HashSet<>(lottoNum);
            assertThat(lottoNum.size()).isEqualTo(notDuplicated.size());
        }
    }
}