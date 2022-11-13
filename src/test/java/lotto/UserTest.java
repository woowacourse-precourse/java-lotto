package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class UserTest {
    User user = new User();

    @ParameterizedTest
    @CsvSource({"0", "1500", "1000a"})
    public void validate(String input) {
        assertThatThrownBy(() -> user.validate(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }
}