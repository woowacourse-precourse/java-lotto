package lotto;

import domain.WinningNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningNumberTest {

    @Test
    public void 당첨번호숫자인지확인() throws Exception{
        //given
        String input = "1,2,3,4,5,a";
        int num = 6;
        //when
        WinningNumber winningNumber = new WinningNumber();
        //then
        try{
            winningNumber.notNumber(input);
        }catch (Exception e){
            System.out.println(e);
        }
        assertThrows(IllegalArgumentException.class, () -> winningNumber.notNumber(input));
    }
}
