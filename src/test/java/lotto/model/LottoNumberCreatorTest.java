package lotto.model;

import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberCreatorTest {

    @RepeatedTest(30)
    void 중복_없는지_테스트(){
        List<Integer> result = LottoNumberCreator.createRandomNumbers();

        for(int number : result){
            assertThat(number).isBetween(1,45);
        }
    }
}
