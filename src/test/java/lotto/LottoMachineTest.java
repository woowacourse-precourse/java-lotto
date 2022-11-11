package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 로또번호_크기_확인() {
        List<Integer> lottoNumbers = lottoMachine.createNumbers();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void 로또번호_중복_확인() {
        List<Integer> lottoNumbers = lottoMachine.createNumbers();
        long lottoSize = lottoNumbers.stream().count();

        assertThat(lottoNumbers.size()).isEqualTo(lottoSize);
    }

    @Test
    void 로또번호_정렬_확인() {
        List<Integer> lottoNumbers = lottoMachine.createNumbers();

        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            assertThat(lottoNumbers.get(i)).isLessThan(lottoNumbers.get(i + 1));
        }
    }
}