package lotto;

import lotto.domain.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    NumberGenerator generator;
    @BeforeEach
    void setUp() {
        generator = new NumberGenerator();
    }

    @Test
    @DisplayName("로또번호 List를 생성하고 크기는 6이다.")
    void 랜덤으로_로또번호_생성_테스트() {
        assertThat(generator.createDuplicateNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("중복되지 않는 로또번호 List를 생성하고 크기는 6이다.")
    void 랜덤으로_중복되지않는_숫자리스트_생성_테스트() {
        Set<Integer> set = new HashSet<>(generator.createDuplicateNumbers());
        assertThat(set.size()).isEqualTo(6);
    }
}
