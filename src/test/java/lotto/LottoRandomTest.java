package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoRandomTest {
    private static LottoRandom lottoRandom;

    @BeforeAll
    static void setUp() {
        lottoRandom = new LottoRandom();
    }

    @DisplayName("로또 번호 n개 set이 생성되어야 한다.")
    @Test
    void createRandomLottoSet() {
        List<Integer> randomNumberSet = Randoms.pickUniqueNumbersInRange(1, 100, 4);

        assertAll(() -> assertThat(lottoRandom.generateRandomLottoNumberList(randomNumberSet.get(0)).size()).
                        isEqualTo(randomNumberSet.get(0)),
                () -> assertThat(lottoRandom.generateRandomLottoNumberList(randomNumberSet.get(1)).size()).
                        isEqualTo(randomNumberSet.get(1)),
                () -> assertThat(lottoRandom.generateRandomLottoNumberList(randomNumberSet.get(2)).size()).
                        isEqualTo(randomNumberSet.get(2)),
                () -> assertThat(lottoRandom.generateRandomLottoNumberList(randomNumberSet.get(3)).size()).
                        isEqualTo(randomNumberSet.get(3)));
    }

    @DisplayName("1개의 로또 번호 세트는 6개의 숫자로 구성되어야 한다.")
    @Test
    void numberOfLottoTest() {
        List<Integer> randomNumberSet = Randoms.pickUniqueNumbersInRange(3, 100, 1);
        List<List<Integer>> randomLottoList = lottoRandom.generateRandomLottoNumberList(randomNumberSet.get(0));

        assertAll(() -> assertThat(randomLottoList.get(0).size()).isEqualTo(6),
                () -> assertThat(randomLottoList.get(1).size()).isEqualTo(6),
                () -> assertThat(randomLottoList.get(2).size()).isEqualTo(6));
    }

    @DisplayName("로또 번호들은 오름차순으로 정렬되어있어야 한다.")
    @Test
    void lottoAscendingTest() {
        List<Integer> randomNumberSet = Randoms.pickUniqueNumbersInRange(3, 100, 1);

        List<Integer> lottoRandom1 = lottoRandom.generateRandomLottoNumberList(randomNumberSet.get(0)).get(0);
        List<Integer> lottoRandom2 = lottoRandom.generateRandomLottoNumberList(randomNumberSet.get(0)).get(1);
        List<Integer> lottoRandom3 = lottoRandom.generateRandomLottoNumberList(randomNumberSet.get(0)).get(2);

        List<Integer> deepCopyOfLottoRandom1 = new ArrayList<>();
        List<Integer> deepCopyOfLottoRandom2 = new ArrayList<>();
        List<Integer> deepCopyOfLottoRandom3 = new ArrayList<>();

        deepCopyOfLottoRandom1.addAll(lottoRandom1);
        deepCopyOfLottoRandom2.addAll(lottoRandom2);
        deepCopyOfLottoRandom3.addAll(lottoRandom3);

        Collections.sort(deepCopyOfLottoRandom1);
        Collections.sort(deepCopyOfLottoRandom2);
        Collections.sort(deepCopyOfLottoRandom3);

        assertAll(() -> assertThat(lottoRandom1).isEqualTo(deepCopyOfLottoRandom1),
                () -> assertThat(lottoRandom2).isEqualTo(deepCopyOfLottoRandom2),
                () -> assertThat(lottoRandom3).isEqualTo(deepCopyOfLottoRandom3));
    }
}
