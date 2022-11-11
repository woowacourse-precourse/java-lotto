package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.IllegalLottoException;
import lotto.exception.IllegalResultLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultLottoTest {
    @DisplayName("정상 생성")
    @Test
    void constructorCorrectTest() {
        new ResultLotto("1,2,3,4,5,6", ",", 6, "7", 1);
    }

    @DisplayName("에러")
    @Test
    void constructorErrorTest() {
        assertThatThrownBy(() ->
                new ResultLotto("1,2,3,4,5,6", ".", 6, "7", 1)
        )
                .isInstanceOf(IllegalLottoException.class);

    }

    @DisplayName("중복에러")
    @Test
    void duplicateErrorTest() {
        assertThatThrownBy(() ->
                new ResultLotto("1,2,3,4,5,6", ",", 6, "1", 1)
        )
                .isInstanceOf(IllegalResultLottoException.class);

    }

}