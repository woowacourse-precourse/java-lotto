package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WinningRuleTest {

    @Test
    @DisplayName("결과에 해당하는 enumType을 찾아줘야 한다.")
    void resultEnumType() {
        // given
        Map<String, Object> result = Map.of("count", 6, "bonus", false);

        // when
        Optional<WinningRule> check = WinningRule.check(result);
        WinningRule winningRule = check.get();

        // then
        assertEquals(WinningRule.SECOND, winningRule);
    }

    @Test
    @DisplayName("결과에 해당하는 enumType이 없으면 Optional이기에 아무것도 없어야한다.")
    void enumTypeHasNotResult() {
        // given
        Map<String, Object> result = Map.of("count", 0, "bonus", false);

        // when
        Optional<WinningRule> check = WinningRule.check(result);

        // then
        assertFalse(check.isPresent());
    }
}