package lotto;

import domain.UserMoneyValidate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserMoneyTest {
    private UserMoneyValidate userMoneyValidate = new UserMoneyValidate();

    @Test
    public void 유저입력돈이숫자인가요() throws Exception{
        //given
        String testInput = "1000j";
        UserMoneyValidate userMoneyValidate = new UserMoneyValidate();

        int num = testInput.charAt(0);
        System.out.println(num);
        //when
        try{
            userMoneyValidate.notNumber(testInput);
        }catch (Exception e){
            System.out.println(e);
        }
        //then
        assertThrows(IllegalArgumentException.class,  ()-> userMoneyValidate.notNumber(testInput));
    }

    @Test
    public void 유저입력돈이양수인가요() throws Exception{
        //given
        String testInput = "-10000";
        int testMoney = userMoneyValidate.convertStringToInt(testInput);
        //when
        try{
            userMoneyValidate.negativeNumber(testMoney);
        }catch (Exception e){
            System.out.println(e);
        }
        //then
        assertThrows(IllegalArgumentException.class, () -> userMoneyValidate.negativeNumber(testMoney));
    }

    @Test
    public void 유저입력돈이1000원으로나누어떨어지나요() throws Exception{
        //given
        String testInput = "10001";
        int testMoney = userMoneyValidate.convertStringToInt(testInput);
        //when
        try{
            userMoneyValidate.isDivideThousand(testMoney);
        }catch (Exception e){
            System.out.println(e);
        }
        //then
        assertThrows(IllegalArgumentException.class, () -> userMoneyValidate.isDivideThousand(testMoney));
    }

}
