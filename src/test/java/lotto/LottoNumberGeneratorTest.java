package lotto;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("로또가 잘 발행되는지 확인.")
    @Test
    public void generateLotto() {
        assertDoesNotThrow(LottoNumberGenerator::create);
    }

}