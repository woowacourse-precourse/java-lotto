package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Function.Checker;
import lotto.Function.Generator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void winningNumInput() {
        Controller controller = new Controller();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(list, controller.changeWinningNumbers("1,2,3,4,5"));
    }

    @Test
    void showBuy() {
        Generator generator = new Generator();
        User user = new User();
        user.setUserLottoNumber(generator.makeNumbers(3));
        System.out.println(user.getUserLottoNumber());
    }

    @Test
    void checking() {
        User user = new User();
        List<Integer>list_01 = Arrays.asList(1,2,3,4,5);
        List<Integer>list_02 = Arrays.asList(1,2,3,4,5);
        Checker checker = new Checker(list_01, list_02);
        int checkNum = checker.winningNumCheck();
        user.userMatchNumber.add(checkNum);
        System.out.println(user.userMatchNumber);
    }
}