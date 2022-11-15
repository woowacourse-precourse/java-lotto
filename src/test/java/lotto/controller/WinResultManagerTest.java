package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.LottoStorage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinResultManagerTest {
    @DisplayName("각 티켓별 당첨 번호와 비교한 결과 확인")
    @Test
    void findCorrectedNumbersWithWin() {
        List<List<Integer>> tickets = new ArrayList<>();
        int bonus = 38;
        tickets.add(Arrays.asList(8,21,23,41,42,43));
        tickets.add(Arrays.asList(3,5,11,16,32,38));
        List<Integer> winNumbers = new ArrayList<>(Arrays.asList(3,5,8,11,16,32));
        List<CorrectNumber> expected = new ArrayList<>(Arrays.asList(CorrectNumber.FIVE_BONUS));
        assertThat(WinResultManager.getCorrectedNumbersWithWin(tickets, winNumbers, bonus)).isEqualTo(expected);
    }
}
