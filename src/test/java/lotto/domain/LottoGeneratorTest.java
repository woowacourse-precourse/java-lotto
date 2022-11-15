package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    private LottoGenerator numberGenerate;
    int numberOfPurchases = 3;

    @BeforeEach
    void setUp() {
        numberGenerate = new LottoGenerator(numberOfPurchases);
    }

    @DisplayName("로또 번호의 개수가 6개다")
    @Test
    void create6RandomNumbers() {
        List<List<Integer>> userAllLotto = numberGenerate.getUserLottoTickets();
        List<Integer> userLotto = new ArrayList<>();
        userLotto.addAll(userAllLotto.get(0));

        assertThat(userLotto.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호에 중복된 숫자가 없다")
    @Test
    void createUniqueNumbers() {
        List<List<Integer>> userAllLotto = numberGenerate.getUserLottoTickets();
        List<Integer> userLotto = new ArrayList<>();
        userLotto.addAll(userAllLotto.get(0));
        Set<Integer> randomSet = new HashSet<>(userLotto);

        assertThat(userLotto.size()).isEqualTo(randomSet.size());
    }

    @DisplayName("구매할 개수만큼 로또를 발급받는다.")
    @Test
    void purchasesThreeLotto() {

        List<List<Integer>> userAllLotto = numberGenerate.getUserLottoTickets();

        assertThat(userAllLotto.size()).isEqualTo(numberOfPurchases);
    }
}
