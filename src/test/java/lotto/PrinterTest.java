package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrinterTest {

    @DisplayName("각 등수를 몇 번씩 맞췄는지, 리스트로 반환한다.")
    @Test
    void generateAmountEachWinList() {

        List<Integer> winList = new ArrayList<>(Arrays.asList(3,5,7,6,4,2,1,4,2,6,4,2,6));

        List<Integer> amountEachWinList = new ArrayList<>(Arrays.asList(1,3,1,3,1));

        Printer printer = new Printer();

        assertEquals(printer.knowAmountEachWin(winList),amountEachWinList);


    }

}