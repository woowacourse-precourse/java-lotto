package lotto.insert;


import static org.assertj.core.api.Assertions.*;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ShellTest {


    @Test
    public void 쉼표_제거(){
        //given
        String insertLine = "1,2,3,4,5,6";
        String replace = insertLine.replace(",", "");
        List<Integer> result = new ArrayList<>();
        List<Integer> assertList = new ArrayList<>();

        //when
        char[] separate = replace.toCharArray();

        for (int index = 1; index <= 6; index++) {
            assertList.add(index);
        }
        for (char character : separate) {
            result.add((int) character);
        }

        //then
        Assertions.assertThat(result).isEqualTo(assertList);
    }
}