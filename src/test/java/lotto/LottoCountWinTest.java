package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoCountWinTest {
    private List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private int bonusNumber = 7;
    private List<List<Integer>> lottoRandom = new ArrayList<>(new ArrayList<>());
    private long ticket = 8;

    @BeforeEach
    void setUp() {
        List<Integer> add1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> add2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Integer> add3 = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 44));
        List<Integer> add4 = new ArrayList<>(Arrays.asList(4, 5, 6, 6, 11, 12));
        List<Integer> add5 = new ArrayList<>(Arrays.asList(1, 5, 6, 38, 42, 45));
        List<Integer> add6 = new ArrayList<>(Arrays.asList(7, 4, 5, 1, 6, 2));
        List<Integer> add7 = new ArrayList<>(Arrays.asList(45, 44, 5, 6, 2, 3));
        List<Integer> add8 = new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25, 26));
        lottoRandom.add(add1);
        lottoRandom.add(add2);
        lottoRandom.add(add3);
        lottoRandom.add(add4);
        lottoRandom.add(add5);
        lottoRandom.add(add6);
        lottoRandom.add(add7);
        lottoRandom.add(add8);
    }

    @Test
    void getCount1Win() {
        LottoCountWin lottoCountWin = new LottoCountWin(lottoNumbers, bonusNumber, lottoRandom, ticket);
        int result = 1;
        assertThat(lottoCountWin.getCount1Win()).isEqualTo(result);
    }

    @Test
    void getCount2Win() {
        LottoCountWin lottoCountWin = new LottoCountWin(lottoNumbers, bonusNumber, lottoRandom, ticket);
        int result = 2;
        assertThat(lottoCountWin.getCount2Win()).isEqualTo(result);
    }


    @Test
    void getCount3Win() {
        LottoCountWin lottoCountWin = new LottoCountWin(lottoNumbers, bonusNumber, lottoRandom, ticket);
        int result = 1;
        assertThat(lottoCountWin.getCount3Win()).isEqualTo(result);
    }

    @Test
    void getCount4Win() {
        LottoCountWin lottoCountWin = new LottoCountWin(lottoNumbers, bonusNumber, lottoRandom, ticket);
        int result = 2;
        assertThat(lottoCountWin.getCount4Win()).isEqualTo(result);
    }

    @Test
    void getCount5Win() {
        LottoCountWin lottoCountWin = new LottoCountWin(lottoNumbers, bonusNumber, lottoRandom, ticket);
        int result = 1;
        assertThat(lottoCountWin.getCount5Win()).isEqualTo(result);
    }
}