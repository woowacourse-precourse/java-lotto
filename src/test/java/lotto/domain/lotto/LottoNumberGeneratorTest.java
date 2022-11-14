package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    
    @Test
    void randomLottoNumberList_메소드는_NUMBER_COUNT_만큼의_size를_가진_리스트를_반환() {
        assertThat(LottoNumberGenerator.randomLottoNumberList().size()).isEqualTo(
                LottoNumberGenerator.NUMBER_COUNT);
    }
    
    @Test
    void randomLottoNumberList_메소드는_START_NUMBER보다_크고_END_NUMBER보다_작은_원소만_가진_리스트를_반환() {
        for (Integer number : LottoNumberGenerator.randomLottoNumberList()) {
            assertThat(number).isGreaterThanOrEqualTo(LottoNumberGenerator.START_NUMBER);
            assertThat(number).isLessThanOrEqualTo(LottoNumberGenerator.END_NUMBER);
        }
    }
    
    @Test
    void randomLottoNumberList_메소드는_중복_원소가_없는_리스트를_반환() {
        List<Integer> lottoNumbers = LottoNumberGenerator.randomLottoNumberList();
        assertThat(lottoNumbers.size()).isEqualTo(new HashSet<>(lottoNumbers).size());
    }
}
