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

}
