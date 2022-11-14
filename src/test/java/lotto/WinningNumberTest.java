package lotto;

import domain.WinningNumber;
import exception.LottoExceptionType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningNumberTest {

    private WinningNumber winningNumber = new WinningNumber();

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

    @Test
    public void 당첨번호콤마확인() throws Exception{
        //given
        String input = "1,2,3,4,5/6";
        WinningNumber winningNumber = new WinningNumber();
        //when
        //then
        try{
            winningNumber.notComma(input);
        }catch (Exception e){
            System.out.println(e);
        }
        assertThrows(IllegalArgumentException.class, () -> winningNumber.notComma(input));
    }

    @Test
    public void 당첨번호리스트로변환() throws Exception{
        //given
        List<Integer> list = List.of(1,2,3,5,6,7);
        String input = "1,2,3,5,6,7";

        //when
        List<Integer> test = winningNumber.convertStringToList(input);

        //then
        assertEquals(list, test);
    }

    @Test
    public void 당첨번호개수검증() throws Exception{
        //given
        List<Integer> list = List.of(1,2,3,4,5);
        //when
        try{
            winningNumber.numberCount(list);
        }catch (Exception e){
            System.out.println(e);
        }
        //then
        assertThrows(IllegalArgumentException.class, () -> winningNumber.numberCount(list));
    }
}
