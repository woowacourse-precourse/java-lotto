package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserServiceTest {
    UserServiceImpl userService;
    private static final String ERROR_MESSAGE = "[ERROR]";

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

    @DisplayName("사용자가 입력한 당첨 번호를 유효한 로또의 형태로 잘 받아오는지 확인한다.")
    @Test
    void getUserNumsTest() {
        String userInput = "1,2,3,4,5,6";

        List<Integer> testOfGetUserNums = userService.getUserNums(userInput);
        List<Integer> resultOfGetUserNums = List.of(1,2,3,4,5,6);

        assertThat(testOfGetUserNums).isEqualTo(resultOfGetUserNums);
    }

    @DisplayName("사용자가 입력한 당첨 번호에 공백이 있다면 예외 처리한다.")
    @Test
    void getUserNumsTest_blank() {
        String userInput = "1,2,3,4,5, 6";

        assertThatThrownBy(() -> userService
                .getUserNums(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 공백을 입력한다면 예외 처리한다.")
    @Test
    void getUserNumsTest_nothing_has_input() {
        String userInput = "";

        assertThatThrownBy(() -> userService
                .getUserNums(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 숫자 외에 다른 문자를 입력한다면 예외 처리한다.")
    @Test
    void getUserNumsTest_not_number() {
        String userInput = "1,2,3,4,k,5";

        assertThatThrownBy(() -> userService
                .getUserNums(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 1-45 범위 외에 숫자를 입력한다면 예외 처리한다.")
    @Test
    void getUserNumsTest_out_of_range() {
        String userInput = "1,2,3,4,5,66";

        assertThatThrownBy(() -> userService
                .getUserNums(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 6개 미만의 숫자를 입력한다면 예외 처리한다.")
    @Test
    void getUserNumsTest_less_than_six() {
        String userInput = "1,2,3,4,5";

        assertThatThrownBy(() -> userService
                .getUserNums(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 6개 초과의 숫자를 입력한다면 예외 처리한다.")
    @Test
    void getUserNumsTest_more_than_six() {
        String userInput = "1,2,3,4,5,6,7";

        assertThatThrownBy(() -> userService
                .getUserNums(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }



    @DisplayName("사용자가 입력한 보너스가 숫자로 잘 변환되는지 확인한다.")
    @Test
    void getUserBonusTest() {
        String userBonus = "7";

        int testOfUserBonus = userService.getUserBonus(userBonus);
        int resultOfUserBonus = 7;

        assertThat(testOfUserBonus).isEqualTo(resultOfUserBonus);
    }

    @DisplayName("보너스 번호의 형태가 숫자가 아니면 예외 처리한다.")
    @Test
    void getUserBonusTest_invalid_form() {
        String userInput = "k";

        assertThatThrownBy(() -> userService
                .getUserBonus(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
