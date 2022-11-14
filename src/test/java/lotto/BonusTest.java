package lotto;

import domain.BonusNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusTest {

    private BonusNumber bonusNumber = new BonusNumber();

    @Test
    public void 보너스번호개수검증() throws Exception{
        //given
        String input = "1,2";

        //when
        try{
            bonusNumber.numberCount(input);
        }catch (Exception e){
            System.out.println(e);
        }
        //then
        assertThrows(IllegalArgumentException.class, () -> bonusNumber.numberCount(input));
    }

    @Test
    public void 보너스번호숫자인지검증() throws Exception{
        //given
        String input = "a";

        //when
        try{
            bonusNumber.notNumber(input);
        }catch (Exception e){
            System.out.println(e);
        }
        //then
        assertThrows(IllegalArgumentException.class, () -> bonusNumber.notNumber(input));
    }
}
