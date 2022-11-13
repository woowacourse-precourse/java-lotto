package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class LotterySellServiceTest {
    static LotterySellService lotterySellService = new LotterySellService();
    static final int LOTTERY_NUMBER_LENGTH = 6;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;

    @DisplayName("유효한 " + LOTTERY_NUMBER_LENGTH + "개의 로또 번호로 로또 티켓을 생성한다.")
    @Test
    void createLotteryTicketByValidNumbers() {
        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                .thenReturn(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotterySellService.createLotteryTicket().getNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        mock.close();
    }

    @DisplayName("중복이 있는 " + LOTTERY_NUMBER_LENGTH + "개의 로또 번호로 로또 티켓을 생성시 에러가 발생한다.")
    @Test
    void createLotteryTicketByDuplicateNumbers() {
        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                .thenReturn(List.of(1, 2, 3, 4, 4, 6));

        assertThatThrownBy(() -> lotterySellService.createLotteryTicket())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
        mock.close();
    }

    @DisplayName(MIN_NUMBER + "부터 " + MAX_NUMBER + " 이외의 " + LOTTERY_NUMBER_LENGTH + "개의 로또 번호로 로또 티켓을 생성시 에러가 발생한다.")
    @Test
    void createLotteryTicketByOutOfRangeNumbers() {
        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                .thenReturn(List.of(1, 2, 3, 100, 4, 6));

        assertThatThrownBy(() -> lotterySellService.createLotteryTicket())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45까지의");
        mock.close();
    }
}
