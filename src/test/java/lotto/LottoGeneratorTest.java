package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("로또가 잘 발행된다.")
    @Test
    public void createLotto() {
        assertDoesNotThrow(LottoGenerator::generate);
    }
}