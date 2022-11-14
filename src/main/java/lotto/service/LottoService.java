package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Buyer;
import lotto.Lotto;
import lotto.Winning;
import lotto.system.SystemMessage;
import lotto.system.SystemValue;
import lotto.type.Rank;

public class LottoService {

    public Buyer buy(int money) {
        List<Lotto> purchaseLottos = new ArrayList<>();
        int lottoQuantity = calculationForLotto(money);

        for (int i = 0; i < lottoQuantity; i++) {
            purchaseLottos.add(Issuance());
        }
        System.out.println();
        return new Buyer(money, purchaseLottos);
    }

    private int calculationForLotto(int money) {
        validateForMoney(money);
        int lottoQuantity = (money / SystemValue.LOTTO_PRICE);
        SystemMessage.purchaseQuantity(lottoQuantity);
        return lottoQuantity;
    }

    private void validateForMoney(int money) {
        if (money % SystemValue.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 복권 금액으로 나누어 떨어지지 않습니다.");
        }
    }

    private Lotto Issuance() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto newLotto = new Lotto(randomNumbers);
        newLotto.printNumbers();
        return newLotto;
    }

    public Winning pick(List<Integer> winningNumbers, int bonusNumber) {
        return new Winning(winningNumbers, bonusNumber);
    }

    public List<Integer> winningInputParseToList(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] splitInput = input.split(",");

        for (String number : splitInput) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    public double calculatePortfolio(List<Rank> lottosRank, int purchaseMoney){
        return 100 + ((double)(getProfitMoney(lottosRank) - purchaseMoney) / (double) purchaseMoney) * 100;
    }

    private int getProfitMoney(List<Rank> lottosRank){
        int profit = 0;
        for (Rank rank: lottosRank) {
            profit += rank.getReward();
        }
        return profit;
    }

}
