package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    private static final LottoFactory lottoFactory = new LottoFactory();

    @Test
    @DisplayName("로또 팩토리는 랜덤한 숫자를 생성한다.")
    void generateRandomNumber() {
        //given
        //when
        List<Integer> lotto = lottoFactory.randomLottoNumbers();
        //then
        lotto.forEach(lottoNumber -> assertTrue(lottoNumber >= 1 && lottoNumber <= 45));
    }

    @Test
    @DisplayName("로또 팩토리는 랜덤한 숫자 6개를 뽑는다.")
    void generateNumbers() {
        assertThat(lottoFactory.randomLottoNumbers().size()).isEqualTo(6);
    }
}