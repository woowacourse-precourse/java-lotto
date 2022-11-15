package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LottoNumberGenerator 클래스")
@Nested
public class LottoNumberGeneratorTest {
    @DisplayName("sortAscending 메소드는")
    @Nested
    class Describe_sortAscending {
        @DisplayName("랜덤 생성된 로또 번호를 입력받으면")
        @Nested
        class Context_with_Generated_Numbers {
            @DisplayName("로또 번호를 오름차순으로 정렬하여 반환한다.")
            @Test
            void sortAscendingTest() {
                assertSimpleTest(() -> {
                            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
                            assertThat(lottoNumberGenerator.sortAscending(Arrays.asList(3, 2, 1, 5, 6, 4)))
                                    .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6)
                                    );
                        }
                );
            }

        }
    }


}
