package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchPairTest {

    @Test
    void calculateRanking() {
        Assertions.assertThat(new MatchPair(6,false)
                .calculateRanking()).isEqualTo(1);
        Assertions.assertThat(new MatchPair(5,true)
                .calculateRanking()).isEqualTo(2);
        Assertions.assertThat(new MatchPair(5,false)
                .calculateRanking()).isEqualTo(3);
        Assertions.assertThat(new MatchPair(3,false)
                .calculateRanking()).isEqualTo(5);

    }
}