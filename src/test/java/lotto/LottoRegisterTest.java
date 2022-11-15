package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoRegisterTest {
    private LottoRegister lottoRegister;

    @BeforeEach
    void setup() {
        lottoRegister = new LottoRegister();
    }

    @Test
    void getRateOfReturn() {
        lottoRegister.totalIncome = 50_000;
        float result = lottoRegister.getRateOfReturn(1000);

        assertThat(result).isEqualTo(5000);
    }

    @Test
    void countMatchedNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> pickedNumbers = List.of(1, 2, 6, 7, 9, 14);
        int result = lottoRegister.countMatchedNumber(lotto, pickedNumbers);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void calculateTotalGain() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(6,5,19,20,44,45)));
        List<Integer> pickedNumbers = List.of(1, 2, 3, 4, 6, 14);
        List<Integer> bonusNum = List.of(5);

        int result = lottoRegister.calculateTotalGain(lottos, pickedNumbers, bonusNum);
        assertThat(result).isEqualTo(30_000_000);
    }
}