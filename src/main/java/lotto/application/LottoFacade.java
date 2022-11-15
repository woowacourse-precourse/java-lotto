package lotto.application;

import lotto.domain.Lotto;

import java.util.List;


public interface LottoFacade {
     /**
      * 금액을 입력받고 그 수만큼 로또를 구매하는 기능
      * @param money - 금액
      * @return - 구매한 로또를 담은 배열
      */
     List<Lotto> buyLotto(Integer money);

     /**
      * 사용자의 입력 번호로 당첨번호를 등록하는 기능
      * @param input - 사용자 입력번호
      * @return - 당첨번호가 있는 로또
      */
     Lotto registerWinLotto(String input);

     /**
      * 마진률을 가져오는 기능
      * @param before - 원금
      * @param after - 수익
      * @return - 마진률
      */
     String getMargin(Integer before, Integer after);

     /**
      * 당첨 카운트를 계산하는 기능
      * @param winLotto - 당첨번호가 담긴 로또
      * @param clientLotto - 사용자의 로또리스트
      * @param bonus - 당첨보너스 번호
      * @return - 당첨카운트를 담은 리스트
      */
     List<Integer> checkWinning(Lotto winLotto, List<Lotto> clientLotto, Integer bonus);

     /**
      * 총 당첨금을 계산하는 기능
      * @param result - 당첨카운트를 담은 리스트
      * @return - 총 당첨금액
      */
     Integer calculateMoney(List<Integer> result);
}
