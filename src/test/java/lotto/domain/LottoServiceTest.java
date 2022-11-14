package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("발생한 로또 오름차순 정렬 테스트")
    void sortedLottoNumbersTest() {

        List<Integer> lottoNumbers = Arrays.asList(21, 34, 5, 22, 47, 43);

        lottoService.sortedLottoNumbers(lottoNumbers);

        assertThat(lottoNumbers).isEqualTo(Arrays.asList(5, 21, 22, 34, 43, 47));
    }

    @Test
    void 발행한_로또_유효성_검사_테스트() {
        final int testNumber = 100;

        for (int i = 0; i < testNumber; i++) {
            List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
            for (int j = 0; j < 6; j++) {
                if (lottoNumbers.get(j) < 1 || lottoNumbers.get(j) > 45) {
                    fail();
                }
            }
        }
    }

    @Test
    void 발행한_로또_번호_길이_테스트() {
        final int testNumber = 100;

        for (int i = 0; i < testNumber; i++) {
            List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
            assertThat(lottoNumbers.size()).isEqualTo(6);
        }
    }
}