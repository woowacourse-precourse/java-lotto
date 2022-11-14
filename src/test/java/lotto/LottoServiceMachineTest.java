package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceMachineTest {
    LottoServiceMachine testMachine = new LottoServiceMachine();
    @DisplayName("로또 번호의 개수가 6개가 아니라면 예외가 발생한다.")
    @Test
    void createByOverSize() {
       assertThatThrownBy(
               ()->{
                   testMachine.splitLottoInput("1,2,3,4,5",6);
               }
       ).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName(",로 나뉜 값이 숫자가 아니라면 예외 발생")
    @Test
    void createByNotNumber() {
        assertThatThrownBy(
                ()->{
                    testMachine.splitLottoInput("1+,2,3,4,5,6",6);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호가 정상 범위가 아니라면 예외 발생.")
    @Test
    void createByNotInRange() {
        assertThatThrownBy(
                ()->{
                    testMachine.splitLottoInput("1,2,3,4,5,46",6);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호가 중복이면 예외 발생.")
    @Test
    void createByDuplicate() {
        assertThatThrownBy(
                ()->{
                    testMachine.splitLottoInput("1,2,3,4,5,5",6);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스로또 번호가 기존과 중복이면 예외 발생.")
    @Test
    void createByDuplicateWithinNormalAndBonus() {
        assertThatThrownBy(
                ()->{
                    String input = "1,2,3,4,5,5";
                    InputStream is = new ByteArrayInputStream(input.getBytes());
                    testMachine.getWinningLottoNumber();
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }


}
