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
        String winningNumInput = "1,2,3,4,56";

        List<String> winningNumList = InputView.revertInputToList(winningNumInput);

        assertThat(winningNumList).isEqualTo(Arrays.asList("1","2","3","4","56"));
    }
}