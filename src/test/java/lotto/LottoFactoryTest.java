package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoFactoryTest {

    @Test
    @DisplayName("생성자 생성 성공")
    void testNewLottoList() {
        List<Lotto> lottoList = LottoFactory.newLottoList(6);

        assertThat(lottoList.size()).isEqualTo(6);
    }
}
