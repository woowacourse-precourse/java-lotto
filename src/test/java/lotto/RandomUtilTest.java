package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class RandomUtilTest {

    @Test
    @DisplayName("로또번호 개수가 금액에 부합하는지 테스트")
    void countOfLottoNumbers(){
        int money = 5000;

        List<List<Integer>> lottoNumbers = RandomUtil.getLottoNumbers(money);

        assertThat(5).isEqualTo(lottoNumbers.size());
    }

    @Test
    @DisplayName("로또 번호 하나가 6자리 숫자를 포함하는 지 테스트")
    void sizeOfLottoNumbers(){
        int money = 1000;

        List<List<Integer>> lottoNumbers = RandomUtil.getLottoNumbers(money);

        assertThat(6).isEqualTo(lottoNumbers.get(0).size());
    }
}