package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private static int START_NUMBER=1;
    private static int END_NUMBER=45;
    private static int COUNTS=6;
    private static int INIT=0;
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int set) {
        initLottos(set);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void initLottos(int set) {
        for (int i = 0; i < set; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNTS).stream().sorted().collect(Collectors.toList());
            Lotto lotto=new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public Map<LottoRanking, Integer> calculateLottos(List<Integer> lottoWinningNumber) {
        Map<LottoRanking, Integer> lottoRankingResult = new EnumMap<LottoRanking, Integer>(LottoRanking.class);
        Arrays.stream(LottoRanking.values()).forEach(lottoRanking -> lottoRankingResult.put(lottoRanking, INIT));
        for (Lotto lotto : lottos) {
            int matchNumbers = lotto.matchLotto(lottoWinningNumber);
            boolean containsBonus = lotto.contains(new ArrayList<>(lottoWinningNumber.get(COUNTS)));
            LottoRanking lottoRanking = LottoRanking.getLottoRanking(matchNumbers, containsBonus);
            lottoRankingResult.put(lottoRanking, lottoRankingResult.get(lottoRanking) + 1);
        }
        return lottoRankingResult;
    }
}
