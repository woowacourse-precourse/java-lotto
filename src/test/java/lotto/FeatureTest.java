package lotto;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.logic.Calculator;
import lotto.logic.LottoVerifier;
import lotto.model.ContainStatus;
import lotto.model.WinningRank;
import lotto.view.View;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class FeatureTest {





    @Test
    void 당첨배열_인덱스_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoVerifier lottoVerifier = new LottoVerifier(7);
        List<List<Integer>> user = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 11, 12, 13, 14),
                List.of(1, 11, 12, 13, 14, 15),
                List.of(11, 12, 13, 14, 15, 16)
        );
        List<WinningRank> answer = List.of(WinningRank.one, WinningRank.two, WinningRank.three
                , WinningRank.four, WinningRank.five, WinningRank.notThing, WinningRank.notThing
                , WinningRank.notThing
        );

        for (int i = 0; i < user.size(); i++) {
            assertThat(lotto.getWinningRank(user.get(i), lottoVerifier)).isEqualTo(answer.get(i));
        }

    }

    @Test
    void 당첨_맵_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoVerifier lottoVerifier = new LottoVerifier(7);
        List<List<Integer>> user = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 11, 12, 13, 14),
                List.of(1, 11, 12, 13, 14, 15),
                List.of(11, 12, 13, 14, 15, 16)
        );
        List<Integer> bonus = List.of(10, 6, 23, 11, 10, 10, 15, 15);

        Map<WinningRank, Integer> enumMap = new EnumMap<WinningRank, Integer>(WinningRank.class);
        enumMap.put(WinningRank.one, 1);
        enumMap.put(WinningRank.two, 1);
        enumMap.put(WinningRank.three, 1);
        enumMap.put(WinningRank.four, 1);
        enumMap.put(WinningRank.five, 1);
        enumMap.put(WinningRank.notThing, 3);
        assertThat(lotto.getWinningResult(user, lottoVerifier)).isEqualTo(enumMap);
    }








}
