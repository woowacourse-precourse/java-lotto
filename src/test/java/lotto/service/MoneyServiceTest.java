package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class MoneyServiceTest {
    @Test
    void 로또_구입_금액_정상_입력_테스트() {
        String input = "1000";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(MoneyService.createMoney().getMoney()).isEqualTo(1000);
    }

    @Test
    void 로또_구입_금액_1000원_단위_예외_발생() {
        String input = "1111";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(MoneyService::createMoney)
                .isInstanceOf(IllegalArgumentException.class);
    }
}