package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class MakingLottoTest {

    @Test
    void getLottoCountTest() {
        MakingLotto makingLotto=new MakingLotto();

        assertThat(makingLotto.getLottoCount(1000)).isEqualTo(1);
        assertThat(makingLotto.getLottoCount(8000)).isEqualTo(8);
        assertThat(makingLotto.getLottoCount(23000)).isEqualTo(23);

    }
}