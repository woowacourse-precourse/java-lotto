package lotto.domain;

import lotto.controller.ProcessingGameData;
import lotto.model.GameDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ProcessGameDateTest {
    @DisplayName("데이터 프로세스를 통해서 총수익과 수익률 계산이 잘되는지 체크")
    @Test
    void makeRatioTest() {
        GameDTO gameDTO = new GameDTO();
        int amount = 100000;
        int cost = 20000;
        gameDTO.setPurchaseAmount(cost);
        gameDTO.setWinningCount("FOUR");
        gameDTO.setWinningCount("FOUR");
        ProcessingGameData process = new ProcessingGameData(gameDTO);
        float ratio = ((float)amount / (float)cost) * 100;

        String expected = Float.toString(ratio);
        assertAll(
            () -> assertThat(gameDTO.getReturnOfRate()).isEqualTo(expected),
            () -> assertThat(gameDTO.getWinningAmount()).isEqualTo(amount)
        );
    }
}
