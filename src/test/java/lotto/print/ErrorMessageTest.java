package lotto.print;

import lotto.exception.InputSixDigitException;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class ErrorMessageTest {
    @Test
    void findTest(){
        assertThat(ErrorMessage.INPUT_OVER).isEqualTo(ErrorMessage.find("InputOver"));
    }//find Test

    @Test
    void sendMessageTest() {
        String message = ErrorMessage.sendMessage(new InputSixDigitException());
        assertThat(message).contains(" 로또 입력 개수가 초과하였습니다.").contains("[ERROR]");
    }//sendMessageTest
}//end class
