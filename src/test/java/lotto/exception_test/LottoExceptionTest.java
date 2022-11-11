package lotto.exception_test;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class LottoExceptionTest {

    LottoException lottoException;

    @BeforeEach
    void initializeClass(){
        lottoException = new LottoException();
    }

    @DisplayName("입력 리스트의 길이가 6이 아니면 예외처리")
    @Test
    void checkLengthException(){
        assertThatThrownBy(() -> lottoException.validate(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 리스트에 같은 숫자가 있으면 예외처리")
    @Test
    void checkSameNumberException(){
        assertThatThrownBy(() -> lottoException.validate(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 리스트 수의 범위가 1부너 45가 아니면 예외처리")
    @Test
    void checkNumberRangeException(){
        assertThatThrownBy(() -> lottoException.validate(List.of(1, 2, 3, 4, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
