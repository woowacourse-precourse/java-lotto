package lotto.shell;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ShellTest {

    @Test
    public void 사용자_입력_정상동작(){
        //given
        List<String> consoleReadLine = List.of("8000", "1,2,3,4,5,6", "7");
        Shell shell = new Shell();

        //when
        shell.injectInOrder();

        //then
        assertEquals();
    }

    @Test
    public void 잘못된_값_입력() {

        String delimiter = "!@#";
        String string = "abc";

        assertThatThrownBy(() -> new Shell().receivedInteger())
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Shell().receivedInteger())
                .isInstanceOf(IllegalArgumentException.class);

    }
    @Test
    public void 특정_범위의_정수를_추출(){

        //given
        String insertLine = "1,2,3,4,5,6";
        List<Integer> assertList = List.of(1,2,3,4,5,6);

        //when
        List<Integer> result;
        result = new WinningNumber().buildWinningNumberList();

        //then
        assertEquals(assertList, result);

    }

    @Test
    public void 번호를_순서대로_저장(){
        //given
        List<String> stringList = Arrays.asList("8000", "1,2,3,4,5,6", "7");

        // when
        int amount;
        List<Integer> winningNumber;
        int bonusNumber;



        //then

    }
}