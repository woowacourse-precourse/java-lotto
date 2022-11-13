package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Generator;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

//@ExtendWith(MockitoExtension.class)
public class GeneratorTest {
    @InjectMocks
    private Generator target;

    @DisplayName("로또 인스턴스를 인자로 받아 일치하는 당첨번호 및 보너스번호 개수를 HashMap에 담아 반환해준다")
    @Test
    void judgeWinningCountValidation() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = target.getClass().getDeclaredMethod("judgeWinningCount", Lotto.class);
        method.setAccessible(true);


        List<Integer> winningNumbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto.setWinningNumbers(winningNumbers);
        Lotto.setBonusNumber(7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashMap<String, Integer> winningSummary = (HashMap<String, Integer>)method.invoke(target, lotto);

        HashMap<String, Integer> expectSummary = new HashMap<String, Integer>();
        expectSummary.put("winningCount", 1);
        expectSummary.put("bonusCount", 1);
        assertThat(winningSummary).isEqualTo(expectSummary);
    }
}
