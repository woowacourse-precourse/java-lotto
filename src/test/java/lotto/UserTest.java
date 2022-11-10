package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    private User user;
    
    @BeforeEach
    void init(){
        user = new User();
    }
    
    @Test
    @DisplayName("사용자 금액 입력 검사")
    void validateInputNumberTest(){
        assertThatThrownBy(() -> user.validDataInputNumber(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("String -> List<Integer> 검사")
    void convertLottoNumberTest(){
        List<Integer> testNumber = List.of(1, 2, 3, 4, 5, 6);
        String testValue = "1, 2, 3, 4, 5, 6";
        assertThat(testNumber).isEqualTo(user.convertLottoNumber(testValue));
    }

    @Test
    @DisplayName("사용자 로또 입력 검사")
    void validateInputLottoNumber(){
        assertThatThrownBy(() -> user.validDataInputLottoNumber("ababba1324"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> user.validDataInputLottoNumber("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> user.validDataInputLottoNumber("2, 2, 6, 8, 10, 46"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> user.validDataInputLottoNumber("1, 2, 6, 8, 10, 46"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("보너스 번호 입력 검사")
    void validDataBonusNumberTest(){
        assertThatThrownBy(() -> user.validDataBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> user.validDataBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(user.validDataBonusNumber("3")).isEqualTo(3);
    }
}
