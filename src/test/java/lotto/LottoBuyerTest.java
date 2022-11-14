package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBuyerTest  {
    LottoBuyer testMachine = new LottoBuyer();
    @DisplayName("simpleTest")
    @Test
    void simpleTest() {
        String i = "12000";
        InputStream is = new ByteArrayInputStream(i.getBytes());
        System.setIn(is);
        testMachine.getMoney();

        testMachine.buyLotto();
        ;
    }
    @DisplayName("money값이 로또 값으로 나누어 떨어지지 않으면 에러.")
    @Test
    void createNotDiv() {
       assertThatThrownBy(
               ()->{
                   String i = "123400";
                   InputStream is = new ByteArrayInputStream(i.getBytes());
                   System.setIn(is);
                   testMachine.getMoney();
               }
       ).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("money값이 음수라면 에러.")
    @Test
    void createByMinus() {
        assertThatThrownBy(
                ()->{
                    String i = "-12000";
                    InputStream is = new ByteArrayInputStream(i.getBytes());
                    System.setIn(is);
                    testMachine.getMoney();
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("money값이 숫자가 아니라면 에러.")
    @Test
    void createByOverSize() {
        assertThatThrownBy(
                ()->{
                    String i = "123,400";
                    InputStream is = new ByteArrayInputStream(i.getBytes());
                    System.setIn(is);
                    testMachine.getMoney();
                }
        ).isInstanceOf(IllegalArgumentException.class);

    }
}
