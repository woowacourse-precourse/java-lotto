package lotto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("로또 당첨번호 입력값 ',' 제거")
    void revertInputToList() {
        String winningNumInput2 = "1,2,3,4,5,6";

        List<Integer> winningNumList2 = InputView.revertInputToList(winningNumInput2);

        assertThat(winningNumList2).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}