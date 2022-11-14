package lotto.domain.processor;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoProcessor {


    /**
     * 몇개의 번호가 일치하는지 알려주는 로직
     * @param winLotto - 당첨 번호 로또
     * @param lotto - 로또
     * @return 일치하는 번호의 개수
     */
    int matchLottoNumber(Lotto winLotto, Lotto lotto);


    /**
     * 보너스번호가 일치하는지 확인하는 로직
     * @param bonusNumber - 보너스 번호
     * @param lotto - 로또
     * @return 보너스번호 일치 여부
     */
    Boolean matchBonusNumber(Integer bonusNumber, Lotto lotto);

    /**
     * 카운트 개수를 받아 그 수만큼 로또를 생성해주는 로직
     * @param count - count 의 수만큼 로또를 생성한다.
     * @return count 개수를 가지는 랜덤 로또 리스트
     */
    List<Lotto> createLottoByCount(Integer count);

    /**
     * 입력한 숫자로 로또를 생성하는 로직
     * @param lottoNumbers - 입력 숫자
     * @return lottoNumbers 를 번호로 갖는 로또
     */
    Lotto createLotto(List<Integer> lottoNumbers);
}
