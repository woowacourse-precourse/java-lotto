package lotto.domain.player;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.game.LottoRanking;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.utils.consts.LottoConst;
import lotto.utils.number.LottoNumbersGenerator;

public class Player {

    private final PlayerPurchaseAmount lottoPurchaseAmount;
    private final List<Lotto> myLottos;

    public Player(PlayerPurchaseAmount lottoPurchaseAmount, LottoNumbersGenerator generator) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
        this.myLottos = initLottos(generator);
    }

    private List<Lotto> initLottos(LottoNumbersGenerator generator) {
        BigInteger lottoAmount = lottoPurchaseAmount.calculatePurchaseLottoAmount();
        List<Lotto> lottos = new ArrayList<>();

        while (isBiggerThanZero(lottoAmount)) {
            List<Integer> uniqueRandomNumbers = generator.generate(LottoConst.NUMBER_SIZE);
            lottos.add(new Lotto(uniqueRandomNumbers));
            lottoAmount = lottoAmount.subtract(BigInteger.ONE);
        }
        return lottos;
    }

    private boolean isBiggerThanZero(BigInteger lottoAmount) {
        return lottoAmount.compareTo(BigInteger.ZERO) > 0;
    }

    public List<LottoRanking> calculateLottoRanking(Lotto winningLotto, LottoNumber bonusNumber) {
        final List<LottoRanking> rankings = new ArrayList<>();

        myLottos.forEach(lotto -> rankings.add(winningLotto.calculateLottoRanking(lotto, bonusNumber)));
        return rankings;
    }

    public BigDecimal calculateRevenuePercent(BigDecimal totalReward) {
        return lottoPurchaseAmount.calculateRevenuePercent(totalReward);
    }

    public List<String> getPurchaseLottos() {
        return myLottos.stream()
                .map(Lotto::getSortedLottoNumbers)
                .collect(Collectors.toUnmodifiableList());
    }
}
