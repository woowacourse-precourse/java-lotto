package lotto;

import lotto.model.Lotto;
import lotto.util.SystemMessage;
import lotto.model.WinNumbers;
import lotto.util.Type;

import java.util.*;

public class LottoResult {
    private List<Integer> winNumbers;
    private int bonusNumber;
    private BuyLotto buyLottos;
    private Map<Type, Integer> lottoResult = new LinkedHashMap<>();
    private final List<Type> typeList = new ArrayList<>(Arrays.asList(
            Type.FIFTH,
            Type.FOURTH,
            Type.THIRD,
            Type.SECOND,
            Type.FIRST
    ));

    public LottoResult(BuyLotto buyLottos, WinNumbers winNumbers) {
        this.buyLottos = buyLottos;
        this.winNumbers = winNumbers.getWinNumbers().getSortedNumber();
        this.bonusNumber = winNumbers.getBonusNumber().getBonusNumber();
        initLottoResult();
        getWinStats();
    }

    private void getWinStats() {
        for (Lotto buyLotto : buyLottos.getLottos()) {
            int number = checkLotto(buyLotto);
            if (number >= 3) {
                Type rank = rankCheck(number, buyLotto);
                setLottoResult(rank);
            }
        }
    }

    private void initLottoResult() {
        for (Type type : typeList) {
            lottoResult.put(type, 0);
        }
    }

    private void setLottoResult(Type type) {
        lottoResult.replace(type, lottoResult.get(type) + 1);
    }

    private int checkLotto(Lotto lotto) {
        int count = 0;
        for (int value : lotto.getSortedNumber()) {
            if (this.winNumbers.contains(value)) {
                count += 1;
            }
        }
        return count;
    }

    private Type rankCheck(int count, Lotto buyLotto) {
        if (count == 3) {
            return Type.FIFTH;
        }
        if (count == 4) {
            return Type.FOURTH;
        }
        if (count == 5) {
            if (buyLotto.getSortedNumber().contains(bonusNumber)) {
                return Type.SECOND;
            }
            return Type.THIRD;
        }
        if (count == 6) {
            return Type.FIRST;
        }
        return null;
    }

    public void showWinStats() {
        System.out.printf(SystemMessage.WIN_STATS.getContent());
        System.out.println(SystemMessage.HORIZON.getContent());
        for (Type type : lottoResult.keySet()) {
            System.out.printf(type.getComment(), lottoResult.get(type));
        }
    }

    public void showProfitRate() {
        System.out.printf(SystemMessage.PROFIT_RATE.getContent(), getProfitRate());
    }

    private String getProfitRate() {
        double totalWinMoney = getTotalWinMoney();
        return String.format("%.1f", (totalWinMoney / buyLottos.getMoney().getMoney()) * 100);
    }

    private double getTotalWinMoney() {
        double totalWinMoney = 0;
        for (Type type : lottoResult.keySet()) {
            if (type == Type.FIRST) {
                totalWinMoney = totalWinMoney + lottoResult.get(type) * 2000000000;
            } else if (type == Type.SECOND) {
                totalWinMoney = totalWinMoney + lottoResult.get(type) * 30000000;
            } else if (type == Type.THIRD) {
                totalWinMoney = totalWinMoney + lottoResult.get(type) * 1500000;
            } else if (type == Type.FOURTH) {
                totalWinMoney = totalWinMoney + lottoResult.get(type) * 50000;
            } else if (type == Type.FIFTH) {
                totalWinMoney = totalWinMoney + lottoResult.get(type) * 5000;
            }
        }
        return totalWinMoney;
    }
}
