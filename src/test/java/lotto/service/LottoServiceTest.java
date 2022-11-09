package lotto.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoServiceTest {

    private final LottoService service = new LottoService();
    private static Collection<Arguments> param1() {
        return Arrays.asList(
            Arguments.of("1000원으로 1개 구매", "1000", 1),
            Arguments.of("9000원으로 9개 구매", "9000", 9),
            Arguments.of("10000원으로 10개 구매", "10000", 10),
            Arguments.of("1000000원으로 1000개 구매", "1000000", 1000)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    @DisplayName("정상적인 금액이 입력되면 전부 로또를 구매 해야한다.")
    void test1(String description, String money, int size) {
        List<Lotto> lottos = service.buy(money);
        Assertions.assertEquals(size, lottos.size());
    }

}
