package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoUserTest {
    @DisplayName("1000으로 나누어 떨어지지 않는 경우 IllegalArgumentException, 메세지 확인")
    @ParameterizedTest
    @ValueSource(longs = {80,500,1200,1600,2200,1334523,8001,7999})
    void 검증_1000으로_나누어떨어지지않는경우_IllegalArgumentException(long money) {
        assertThatThrownBy(() -> new LottoUser(money,new LottoSystem()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000원 단위로 나누어 떨어져야 합니다.");
    }

    @DisplayName("음수인 경우 IllegalArgumentException, 메세지 확인")
    @ParameterizedTest
    @ValueSource(longs = {-1,-100,-12412434})
    void 검증_음수인경우_IllegalArgumentException(long money) {
        assertThatThrownBy(() -> new LottoUser(money,new LottoSystem()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 0이상이여야 합니다");
    }

    @DisplayName("주어진 금액만큼 로또를 구매했는지, Lotto의 검증 형식에 맞춰서 번호를 생성했는지")
    @ParameterizedTest
    @CsvSource(value = {"0,0","1000,1","2000,2","5000,5","10000,10","13000,13","20000000,20000"})
    void buyLottoTest(long money, int cnt) {
        LottoUser user = new LottoUser(money,new LottoSystem());
        List<Lotto> lottos = user.getLottos();
        assertEquals(lottos.size(),cnt);
    }


}

