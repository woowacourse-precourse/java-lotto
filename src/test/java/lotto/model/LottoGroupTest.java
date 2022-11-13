package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottoGroupTest {

    @DisplayName("로또 그룹 출력 검증")
    @Test
    void 로또_그룹_출력(){
        // given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(9, 8, 7, 6, 4,2)),
                new Lotto((Arrays.asList(10, 28,38, 1, 9, 32)))
        );
        // when
        LottoGroup lottoGroup = new LottoGroup(lottos);
        // then
        Assertions.assertThat(lottoGroup.getLottosString())
                .isEqualTo("[2, 4, 6, 7, 8, 9]\n[1, 9, 10, 28, 32, 38]");
    }


}