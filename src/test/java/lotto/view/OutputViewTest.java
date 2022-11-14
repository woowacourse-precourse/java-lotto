package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    @Test
    void 당첨_결과_리스트_출력_테스트(){
        int[] tempArray={0,1,2,1,1,1};
        OutputView.printResult(tempArray);
    }

    @Test
    void 수익률_출력_테스트(){
        OutputView.printRateOfReturn(8000,5_000);
    }
}