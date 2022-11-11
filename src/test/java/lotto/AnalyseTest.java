package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalyseTest {
    private static final List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 8)),
            new Lotto(List.of(1, 2, 3, 4, 7, 8)),
            new Lotto(List.of(1, 2, 3, 7, 8, 9))
    );
    private static final List<Integer> prize = List.of(1, 2, 3, 4, 5, 6, 7);
    private static TreeMap<Prize, Integer> expectedStat = new TreeMap<>();
    private static Analyse analyse = new Analyse();

    @BeforeEach
    void clearStats() {
        Analyse.clearStats();
        expectedStat.clear();
    }

    Method InvokeMethod() {
        try {
            Method method = analyse.getClass().getDeclaredMethod("countSameNum", Lotto.class, List.class);
            Method method2 = analyse.getClass().getDeclaredMethod("setStats");
            method.setAccessible(true);
            method2.setAccessible(true);
            method2.invoke(analyse);
            return method;
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("로또 당첨 번호와 6개 모두 일치할 때")
    void allCorrect() throws InvocationTargetException, IllegalAccessException {
        expectedStat.put(Prize.FIRST, 1);
        Method method = InvokeMethod();
        System.out.println("invokeMethod: "+Analyse.getStats().get(Prize.FIRST));

        method.invoke(analyse, lottos.get(0), prize);

        assertEquals(expectedStat.get(Prize.FIRST), Analyse.getStats().get(Prize.FIRST));
    }

}
