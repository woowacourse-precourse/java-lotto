package lotto;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultTest {

    Result result;

    @BeforeEach
    void init(){
        result = new Result();
    }

    @DisplayName("로또 번호와 사용자 번호 카운팅 테스트")
    @Test
    void matchTest(){
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.add(lotto);
        Lotto winningLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        result.compare(lottos, winningLotto, 1);
        List<Integer> counts = result.getCounts();

        assertThat(counts.get(0)).isEqualTo(3);
    }

    @DisplayName("보너스기능 테스트")
    @Test
    void bonusTest(){
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.add(lotto);
        Lotto winningLotto = new Lotto(List.of(2, 3, 4, 5, 6, 9));

        result.compare(lottos, winningLotto, 1);

        Integer res = result.getCounts().get(0);

        assertThat(res).isEqualTo(7);
    }

    @DisplayName("수익성 계산 기능 테스트")
    @Test
    void profitTest(){
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        User user = new User();
        List<Lotto> userLottos= new ArrayList<>();
        user.setMoney(8000);
        userLottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        userLottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        userLottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        userLottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        userLottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        userLottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        userLottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        userLottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        user.setMyLottoNumbers(userLottos);

        result.compare(user.getMyLottoNumbers(),winningLotto,7);
        result.calc(user);

        assertThat(result.getProfit()).isEqualTo(62.5f);
    }
}