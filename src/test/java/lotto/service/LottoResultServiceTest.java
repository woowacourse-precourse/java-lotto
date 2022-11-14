package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoResultConstant;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultServiceTest {

//
//    @DisplayName("WinningLotto 생성 잘 되는지 확인")
//    @Test
//    void createWinningLotto() {
//        WinningLotto winningLotto = lottoResultService.createWinningLotto("1,2,3,4,5,6", "7");
//        Assertions.assertThat(winningLotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
//        Assertions.assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
//    }

    @DisplayName("LottoResultService가 의도한대로 동작하는지 확인")
    @Test
    void lottoResultServiceTest() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusLotto = 7;

        Map<LottoResultConstant, Integer> result = LottoResultService.getResult(lottos,
                new WinningLotto(new Lotto(winningLotto), bonusLotto));

        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_THREE)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FOUR)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_SIX)).isEqualTo(0);

    }

    @DisplayName("LottoResultService가 의도한대로 동작하는지 확인2")
    @Test
    void lottoResultServiceTest2() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusLotto = 7;

        Map<LottoResultConstant, Integer> result = LottoResultService.getResult(lottos,
                new WinningLotto(new Lotto(winningLotto), bonusLotto));

        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_THREE)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FOUR)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_SIX)).isEqualTo(1);

//        Assertions.assertThat(lottoController.printUserLottoAndUserYield(result))
//                .isEqualTo(IntConstant.THREE_CORRECT_MONEY.getValue() + IntConstant.SIX_CORRECT_MONEY.getValue());
    }

    @DisplayName("LottoResultService가 의도한대로 동작하는지 확인3")
    @Test
    void lottoResultServiceTest3() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 3, 5, 7, 6, 4)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusLotto = 7;

        Map<LottoResultConstant, Integer> result = LottoResultService.getResult(lottos,
                new WinningLotto(new Lotto(winningLotto), bonusLotto));

        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_THREE)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FOUR)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_SIX)).isEqualTo(0);

//        Assertions.assertThat(lottoController.printUserLottoAndUserYield(result))
//                .isEqualTo(
//                        IntConstant.THREE_CORRECT_MONEY.getValue() + IntConstant.FIVE_CORRECT_BONUS_CORRECT.getValue());
    }

    @DisplayName("LottoResultService가 의도한대로 동작하는지 확인4")
    @Test
    void lottoResultServiceTest4() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusLotto = 7;

        Map<LottoResultConstant, Integer> result = LottoResultService.getResult(lottos,
                new WinningLotto(new Lotto(winningLotto), bonusLotto));

        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_THREE)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FOUR)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_SIX)).isEqualTo(0);

//        Assertions.assertThat(lottoController.printUserLottoAndUserYield(result))
//                .isEqualTo(IntConstant.THREE_CORRECT_MONEY.getValue() + IntConstant.FIVE_CORRECT_MONEY.getValue());

    }

    @DisplayName("LottoResultService가 의도한대로 동작하는지 확인5")
    @Test
    void lottoResultServiceTest5() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusLotto = 7;

        Map<LottoResultConstant, Integer> result = LottoResultService.getResult(lottos,
                new WinningLotto(new Lotto(winningLotto), bonusLotto));

        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_THREE)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FOUR)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_SIX)).isEqualTo(0);

//        Assertions.assertThat(lottoController.printUserLottoAndUserYield(result))
//                .isEqualTo(IntConstant.THREE_CORRECT_MONEY.getValue() + IntConstant.FOUR_CORRECT_MONEY.getValue());
    }

    @DisplayName("LottoResultService가 의도한대로 동작하는지 확인6")
    @Test
    void lottoResultServiceTest6() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusLotto = 7;

        Map<LottoResultConstant, Integer> result = LottoResultService.getResult(lottos,
                new WinningLotto(new Lotto(winningLotto), bonusLotto));

        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_THREE)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FOUR)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE)).isEqualTo(2);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_FIVE_CORRECT_BONUS)).isEqualTo(0);
        Assertions.assertThat(result.get(LottoResultConstant.CORRECT_SIX)).isEqualTo(0);

//        Assertions.assertThat(lottoController.printUserLottoAndUserYield(result))
//                .isEqualTo(IntConstant.THREE_CORRECT_MONEY.getValue() + IntConstant.FIVE_CORRECT_MONEY.getValue() * 2);
    }
}