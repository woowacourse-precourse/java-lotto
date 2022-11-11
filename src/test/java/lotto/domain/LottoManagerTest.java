package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest {
    @DisplayName("발행 가능한 수만큼 로또를 발행하는 기능 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 7, 8, 10})
    void issueLottoSeveralTimesTest(int lottoIssueCount) throws Exception {
        // Reflection Setting
        LottoManager lottoManager = new LottoManager();
        Method privateMethod = lottoManager.getClass().getDeclaredMethod("issueLottoSeveralTimes", int.class, List.class);
        privateMethod.setAccessible(true);

        // Given
        List<Lotto> myLotto = new ArrayList<>();

        // When
        privateMethod.invoke(lottoManager, lottoIssueCount, myLotto);

        // Then
        assertThat(myLotto.size()).isEqualTo(lottoIssueCount);
    }
}
