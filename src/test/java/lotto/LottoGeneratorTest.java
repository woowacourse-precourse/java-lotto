package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @DisplayName("랜덤 넘버로 로또 생성시 Lotto의 예외 조건 안걸리는지 확인 반복 테스트")
    @RepeatedTest(100)
    void randomNumberRangeTest() throws Exception {
        assertThatCode(() -> LottoGenerator.generatorLotto())
                .doesNotThrowAnyException();
    }
}