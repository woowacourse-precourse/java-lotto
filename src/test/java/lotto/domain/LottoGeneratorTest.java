package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {

    @Test
    void 로또_생성_개수_확인(){
        LottoGenerator lottoGenerator = new LottoGenerator(8000);

        int expected = 8;

        assertThat(lottoGenerator.getNumberOfLotto()).isEqualTo(expected);
    }

    @Test
    void 로또_번호_1에서_45사이인지_확인(){
        LottoGenerator lottoGenerator = new LottoGenerator(8000);
        List<Lotto> lottos = lottoGenerator.getLottos();

        for(Lotto lotto :lottos){
            assertThat(lotto.getNumbers().stream().allMatch(v -> v>=1 && v<=45)).isTrue();
        }
    }

    @Test
    void 로또_번호_중복_없는지_확인(){
        LottoGenerator lottoGenerator = new LottoGenerator(8000);
        List<Lotto> lottos = lottoGenerator.getLottos();

        for(Lotto lotto :lottos){
            List<Integer> numbers = lotto.getNumbers();
            for(int i : numbers){
                assertThat(numbers.stream().filter(v -> v.equals(i)).count()).isEqualTo(1);
            }
        }
    }

}