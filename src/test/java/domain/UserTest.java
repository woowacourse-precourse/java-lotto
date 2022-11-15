package domain;

import controller.Controller;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static Controller controller;
    @BeforeAll
    static void init(){
        controller = new Controller();
    }
    @DisplayName("금액 입력 천원 단위가 아니면 예외가 발생한다.")
    @Test
    void checkInputMoneyUnit(){
        assertThatThrownBy(() -> new User(1500,1500/1000,controller.createTotalNumbers(7))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유저의 로또가 금액에 맞는 개수인지 확인한다.")
    @Test
    void checkTotalNumbersSize(){
        int inputMoney = 9000;
        int totalCount = inputMoney/1000;
        User user = new User(inputMoney, totalCount, controller.createTotalNumbers(totalCount));
        assertEquals(inputMoney/1000, user.getTotalNumbers().size());
    }
}