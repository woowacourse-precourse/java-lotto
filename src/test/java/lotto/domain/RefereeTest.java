package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    Referee referee;
    LottoGenerator generator;

    @DisplayName("결과 인스턴스를 반환하는지 테스트합니다.")
    @Test
    void 결과_인스턴스_반환_테스트() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;

        generator = new LottoGenerator();
        referee = new Referee(generator.generate(5000), winNumbers, bonusNum);
        assertThat(referee.compare()).isExactlyInstanceOf(Result.class);
    }
}
