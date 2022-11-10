package lotto;

import Service.LottoService;
import domain.UserMoneyValidate;
import exception.MoneyExceptionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserMoneyTest {

    @Test
    public void 유저입력돈이숫자인가요() throws Exception{
        //given
        String testInput = "1000ㅅ";
        UserMoneyValidate userMoneyValidate = new UserMoneyValidate();
        //when
        try{
            userMoneyValidate.notNumber(testInput);
        }catch (Exception e){
            System.out.println(e);
        }
        //then
        assertThrows(IllegalArgumentException.class,  ()-> userMoneyValidate.notNumber(testInput));
    }
}
