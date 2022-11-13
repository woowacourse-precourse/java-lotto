package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;


    public LottoService(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    /**
     * 1-45 범위의 6자리 랜덤 숫자를 만들어 Lotto 객체를 반환
     * @return 랜덤 숫자가 부여된 Lotto 객체
     */
    public Lotto generateLotto(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        randomNumbers.sort(null);
        Lotto lotto = new Lotto(randomNumbers);

        return lotto;
    }

    /**
     * Lotto 리스트를 파라미터로 받아 등수 정보를 정수 리스트로 반환
     * @param lottos : 등수 정보 리스트로 변환할 로또 리스트
     * @return 각 등수 별 당첨 개수
     */
    public List<Integer> getLottoRankResultsByLottos(List<Lotto> lottos) {
        List<Integer> lottoRankResults = new ArrayList<>(
                Collections.nCopies(LottoRank.values().length-1, 0)
        );
        for (Lotto lotto : lottos){
            LottoHitsCountVO lottoHitsCount = getLottoHitsCount(lotto);
            int ordinal = LottoRank.findByLottoHitsCountVO(lottoHitsCount).ordinal();
            if (ordinal != LottoRank.NOTHING.ordinal()){
                lottoRankResults.set(ordinal, lottoRankResults.get(ordinal)+1);
            }
        }

        return lottoRankResults;
    }

    private LottoHitsCountVO getLottoHitsCount(Lotto lotto){
        List<Integer> lottoNumbers = lotto.getNumbers();
        int hitsCount = countSameValueOfLists(this.winningNumbers, lottoNumbers);
        boolean hitsBonus = lottoNumbers.contains(this.bonusNumber);

        return new LottoHitsCountVO(hitsCount, hitsBonus);
    }

    private int countSameValueOfLists(List<Integer> former, List<Integer> latter){
        Set uniqueFormerNumbers = new HashSet(former);
        Set uniqueLetterNumbers = new HashSet(latter);
        uniqueFormerNumbers.retainAll(uniqueLetterNumbers);

        return uniqueFormerNumbers.size();
    }

}
