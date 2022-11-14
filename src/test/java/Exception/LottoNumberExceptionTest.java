package Exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberExceptionTest {
    @Test
    void inputLottoNumberByContainCharacter(){
        Assertions.assertThatThrownBy(() -> LottoNumberException.checkException("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputLottoNumberByOutOfRange(){
        Assertions.assertThatThrownBy(() -> LottoNumberException.checkException("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}