package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputerTest {

    @DisplayName("로또 번호 string으로 받은 것 List에 넣기")
    @Test
    void changeStringToList() {

        Inputer inputer =new Inputer();

        assertEquals(inputer.lottoWinList("1,2,3,4,5,6"), List.of(1, 2, 3, 4, 5, 6));
    }


}