package lotto.shell;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShellTest {

    @BeforeEach
    void setter() {

        ArrayList<String> userInjectionList = new ArrayList<>();

        userInjectionList.add("8000");
        userInjectionList.add("13,14,16,38,42,45");
        userInjectionList.add("7");

        for (String injection : userInjectionList) {
            new Shell();
        }
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
        result = new WinningNumber().addWinningNumber();

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


        for (String iterator : stringList) {
            Shell shell = new Shell();
        }

        //then

    }
}