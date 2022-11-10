package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CreateRandomLottoTest {

    @Test
    void randomLotto() {
      //  Map<Integer, List<Integer>> testcase = new HashMap<>();
        CreateRandomLotto test = new CreateRandomLotto();
        System.out.println(test.randomLotto(5));
    }
}