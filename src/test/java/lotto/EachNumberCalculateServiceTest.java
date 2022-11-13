package lotto;

import java.util.LinkedList;
import java.util.List;
import lotto.domain.EachLotteryCalculateService;
import lotto.model.Lotto;
import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EachNumberCalculateServiceTest {
    EachLotteryCalculateService eachNumberCalculateService;

    EachNumberCalculateServiceTest(){
        List<Integer> lotteryNumbers = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottery = new Lotto(lotteryNumbers);
        eachNumberCalculateService = new EachLotteryCalculateService(lottery, 45);
    }

    @DisplayName("로또 숫자 0개 일치 테스트")
    @Test
    void 로또_숫자_0개_일치_테스트(){
        Lotto lottery = new Lotto(new LinkedList<>(List.of(7, 10, 11, 16, 22, 43)));
        assertEquals(0, eachNumberCalculateService.howManyMatchesNumber(lottery));
    }

    @DisplayName("로또 숫자 3개 일치 테스트")
    @Test
    void 로또_숫자_3개_일치_테스트(){
        Lotto lottery = new Lotto(new LinkedList<>(List.of(1, 5, 6, 23, 27, 42)));
        assertEquals(3, eachNumberCalculateService.howManyMatchesNumber(lottery));
    }

    @DisplayName("로또 숫자 6개 일치 테스트")
    @Test
    void 로또_숫자_6개_일치_테스트(){
        Lotto lottery = new Lotto(new LinkedList<>(List.of(1, 2, 3, 4, 5, 6)));
        assertEquals(6, eachNumberCalculateService.howManyMatchesNumber(lottery));
    }

    @DisplayName("로또 당첨 실패 테스트")
    @Test
    void 로또_당첨_실패_테스트(){
        Lotto lottery = new Lotto(new LinkedList<>(List.of(7, 10, 11, 16, 22, 43)));
        assertThat(eachNumberCalculateService.calculate(lottery))
                .isEqualTo(Rank.NOT_WINNER);
    }

    @DisplayName("로또 3등 테스트")
    @Test
    void 로또_3등_테스트(){
        Lotto lottery = new Lotto(new LinkedList<>(List.of(1, 2, 3, 4, 5, 7)));
        assertThat(eachNumberCalculateService.calculate(lottery))
                .isEqualTo(Rank.THIRD_RANK);
    }

    @DisplayName("로또 2등 테스트")
    @Test
    void 로또_2등_테스트(){
        Lotto lottery = new Lotto(new LinkedList<>(List.of(1, 2, 3, 4, 5, 45)));
        assertThat(eachNumberCalculateService.calculate(lottery))
                .isEqualTo(Rank.SECOND_RANK);
    }

    @DisplayName("로또 1등 테스트")
    @Test
    void 로또_1등_테스트(){
        Lotto lottery = new Lotto(new LinkedList<>(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(eachNumberCalculateService.calculate(lottery))
                .isEqualTo(Rank.FIRST_RANK);
    }

}
