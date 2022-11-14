package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.RepeatedTest;

public class LottoGeneratorTest {

    @RepeatedTest(50)
    void 중복되지_않는지_검사() {
        //given

        //when
        List<Integer> lotto = LottoGenerator.createRandomLotto();

        //then
        assertThat(lotto.size()).isEqualTo(lotto.stream().distinct().count());
    }

    @RepeatedTest(50)
    void 오름차순_검사() {
        //given

        //when
        List<Integer> lotto = LottoGenerator.createRandomLotto();

        //then
        assertThat(lotto).isEqualTo(lotto.stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
