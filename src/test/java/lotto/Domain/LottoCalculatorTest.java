package lotto.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCalculatorTest {
    private static LottoCalculator calculator;
    @BeforeEach
    void initAll(){
        calculator = new LottoCalculator();
    }

    @DisplayName("번호일치 체크기 동작 검증")
    @Test
    void getEqualNumberTest(){
        Lotto user = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoCalculator calculator = new LottoCalculator();
        assertThat(calculator.getEqualNumber(user, answer)).isEqualTo(6);

        Lotto user1 = new Lotto(List.of(12,26,34,3,4,2));
        Lotto answer1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(calculator.getEqualNumber(user1, answer1)).isEqualTo(3);
    }

    @DisplayName("보너스 체크기 동작 검증")
    @Test
    void hasBonusTest(){
        Lotto user = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(1);
        assertThat(calculator.hasBonus(user,bonus)).isTrue();
    }

    @DisplayName("하나의 로또 당첨체크기 동작 검증")
    @Test
    void lottoRankerTest(){
        Lotto user = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        Bonus bonus = new Bonus(6);
        assertThat(calculator.lottoRanker(user, answer,bonus)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("전체 로또 당첨체크기 동작 검증")
    @Test
    void lottoComparatorTest(){
        Lotto answer = new Lotto(List.of(8, 21, 23, 41, 42, 43));

        Lotto a = new Lotto(List.of(3, 5, 11, 16, 32, 38)); // 0 NONE
        Lotto b = new Lotto(List.of(21, 11, 5, 40, 42, 43)); // 3 FIFTH
        Lotto c = new Lotto(List.of(8, 21, 23, 41,1,2));// 4 FIRTH
        Lotto d = new Lotto(List.of(8, 21, 23, 41, 42,5));// 5 THIRD
//        Lotto e = new Lotto(List.of(8, 21, 23, 41, 42, 7)); // 5+보너스 SECOND
        Lotto f = new Lotto(List.of(8, 21, 23, 41, 42, 43)); // 6 FIRST

        LottoMaker maker = new LottoMaker();
        maker.setLottoTickets(a);maker.setLottoTickets(b);maker.setLottoTickets(c);maker.setLottoTickets(d);maker.setLottoTickets(f);

        List<Rank> rank = new ArrayList<>();
        rank.add(Rank.NONE);rank.add(Rank.FIFTH);rank.add(Rank.FIRTH);rank.add(Rank.SECOND);
//        rank.add(Rank.SECOND);
        rank.add(Rank.FIRST);

        Bonus bonus = new Bonus(3);

        assertThat(calculator.lottoComparator(maker, answer, bonus)).isEqualTo(rank);
    }
}
