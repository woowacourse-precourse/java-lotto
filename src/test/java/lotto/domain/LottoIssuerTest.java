package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class LottoIssuerTest {
    LottoIssuer lottoIssuer = new LottoIssuer();

    @DisplayName("로또 발행기 테스트")
    @Nested
    class lottoIssuerTest {

        @DisplayName("예외 실행: 로또 번호 갯수가 6개가 아닐 때")
        @Test
        void fail1() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> lottoIssuer.issueLotto(Arrays.asList(1, 2, 3, 4, 5)));
        }

        @DisplayName("예외 실행: 로또 번호 범위 벗어난 경우")
        @Test
        void fail2() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> lottoIssuer.issueLotto(Arrays.asList(0, 1, 2, 3, 4, 46)));
        }

        @DisplayName("예외 실행: 로또 번호 중복된 경우")
        @Test
        void fail3() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> lottoIssuer.issueLotto(Arrays.asList(1, 1, 2, 3, 4, 4)));
        }
    }
}
