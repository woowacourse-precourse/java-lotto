package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.validation.ValidationUtil;
import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    @DisplayName("checkSizeTest")
    @Test
    void checkSizeTest() {
        boolean origin = ValidationUtil.checkSize(List.of(1, 2, 3));

        assertThat(origin).isEqualTo(true);
    }
}
