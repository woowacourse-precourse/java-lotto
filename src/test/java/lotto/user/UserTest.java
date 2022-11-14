package lotto.user;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void 유저_미입력_테스트() {
        User user = new User();

        assertThrows(IllegalArgumentException.class, () -> user.getInput());
    }

    @Test
    void 정수_정상_형식_테스트() {
        UserValidator validator = new UserValidator();
        validator.validateInteger("1234");
    }

    @Test
    void 정수_비정상_형식_테스트() {
        UserValidator validator = new UserValidator();


        assertThrows(IllegalArgumentException.class, () -> validator.validateInteger("1234u"));
    }

    @Test
    void 돈_단위_테스트() {
        UserValidator validator = new UserValidator();


        validator.validateUnit(1000);
    }

    @Test
    void 돈_비정상_단위_테스트() {
        UserValidator validator = new UserValidator();

        assertThrows(IllegalArgumentException.class, () -> validator.validateUnit(1010));
    }
}