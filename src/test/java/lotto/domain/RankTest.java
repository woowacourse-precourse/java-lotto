package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class RankTest {

    @Test
    void Rank는_정답인_숫자를_비교하여_그에_맞는_등수를_반환한다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        Rank rank1 = Rank.valueOf(lotto, 7, 3);
        Rank rank2 = Rank.valueOf(lotto, 7, 5);
        Rank rank3 = Rank.valueOf(lotto, 6, 5);

        Assertions.assertThat(rank1).isEqualTo(Rank.FIFTH);
        Assertions.assertThat(rank2).isEqualTo(Rank.THIRD);
        Assertions.assertThat(rank3).isEqualTo(Rank.SECOND);
    }

    @Test
    void 다섯개의_번호가_일치하는_경우_보너스점수를_통해_2등과_3등을_구별한다() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Rank.class.getDeclaredMethod("isMatchedBonusNumber", Lotto.class, int.class);
        method.setAccessible(true);

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        int bonusNumber = 7;

        boolean result1 = (boolean) method.invoke(Rank.class,lotto1, bonusNumber);
        boolean result2 = (boolean) method.invoke(Rank.class,lotto2, bonusNumber);

        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isTrue();
    }
}