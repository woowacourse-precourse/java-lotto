package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class LottoUITest {

    @DisplayName("문작 입력되었을 떄")
    @Test
    void stringInput() throws Exception {
        //Given
        LottoUI lottoUI = new LottoUI(new Manager());
        System.setIn(new ByteArrayInputStream("1,a,3,4,5,6".getBytes()));

        //When
        assertThatThrownBy(() -> lottoUI.getLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실수가 입력됬을때")
    @Test
    void floatInput() throws Exception {
        //Given
        LottoUI lottoUI = new LottoUI(new Manager());
        System.setIn(new ByteArrayInputStream("1,1.1,3,4,5,6".getBytes()));

        //When
        assertThatThrownBy(() -> lottoUI.getLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}