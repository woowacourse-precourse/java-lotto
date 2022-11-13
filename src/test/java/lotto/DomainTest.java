package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class DomainTest {
    static Domain domain = new Domain();

    @DisplayName("구입 가격 형식 검증 테스트")
    @Test
    void validatePriceInput() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validatePriceInput("9");
        });

        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validatePriceInput("3000a");
        });

        Assertions.assertThrows(RuntimeException.class, () -> {
            domain.validatePriceInput("3001");
        });
    }
}
