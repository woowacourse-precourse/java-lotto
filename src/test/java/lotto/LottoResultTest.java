package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void findTest() {
        assertThat(LottoResult.find(3, false)).isEqualTo(LottoResult.Match3);
        assertThat(LottoResult.find(3, true)).isEqualTo(LottoResult.None);
        assertThat(LottoResult.find(4, false)).isEqualTo(LottoResult.Match4);
        assertThat(LottoResult.find(4, true)).isEqualTo(LottoResult.None);
        assertThat(LottoResult.find(5, false)).isEqualTo(LottoResult.Match5);
        assertThat(LottoResult.find(5, true)).isEqualTo(LottoResult.Match5AndBonus);
        assertThat(LottoResult.find(6, false)).isEqualTo(LottoResult.Match6);
        assertThat(LottoResult.find(6, true)).isEqualTo(LottoResult.None);
    }
}