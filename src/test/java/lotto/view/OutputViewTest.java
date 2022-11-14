package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    @DisplayName("당첨 결과를 제대로 출력 하는지 테스트")
    @Test
    void printResult(){
        int[] tempArray={0,1,2,1,1,1};
        OutputView.printResult(tempArray);
    }
}