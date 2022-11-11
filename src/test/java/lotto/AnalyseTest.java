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
    @DisplayName("로또 분석")
    void AnalyseLotto() throws Exception {
        Prize[] prizes = new Prize[] {
                Prize.FIRST, Prize.SECOND, Prize.THIRD, Prize.FOURTH, Prize.FIFTH
        };
        int index = 0;
        Method method = InvokeMethod();

        for(; index<5; index++) {
            System.out.println(prizes[index]);
            expectedStat.put(prizes[index], 1);
            method.invoke(analyse, lottos.get(index), prize);
            assertEquals(expectedStat.get(prizes[index]), Analyse.getStats().get(prizes[index]));
        }
    }

}
