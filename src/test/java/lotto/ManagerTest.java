package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

    @Test
    void generator() {
    }

    @Test
    void generateLotto() {
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

    @Test
    void countSameNumber() {
    }

    @Test
    void calculateYield() {
    }
}