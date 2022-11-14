package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.RandomLottoNumber;
import lotto.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Random;

class RandomUtilTest {

    @Test
    @DisplayName("로또번호가 금액에 맞는 개수만큼 생성되는지 테스트")
    void countOfLottoNumbers(){
        int money = 5000;
        int count = money / 1000;

        List<RandomLottoNumber> lottoNumbers = RandomUtil.createLottoNumberList(count);

        assertThat(5).isEqualTo(lottoNumbers.size());
    }

    @Test
    @DisplayName("로또 번호 하나가 6자리 숫자를 포함하는 지 테스트")
    void sizeOfLottoNumbers(){
        int money = 1000;
        int count = money / 1000;

        List<RandomLottoNumber> lottoNumbers = RandomUtil.createLottoNumberList(count);

        assertThat(6).isEqualTo(lottoNumbers.get(0).getRandomNum().size());
    }
}