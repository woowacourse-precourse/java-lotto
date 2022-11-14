package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManagerTest {
    Manager manager;
    @BeforeEach
    void initiateManagerTest(){
        manager = new Manager();
    }
    @DisplayName("로또 구입 금액으로 문자열 8000을 입력하면 정수형 8000이 반환된다.")
    @Test
    void inputMoney() {
        String input = "8000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = manager.inputMoney();
        int expect = 8000;
        assertThat(result).isEqualTo(expect);
    }
    @DisplayName("로또 구입 금액으로 숫자가 아닌 값이 입력되면 예외 발생")
    @Test
    void inputMoneyException() {
        String input = "8000a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            manager.inputMoney();
        });
    }

    @Test
    void inputLottoNumber() {
    }

    @Test
    void inputBonusNumber() {
    }

    @Test
    void compareNumber() {
    }
    @DisplayName("3개가 같은 로또 번호배열 비교하여 같은 개수 3을 반환")
    @Test
    void countSameNumber() {
        List<Integer> from = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> to = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        int result = manager.countSameNumber(from, to);
        int expect = 3;
        assertThat(result).isEqualTo(expect);
    }
    @DisplayName("수익률 계산")
    @Test
    void calculateYield() {
        int money = 8000;
        int [] result = {1, 0, 0, 0, 0}; // 3등 하나 당첨
        double expect = 62.5;
        assertThat(manager.calculateYield(money, result)).isEqualTo(expect);
    }
}