package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class UserTest {
    @Test
    void setMoneyTest() {
        User testUser = new User();
        testUser.setMoney("10000");
        assertThat(testUser.getMoney()).isEqualTo(10000);
    }
    @Test
    void setWinningNumbersTest() {
        User testUser = new User();
        testUser.setWinningNumbers("1,2,3,4,5,6");
        assertThat(testUser.getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void setBonusNumberTest() {
        User testUser = new User();
        testUser.setBonusNumber("15");
        assertThat(testUser.getBonusNumber()).isEqualTo(15);
    }


    @Test
    void informProfit() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        User testUser = new User();
        testUser.setMoney("10000");
        testUser.informProfit();
        assertThat(out.toString()).isEqualTo("총 수익률은 87.5%입니다.");

    }
}