package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lotto.util.number.LottoNumberConst;

public class Player {

    private static final String LOTTO_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";

    private final LottoPurchaseAmount lottoPurchaseAmount;
    private final List<Lotto> myLottos;

    public Player(LottoPurchaseAmount lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
        this.myLottos = initLottos();
    }

    private List<Lotto> initLottos() {
        BigInteger lottoAmount = lottoPurchaseAmount.calculatePurchaseLottoAmount();
        List<Lotto> myLottos = new ArrayList<>();

        while (lottoAmount.compareTo(BigInteger.ZERO) > 0) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(
                    LottoNumberConst.MIN_NUMBER_INT_VALUE,
                    LottoNumberConst.MAX_NUMBER_INT_VALUE,
                    LottoNumberConst.NUMBER_SIZE
            );

            myLottos.add(new Lotto(uniqueNumbers));
            lottoAmount = lottoAmount.subtract(BigInteger.ONE);
        }
        return myLottos;
    }

    public void calculateLottoRanking(LottoResult lottoResult, Lotto winningLotto, LottoNumber bonusNumber) {
        myLottos.forEach(lotto -> lottoResult.addRankingCount(winningLotto.calculateLottoGrade(lotto, bonusNumber)));
    }

    @Override
    public String toString() {
        StringBuilder playerMessage = new StringBuilder();

        playerMessage
                .append(String.format(
                        LOTTO_COUNT_MESSAGE_FORMAT, lottoPurchaseAmount.calculatePurchaseLottoAmount()))
                .append("\n");

        myLottos.forEach(lotto -> playerMessage.append(lotto.toString()).append("\n"));

        return playerMessage.toString();
    }
}
