package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {
    @Test
    void 구매한_로또_출력_테스트() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer>[] randomNumbers = lottoGenerator.createRandomNumbers(8);
        Console console = new Console();
        console.outputMyLottos(randomNumbers);
    }

    @Test
    void 당첨_통계_출력_테스트() {
        Console console = new Console();
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIFTH, 2); //10000
        map.put(Rank.FOURTH, 1); // 50000

        console.outputWinningResult(map, 66.7);
    }
}