package lotto.numbers_generator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorSequenceImplTest {

    @Test
    void 로또번호순차생성() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumberGeneratorSequenceImpl(
                List.of(
                        List.of(1,2,3,4,5,6),
                        List.of(2,3,4,5,6,7)
                )
        );
        List<Integer> first = lottoNumbersGenerator.generate();
        List<Integer> second = lottoNumbersGenerator.generate();
        List<Integer> third = lottoNumbersGenerator.generate();
        Assertions.assertThat(first).isEqualTo(List.of(1,2,3,4,5,6));
        Assertions.assertThat(second).isEqualTo(List.of(2,3,4,5,6,7));
        Assertions.assertThat(third).isNull();
    }
}