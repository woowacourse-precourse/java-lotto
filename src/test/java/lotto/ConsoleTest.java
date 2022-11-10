package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {
    @Test
    void 구매한_로또_출력_테스트() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer>[] randomNumbers = lottoGenerator.createRandomNumbers(8);
        Console console = new Console();
        console.outputMyLottos(randomNumbers);
    }
}