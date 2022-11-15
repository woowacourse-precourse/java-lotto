package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.RandomLottoNumber;
import lotto.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomUtilTest {

    @Test
    @DisplayName("로또번호가 금액에 맞는 개수만큼 생성되는지 테스트")
    void countOfLottoNumbers() {
        String inputMoney = "8000";
        int countFromMoney = 8;

        List<RandomLottoNumber> lottoNumbers = RandomUtil.createLottoNumberList(countFromMoney);

        assertThat(8).isEqualTo(lottoNumbers.size());
    }

    @Test
    @DisplayName("로또 번호 하나가 6자리 숫자를 포함하는 지 테스트")
    void sizeOfLottoNumbers() {
        String inputMoney = "8000";
        int countFromMoney = 8;

        List<RandomLottoNumber> lottoNumbers = RandomUtil.createLottoNumberList(countFromMoney);

        assertThat(6).isEqualTo(lottoNumbers.get(0).getRandomNum().size());
    }
}