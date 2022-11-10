package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidateTest {
    private static LottoValidate lottoValidate;
    @BeforeEach
    public void beforeEach(){
        lottoValidate = new LottoValidate();
    }
    @Test
    public void numberSizeTest() throws Exception{
        assertThatThrownBy(() -> lottoValidate.validate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);

    }
}