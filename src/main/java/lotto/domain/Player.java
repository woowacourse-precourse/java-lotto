package lotto.domain;

import lotto.dto.GameResultResponseDtos;

import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public static final int LOTTO_PRICE = 1000;

    private Lottos lottos;
    private int purchasePrice;

    public Lottos purchaseLottos(int purchasePrice, List<List<Integer>> lottoNumbers) {
        int purchaseLottoCount = calculateLottoCount(purchasePrice);
        PlayerValidationUtils.validateSize(purchaseLottoCount, lottoNumbers.size());

        lottos = new Lottos(createLottos(lottoNumbers));
        this.purchasePrice = purchasePrice;
        return lottos;
    }

    public int calculateLottoCount(int purchasePrice) {
        PlayerValidationUtils.validateCanPurchase(purchasePrice);
        return purchasePrice / LOTTO_PRICE;
    }

    private List<Lotto> createLottos(List<List<Integer>> lottoNumbers) {
        return lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public GameResultResponseDtos playLotto(Answer answer) {
        List<LottoResult> lottoResults = play(answer);
        return Referee.calculate(lottoResults, purchasePrice);
    }

    private List<LottoResult> play(Answer answer) {
        return answer.compare(lottos);
    }
}
