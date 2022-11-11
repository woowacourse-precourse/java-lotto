package lotto;

import lotto.validate.LottoValidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @Test
    public void numberDuplicateTest() throws Exception{
        assertThatThrownBy(() -> lottoValidate.validate(List.of(1, 1, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    public void numberRangeTest() throws Exception{
        assertThatThrownBy(() -> lottoValidate.validate(List.of(46, 1, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);

    }
}