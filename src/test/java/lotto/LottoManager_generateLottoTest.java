package lotto;

import lotto.manageLotto.LottoManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoManager_generateLottoTest {

    private static final ProgramManager programManager = new ProgramManager();
    private static final int price = 3000;
    private static int numberOfLotto;

    @BeforeAll
    static void init() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        Field programManager_numberOfLotto = programManager.getClass().getDeclaredField("numberOfLotto");
        programManager_numberOfLotto.setAccessible(true);
        numberOfLotto = (int) programManager_numberOfLotto.get(programManager_numberOfLotto);
    }

    // 사용자 입력
    void putSystemInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    /**
     * generateLotto - 로또 발행
     */
    @Test
    void generateLotto_로또_발행_개수_테스트() {
        putSystemInput(Integer.toString(price));
        assertThat(numberOfLotto).isEqualTo(LottoManager.generateLotto(numberOfLotto).size());
    }

    @Test
    void generateLotto_로또_발행_중복_테스트() {
        putSystemInput(Integer.toString(price));

        List<List<Integer>> lottos = LottoManager.generateLotto(numberOfLotto);
        boolean checkDuplicate = false;
        for (List<Integer> lotto : lottos) {
            Set<Integer> setOfLotto = new HashSet<>(lotto);
            if (setOfLotto.size() != LottoManager.LOTTO_LENGTH) {
                checkDuplicate = true;
                break;
            }
        }
        assertThat(false).isEqualTo(checkDuplicate);
    }

}
