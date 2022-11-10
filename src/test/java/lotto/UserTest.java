package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    private User user;
    
    @BeforeEach
    void init(){
        user = new User();
    }
    
    @Test
    @DisplayName("사용자 로또 입력이 제대로 되었는지 검사한다.")
    void validateInputNumberTest(){
        assertThatThrownBy(() -> user.validateInputNumber(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("String이 List<Integer>로 잘 변환되는지 검사")
    void convertLottoNumberTest(){
        List<Integer> testNumber = List.of(1, 2, 3, 4, 5, 6);
        String testValue = "1, 2, 3, 4, 5, 6";
        assertThat(testNumber).isEqualTo(user.convertLottoNumber(testValue));
    }
}
