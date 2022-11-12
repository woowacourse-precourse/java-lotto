package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.Computer;
import lotto.Lotto;
import lotto.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoServiceTest {

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
        LottoService service = new LottoService(new Validator(), new Computer());
        List<Lotto> lottos = service.buy(money);
        Assertions.assertEquals(size, lottos.size());
    }

    private static Collection<Arguments> param2() {
        return Arrays.asList(
            Arguments.of("1000j 비정상적인 입력테스트", "1000j"),
            Arguments.of("abcd 비정상적인 입력테스트", "abcd"),
            Arguments.of("-1000 비정상적인 입력테스트", "-1000"),
            Arguments.of("999 비정상적인 입력테스트", "999"),
            Arguments.of("1 비정상적인 입력테스트", "1")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param2")
    @DisplayName("비정상적인 금액이 입력되면 익셉션을 던진다")
    void test2(String description, String money) {
        LottoService service = new LottoService(new Validator(), new Computer());
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
            () -> service.buy(money));
        assertThat(e.getMessage()).contains("[ERROR]");
    }

    private static Collection<Arguments> param3() {
        return Arrays.asList(
            Arguments.of("비어있는 로또와 당첨번호",
                Collections.EMPTY_LIST,
                Collections.EMPTY_LIST, 7)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param3")
    @DisplayName("로또 서비스의 getResult 테스트")
    void test3(String description, List<Lotto> lottos, List<Integer> win, int bonus) {
        ComputerSpy computerSpy = new ComputerSpy();
        LottoService service = new LottoService(new Validator(), computerSpy);
        service.getResult(lottos, win, bonus);
        Assertions.assertTrue(computerSpy.isCalled);
    }

}
