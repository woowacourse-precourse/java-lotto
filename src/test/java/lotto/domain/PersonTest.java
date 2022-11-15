package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @DisplayName("로또 구입 기능 테스트")
    @Test
    void from() {
        Person person = Person.from(6000);
        assertThat(person.toString().contains("6개")).isTrue();
    }

    @DisplayName("당첨 통계 테스트")
    @Test
    void matchResult() {
        Person person = generatePerson();
        WinningNumbers winningNumbers = generateWinningNumbers();
        Map<Rank, Integer> matchResult = person.matchResult(winningNumbers);

        assertThat(matchResult.get(Rank.OUT)).isEqualTo(3);
        assertThat(matchResult.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(matchResult.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(matchResult.get(Rank.THIRD)).isEqualTo(1);
        assertThat(matchResult.get(Rank.SECOND)).isEqualTo(0);
        assertThat(matchResult.get(Rank.FIRST)).isEqualTo(2);
    }
    
    @DisplayName("수익률 계산 테스트")
    @Test
    void yield() {
        Person person = generatePerson();
        WinningNumbers winningNumbers = generateWinningNumbers();
        Map<Rank, Integer> matchResult = person.matchResult(winningNumbers);

        double expected = (2_000_000_000L + 2_000_000_000 + 1_500_000 + 50000 + 5000) * 100.0 / 8000;
        assertThat(person.yield(matchResult)).isEqualTo(expected);
    }

    private Person generatePerson() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 5, 6, 10)),
                new Lotto(List.of(1, 2, 3, 6, 40, 41)),
                new Lotto(List.of(1, 5, 6, 10, 20, 30)),
                new Lotto(List.of(1, 6, 8, 9, 10, 11)),
                new Lotto(List.of(1, 7, 8, 9, 10, 11)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        return Person.from(lottos);
    }

    private WinningNumbers generateWinningNumbers() {
        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        return new WinningNumbers(winningLottoNumbers, bonusNumber);
    }
}