package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoIssuerTest {
    LottoIssuer lottoIssuer = new LottoIssuer();

    @DisplayName("로또 발행기 테스트")
    @Nested
    class lottoIssuerTest {

        @DisplayName("로또 정상 생성 테스트")
        @Test
        void success1() {
            List<Integer> numbers = lottoIssuer.randomNumberGenerator();
            assertThat(lottoIssuer.issueLotto(numbers).getNumbers()).isEqualTo(numbers);
        }
    }
}
