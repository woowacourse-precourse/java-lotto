package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {
    UserServiceImpl userService;

    @BeforeEach
    void beforeEach() {
        userService = new UserServiceImpl();
    }

    @DisplayName("구입 금액에 따른 로또의 개수가 맞는지 확인한다.")
    @Test
    void getCntOfLottoTest() {
        int payment = 15000;
        int cntOfLotto = 15;

        int resultOfTest = userService.getCntOfLotto(payment);

        assertThat(cntOfLotto).isEqualTo(resultOfTest);
    }
}
