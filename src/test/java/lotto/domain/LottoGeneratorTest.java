package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @Test
    void numberGenerator_크기_테스트(){

        assertThat(LottoGenerator.numberGenerator().size()).isEqualTo(6);
    }

    @Test
    void finalGenerator_마지막_크기_테스트(){
        assertThat(LottoGenerator.finalGenerator(7).size()).isEqualTo(7);
    }

}