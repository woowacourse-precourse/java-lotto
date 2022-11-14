package lotto;

import lotto.lottoGenerator.RandomNumbersGenerator;
import lotto.lottoGenerator.RandomNumbersGeneratorWithMissionUtils;
import org.junit.jupiter.api.Test;

public class RandomNumbersGeneratorWithMissionUtilsTest {
    @Test
    void 랜덤숫자생성_테스트() {
        RandomNumbersGenerator generator = new RandomNumbersGeneratorWithMissionUtils();
        for(int i = 0; i < 100; i++) {
            generator.generateRandomNumbers();
        }
    }
}
