package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoUITest {

    @DisplayName("올바른 입력이 들어왔을 때")
    @Test
    void rightInput() throws Exception {
        //Given
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6".getBytes()));

        //When
        List<Integer> lottoNumber = LottoUI.getLottoNumber();

        //Then
        assertThat(lottoNumber).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("문작 입력되었을 떄")
    @Test
    void stringInput() throws Exception {
        //Given
        System.setIn(new ByteArrayInputStream("1,a,3,4,5,6".getBytes()));

        //When
        assertThatThrownBy(() -> LottoUI.getLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실수가 입력됬을때")
    @Test
    void floatInput() throws Exception {
        //Given
        System.setIn(new ByteArrayInputStream("1,1.1,3,4,5,6".getBytes()));

        //When
        assertThatThrownBy(() -> LottoUI.getLottoNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}