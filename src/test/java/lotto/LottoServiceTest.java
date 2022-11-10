package lotto;

import lotto.domain.NumberGenerator;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoServiceTest {
    NumberGenerator generator;
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        generator = new NumberGenerator();
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("로또번호 List를 생성하고 크기는 6이다.")
    void 랜덤으로_로또번호_생성_테스트() {
        assertThat(generator.createDuplicateNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("중복되지 않는 로또번호 List를 생성하고 크기는 6이다.")
    void 랜덤으로_중복되지않는_숫자리스트_생성_테스트() {
        Set<Integer> set = new HashSet<>(generator.createDuplicateNumbers());
        assertThat(set.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("구입금액 0 입력시 IllegalArgumentException테스트")
    void 로또구입금액_0으로인해_예외발생_테스트() {
        assertThatIllegalArgumentException()
                .as("[ERROR] 실패하는 입력값이 존재합니다.")
                .isThrownBy(() -> lottoService.validateMoneyZero(0));
    }

    @ParameterizedTest
    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않기 때문에 IllegalArgumentException테스트")
    @ValueSource(ints = {1005, 20001, 500, 2, 200})
    void 로또구입금액으로인해_예외발생_테스트(int input) {
        assertThatIllegalArgumentException()
                .as("[ERROR] 실패하는 입력값이 존재합니다.")
                .isThrownBy(() -> lottoService.validateMoney(input));
    }

    @ParameterizedTest
    @DisplayName("구입 금액 입력값이 숫자가 아니기 때문에 IllegalArgumentException테스트")
    @ValueSource(strings = {"10000a", "!avb10", "zxcffs", "5000!", "a", "1000."})
    void 로또구입금액_숫자가아니기때문에_예외발생_테스트(String input) {
        assertThatIllegalArgumentException()
                .as("[ERROR] 실패하는 입력값이 존재합니다.")
                .isThrownBy(() -> lottoService.validateConsistOfNumbers(input));
    }
}
