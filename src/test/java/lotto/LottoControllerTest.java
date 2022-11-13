package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {
    static LottoController lottoController;
    @BeforeAll
    static void init(){
        LottoService lottoService = new LottoService(
                List.of(1,2,3,4,5,6), 7
        );
        lottoController = new LottoController(lottoService);
    }
    @Test
    void purchaseLotto() {
        //given
        String inputAmount = "8000";
        //when
        int number = lottoController.purchaseLotto(inputAmount).size();
        //then
        assertEquals(8, number);
    }

    @Test
    @DisplayName("1000원 단위로 구매하지 않았을 때 에러가 발생하는지 확인한다.")
    void purchaseLotto_exception1() {
        //given
        String inputAmount = "8555";
        boolean exceptionCatch = false;
        //when
        try {
            int number = lottoController.purchaseLotto(inputAmount).size();
        } catch (RuntimeException e){
            exceptionCatch = true;
        }
        //then
        assertEquals(true, exceptionCatch);
    }

    @Test
    @DisplayName("1000원 미만의 금액이 들어왔을 때 에러가 발생하는지 확인한다.")
    void purchaseLotto_exception2() {
        //given
        String inputAmount = "500";
        boolean exceptionCatch = false;
        //when
        try {
            int number = lottoController.purchaseLotto(inputAmount).size();
        } catch (RuntimeException e){
            exceptionCatch = true;
        }
        //then
        assertEquals(true, exceptionCatch);
    }

    @Test
    @DisplayName("문자열이 들어왔을 때 에러가 발생하는지 확인한다.")
    void purchaseLotto_exception3() {
        //given
        String inputAmount = "2000j";
        boolean exceptionCatch = false;
        //when
        try {
            int number = lottoController.purchaseLotto(inputAmount).size();
        } catch (RuntimeException e){
            exceptionCatch = true;
        }
        //then
        assertEquals(true, exceptionCatch);
    }
}