package lotto.datamodel;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MakeLottoNumberTest {
    @DisplayName("주어진 수만큼 로또를 발행한다")
    @Test
    void checkMakeNumbers() {
        int lottoCount = 5;
        MakeLottoNumber test = new MakeLottoNumber(lottoCount);
        List<List<Integer>> result = test.makeNumbers();

        assertThat(result.size()).isEqualTo(lottoCount);
    }

}
