package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {
    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void 로또_랜덤_자동번호_생성_테스트() {
        List<Lotto> quickPick = numberGenerator.getQuickPick(2000);
        int size = quickPick.size();

        assertThat(size).isEqualTo(2);

    }

}