package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LottoRank 클래스")
@Nested
public class LottoRankTest {
    @DisplayName("findMatchingRank 메소드는")
    @Nested
    class Describe_findMatchingRank {
        @DisplayName("3등이 아닌 경우")
        @Nested
        class Context_without_Third_Place {
            @DisplayName("당첨 배열에 맞는 WinningCount를 증가시킨다.")
            @Test
            void findMatchingRankTest() {
                assertSimpleTest(() -> {
                    LottoRank lottoRank = LottoRank.SECOND;
                    lottoRank.findMatchingRank(5);
                    try {
                        Field field = lottoRank.getClass().getDeclaredField("winningCount");
                        field.setAccessible(true);

                        int value = (int) field.get(lottoRank);
                        assertThat(value).isEqualTo(1);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessError e) {
                        e.printStackTrace();
                    }
                }
                );
            }
        }
    }

    @DisplayName("checkThirdPlace 메소드는")
    @Nested
    class Describe_checkThirdPlace {
        @DisplayName("3등인 경우")
        @Nested
        class Context_without_Third_Place {
            @DisplayName("당첨 배열의 3등에 해당하는 WinningCount를 증가시킨다.")
            @Test
            void checkThirdPlaceTest() {
                assertSimpleTest(() -> {
                            LottoRank lottoRank = LottoRank.THIRD;
                            lottoRank.checkThirdPlace(5, 0);
                            try {
                                Field field = lottoRank.getClass().getDeclaredField("winningCount");
                                field.setAccessible(true);

                                int value = (int) field.get(lottoRank);
                                assertThat(value).isEqualTo(1);
                            } catch (NoSuchFieldException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessError e) {
                                e.printStackTrace();
                            }
                        }
                );
            }
        }
    }
}
