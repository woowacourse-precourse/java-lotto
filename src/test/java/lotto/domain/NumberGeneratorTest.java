package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {
    private static final int EXPECTED_LIST_SIZE = 6;
    private NumberGenerator numberGenerator;

    //중복인지, 6자리인지, 정렬
    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    @DisplayName("중복 요소가 존재하는지 테스트")
    void 중복요소_확인_테스트() {
        List<Integer> result = numberGenerator.createRandomNumbers();
        Set<Integer> filter = new HashSet<>(result);
        assertThat(filter.size()).isEqualTo(EXPECTED_LIST_SIZE);
    }

    @Test
    @DisplayName("6자리 리스트를 리턴해주는지 테스트")
    void 리스트_사이즈_테스트() {
        List<Integer> result = numberGenerator.createRandomNumbers();
        int resultSize = result.size();
        assertThat(resultSize).isEqualTo(EXPECTED_LIST_SIZE);
    }

}