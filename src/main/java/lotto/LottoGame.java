package lotto;

import utils.LottoCreator;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    private static final String DELIMITER = ",";
    private static final int ONE_LOTTO_PRICE = 1000;

    public static int getLottoCount(int lottoPrice) {
        return lottoPrice / ONE_LOTTO_PRICE;
    }

    public static List<Lotto> getLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoCreator.createLotto());
        }

        return lottos;
    }

    public static List<Integer> spiltLottoNumber(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static WinningLotto createWinningLotto(String winningLottoNumber, String winningBonusNumber) {
        List<Integer> winningLotto = spiltLottoNumber(winningLottoNumber);
        int bonusNumber = Integer.parseInt(winningBonusNumber);

        return new WinningLotto(new Lotto(winningLotto), bonusNumber);
    }

    public static Map<LottoRank, Integer> getLottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoResult = initLottoResult();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getCountOfMatch(winningLotto.getWinningLottoNumbers());
            boolean bonusMatch = lotto.containBonus(winningLotto.getBonusNumber());
            LottoRank lottoRank = LottoRank.valueOf(matchCount, bonusMatch);
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        }

        return lottoResult;
    }

    private static Map<LottoRank, Integer> initLottoResult() {
        Map<LottoRank, Integer> lottoResult = new HashMap<>();

        lottoResult.put(LottoRank.FIRST_PLACE, 0);
        lottoResult.put(LottoRank.SECOND_PLACE, 0);
        lottoResult.put(LottoRank.THIRD_PLACE, 0);
        lottoResult.put(LottoRank.FOURTH_PLACE, 0);
        lottoResult.put(LottoRank.FIFTH_PLACE, 0);
        lottoResult.put(LottoRank.NOTHING, 0);

        return lottoResult;
    }
}
