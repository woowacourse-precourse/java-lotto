package lotto;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.service.Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceTest {

    private static final List<Integer> FIRST_RANK_LOTTO = List.of(1,2,3,4,5,6);
    private static final List<Integer> SECOND_RANK_LOTTO = List.of(1,2,3,4,5,45);
    private static final List<Integer> THIRD_RANK_LOTTO = List.of(2,3,4,5,6,7);
    private static final List<Integer> FOURTH_RANK_LOTTO = List.of(3,4,5,6,7,8);
    private static final List<Integer> BONUS_FOURTH_RANK_LOTTO = List.of(3,4,5,6,7,45);
    private static final List<Integer> FIFTH_RANK_LOTTO = List.of(4,5,6,7,8,9);
    private static final List<Integer> BONUS_FIFTH_RANK_LOTTO = List.of(4,5,6,7,8,45);
    private static final List<Integer> NO_RANK_TWO_LOTTO = List.of(5,6,7,8,9,10);
    private static final List<Integer> BONUS_NO_RANK_TWO_LOTTO = List.of(5,6,7,8,9,45);
    private static final List<Integer> NO_RANK_ONE_LOTTO = List.of(6,7,8,9,10,11);
    private static final List<Integer> BONUS_NO_RANK_ONE_LOTTO = List.of(6,7,8,9,10,45);
    private static final List<Integer> NO_RANK_ZERO_LOTTO = List.of(7,8,9,10,11,12);
    private static final List<Integer> BONUS_NO_RANK_ZERO_LOTTO = List.of(7,8,9,10,11,45);
    final Service service = new Service();

    @DisplayName("입력된 금액으로 구매가능한 개수만큼 로또번호를 발급해야 한다.")
    @Test
    void 입력된_금액으로_구매가능한_개수만큼_로또번호를_발급하는_기능_테스트(){
        //given
        final Buyer case1 = new Buyer(1000);
        final Buyer case2 = new Buyer(100_000);

        //when
        service.buyAllLotto(case1);
        service.buyAllLotto(case2);

        //then
        assertThat(case1.getPurchasedLotteries().size()).isEqualTo(1);
        assertThat(case2.getPurchasedLotteries().size()).isEqualTo(100);
    }

    @DisplayName("당첨된 로또 개수가 몇 개인지 등수별로 저장하는 기능")
    @Test
    void 당첨된_로또_개수가_몇_개인지_등수별로_저장하는_기능_테스트(){
        //given
        final LottoGame lottogame = new LottoGame(List.of(1,2,3,4,5,6),45);
        final Buyer cases = new Buyer(1000);
        //로또 번호 리스트, 보너스번호 상수화하기
        cases.buyLotto(new Lotto(FIRST_RANK_LOTTO));    //6개 일치
        cases.buyLotto(new Lotto(SECOND_RANK_LOTTO));   //5개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(THIRD_RANK_LOTTO));    //5개 일치
        cases.buyLotto(new Lotto(FOURTH_RANK_LOTTO));   //4개 일치
        cases.buyLotto(new Lotto(FIFTH_RANK_LOTTO));    //3개 일치
        cases.buyLotto(new Lotto(NO_RANK_TWO_LOTTO));   //2개 일치
        cases.buyLotto(new Lotto(NO_RANK_ONE_LOTTO));  //1개 일치
        cases.buyLotto(new Lotto(NO_RANK_ZERO_LOTTO)); //0개 일치

        //when
        service.checkBuyerLotteries(cases, lottogame);
        HashMap<Rank,Integer> results = cases.getLottoResult();

        //then
        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_TWO)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_ONE)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_ZERO)).isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호에 보너스번호가 포함되는지 확인 후 2등 선정에만 반영하는 기능")
    @Test
    void 구매한_로또_번호에_보너스_번호가_포함되는지_확인하는_기능_테스트(){
        //given
        final LottoGame lottogame = new LottoGame(List.of(1,2,3,4,5,6),45);
        final Buyer cases = new Buyer(1000);
        //로또 번호 리스트, 보너스번호 상수화하기
        cases.buyLotto(new Lotto(SECOND_RANK_LOTTO));   //5개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(BONUS_FOURTH_RANK_LOTTO));    //4개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(BONUS_FIFTH_RANK_LOTTO));    //3개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(BONUS_NO_RANK_TWO_LOTTO));   //2개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(BONUS_NO_RANK_ONE_LOTTO));  //1개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(BONUS_NO_RANK_ZERO_LOTTO)); //0개 일치 + 보너스번호 일치

        //when
        service.checkBuyerLotteries(cases, lottogame);
        HashMap<Rank,Integer> results = cases.getLottoResult();

        //then
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_TWO)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_ONE)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_ZERO)).isEqualTo(1);
    }
}