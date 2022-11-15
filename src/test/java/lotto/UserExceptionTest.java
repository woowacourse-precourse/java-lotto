package lotto;

import java.util.NoSuchElementException;
import lotto.exception.UserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class UserExceptionTest {

    UserException userException;

    @BeforeEach
    void createConstructor(){
        userException = new UserException();
    }

    @DisplayName("checkLottoPriceDividedByOneThousand 테스트")
    @Test
    void checkLottoPriceDividedByOneThousandTest(){
        assertThatThrownBy(()-> userException.checkLottoPriceDividedByOneThousand("999"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("checkUserLottoPriceAboutOnlyNumbers 테스트")
    @Test
    void checkUserLottoPriceAboutOnlyNumbersTest(){
        assertThatThrownBy(()-> userException.checkUserLottoPriceAboutOnlyNumbers("abc"))
                .isInstanceOf(NoSuchElementException.class);
    }

}
