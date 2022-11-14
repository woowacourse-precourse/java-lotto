package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LottoStatsTest {
    @Test
    @DisplayName("내로또와 당첨 로또 ,보너스 번호로 테스트 - 1등 ")
    public void statsTest1() throws Exception{

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winning = new Lotto(List.of(1,2,3,4,5,6));
        Integer bonus = 7;
        Optional<StatsType> optionalStatsType = compareLotto(lotto, winning, bonus);
        Assertions.assertThat(optionalStatsType.isPresent()).isTrue();
        StatsType statsType = optionalStatsType.get();
        Assertions.assertThat(statsType).isEqualTo(StatsType.first);
    }
    @Test
    @DisplayName("내로또와 당첨 로또 ,보너스 번호로 테스트 - 2등 ")
    public void statsTest2() throws Exception{

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        Lotto winning = new Lotto(List.of(1,2,3,4,5,9));
        Integer bonus = 7;
        Optional<StatsType> optionalStatsType = compareLotto(lotto, winning, bonus);
        Assertions.assertThat(optionalStatsType.isPresent()).isTrue();
        StatsType statsType = optionalStatsType.get();
        Assertions.assertThat(statsType).isEqualTo(StatsType.second);
    }

    @Test
    @DisplayName("내로또와 당첨 로또 ,보너스 번호로 테스트 - 3등 ")
    public void statsTest3() throws Exception{

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,20));
        Lotto winning = new Lotto(List.of(1,2,3,4,5,9));
        Integer bonus = 7;
        Optional<StatsType> optionalStatsType = compareLotto(lotto, winning, bonus);
        Assertions.assertThat(optionalStatsType.isPresent()).isTrue();
        StatsType statsType = optionalStatsType.get();
        Assertions.assertThat(statsType).isEqualTo(StatsType.third);
    }

    @Test
    @DisplayName("내로또와 당첨 로또 ,보너스 번호로 테스트 - 4등 ")
    public void statsTest4() throws Exception{

        Lotto lotto = new Lotto(List.of(1,2,3,4,21,20));
        Lotto winning = new Lotto(List.of(1,2,3,4,5,9));
        Integer bonus = 7;
        Optional<StatsType> optionalStatsType = compareLotto(lotto, winning, bonus);
        Assertions.assertThat(optionalStatsType.isPresent()).isTrue();
        StatsType statsType = optionalStatsType.get();
        Assertions.assertThat(statsType).isEqualTo(StatsType.four);
    }

    @Test
    @DisplayName("내로또와 당첨 로또 ,보너스 번호로 테스트 - 5등 ")
    public void statsTest5() throws Exception{

        Lotto lotto = new Lotto(List.of(1,2,3,45,21,20));
        Lotto winning = new Lotto(List.of(1,2,3,4,5,9));
        Integer bonus = 7;
        Optional<StatsType> optionalStatsType = compareLotto(lotto, winning, bonus);
        Assertions.assertThat(optionalStatsType.isPresent()).isTrue();
        StatsType statsType = optionalStatsType.get();
        Assertions.assertThat(statsType).isEqualTo(StatsType.five);
    }
    @Test
    @DisplayName("내로또와 당첨 로또 ,보너스 번호로 테스트 - 낙점 ")
    public void statsTestNone() throws Exception{

        Lotto lotto = new Lotto(List.of(11,12,22,45,21,20));
        Lotto winning = new Lotto(List.of(1,2,3,4,5,9));
        Integer bonus = 7;
        Optional<StatsType> optionalStatsType = compareLotto(lotto, winning, bonus);
        Assertions.assertThat(optionalStatsType.isPresent()).isFalse();

    }

    private Optional<StatsType> compareLotto(Lotto lotto, Lotto winningNumber, Integer bonus){
        Long score = lotto.sameNumber(winningNumber,bonus);
        return Arrays.stream(StatsType.values())
                .filter(type -> type.getScore() == score)
                .findFirst();
    }

}