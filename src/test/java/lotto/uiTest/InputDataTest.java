package lotto.uiTest;


import lotto.ui.InputData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputDataTest {
    InputData inputData = new InputData();

    @Test
    @DisplayName("콘솔 입력 잘 받아오는지")
    public void readInput() {
        System.out.println(inputData.readInput());
    }
}
