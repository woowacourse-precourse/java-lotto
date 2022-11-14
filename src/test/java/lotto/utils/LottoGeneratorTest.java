package lotto.utils;

import static lotto.utils.LottoGenerator.COUNT;
import static lotto.utils.LottoGenerator.END_INCLUSIVE;
import static lotto.utils.LottoGenerator.START_INCLUSIVE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private static final List<Integer> STANDARD_LOTTO_NUMBER = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .boxed().collect(Collectors.toList());
    List<Integer> lottoNumber;


    @BeforeEach
    void setUp() {
        lottoNumber = LottoGenerator.makeLotto();
    }

    @DisplayName("랜덤번호를 생성하면 여섯자리가 생성된다.")
    @Test
    void createRandomNumbersSizeIsSix() {
        assertThat(lottoNumber.size()).isEqualTo(COUNT);
    }
    @DisplayName("랜덤번호를 생성하면 중복된 값이오지않는다.")
    @Test
    void createRandomNumberCheckDuplication() {
        assertThat(new HashSet<>(lottoNumber).size()).isEqualTo(lottoNumber.size());
    }

    @DisplayName("랜덤번호를 생성하면 1~45 사이의 번호만 생성된다.")
    @Test
    void createRandomNumberCheckRange() {
        lottoNumber.stream().map(STANDARD_LOTTO_NUMBER::contains).forEach(Assertions::assertTrue);
    }
}