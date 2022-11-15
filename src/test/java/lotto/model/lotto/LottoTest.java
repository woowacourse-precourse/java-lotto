package lotto.model.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void 로또번호_갯수_검증() {
        //given
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6,7);

        //when then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 잘못된 개수를 입력하였습니다.");
    }

    @Test
    void 로또번호_중복_검증() {
        //given
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,5);

        //when then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 로또번호를 입력하였습니다.");
    }
}