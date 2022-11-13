package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoCalculatorTest {

    @Test
    void checkNumbers() {
        List<Lotto> lottoList = new ArrayList<>();
        List<List<Integer>> userLottoList = new ArrayList<>();

        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12))));
        lottoList.add(new Lotto(new ArrayList<>(Arrays.asList(13, 14, 15, 16, 17, 18))));

        userLottoList.add(new ArrayList<>(Arrays.asList(1, 2, 7, 8, 9, 10)));
        userLottoList.add(new ArrayList<>(Arrays.asList(12)));

        LottoCalculator lottoCalculator = new LottoCalculator();
        lottoCalculator.checkNumbers(lottoList, userLottoList);
    }
}