package lotto;

import lotto.domain.*;
import lotto.utils.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgmentTest {

    @DisplayName("로또 추첨하여 등수 값 테스트, 1등 번호 추첨 시나리오")
    @Test
    void drawLottoFirstClassTest() throws Exception{
        User user = new User();
        Integer[] numbers = {1,2,3,4,5,6};
        Lotto lotto = new Lotto(new ArrayList<>(List.of(numbers)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Field userLottos = User.class.getDeclaredField("userLottos");
        userLottos.setAccessible(true);
        userLottos.set(user, lottos);

        WinningNumbers winningNumbers = new WinningNumbers();
        Integer[] winNumbers = {1,2,3,4,5,6};
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(winNumbers)));
        winningNumbers.newBonusNumber(7);

        Judgment judgment = new Judgment(user, winningNumbers);

        Method drawLotto = Judgment.class.getDeclaredMethod("drawLotto", int.class);
        drawLotto.setAccessible(true);
        Rank rank = (Rank) drawLotto.invoke(judgment, 0);

        assertThat(rank).isEqualTo(Rank.FIRST_CLASS);
    }

    @DisplayName("로또 추첨하여 등수 값 테스트, 2등 번호 추첨 시나리오")
    @Test
    void drawLottoSecondClassTest() throws Exception{
        User user = new User();
        Integer[] numbers = {1,2,3,4,5,7};
        Lotto lotto = new Lotto(new ArrayList<>(List.of(numbers)));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        Field userLottos = User.class.getDeclaredField("userLottos");
        userLottos.setAccessible(true);
        userLottos.set(user, lottos);

        WinningNumbers winningNumbers = new WinningNumbers();
        Integer[] winNumbers = {1,2,3,4,5,6};
        winningNumbers.newWinningNumbers(new ArrayList<>(List.of(winNumbers)));
        winningNumbers.newBonusNumber(7);

        Judgment judgment = new Judgment(user, winningNumbers);

        Method drawLotto = Judgment.class.getDeclaredMethod("drawLotto", int.class);
        drawLotto.setAccessible(true);
        Rank rank = (Rank) drawLotto.invoke(judgment, 0);

        assertThat(rank).isEqualTo(Rank.SECOND_CLASS);
    }
    

}