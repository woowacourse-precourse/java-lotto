package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SaturdayTest {

    @DisplayName("입력받은 값이 정규식과 다를때 Exception 발생")
    @Test
    void testValidateStrInput(){
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6,7","3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saturday("WangJunYoung is Best Developer","3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6","0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6","100"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6","I Love Woowacourse"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("입력받은 값의 오류가 있을때 Exception 발생")
    @Test
    void testValidateIntInput(){
        //45를 넘는 수 입력
        assertThatThrownBy(() -> new Saturday("46,55,77,4,3,2","3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6","46"))
                .isInstanceOf(IllegalArgumentException.class);

        //bonus와 win 에 포함되어 있을때
        assertThatThrownBy(() -> new Saturday("1,2,3,4,5,6","6"))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
