package lotto.domain;

import lotto.PrizeMoney;
import ui.UserInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    private final float lottoCount;
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public Statistics(List<Lotto> lottos, WinningLotto winningLottos) {
        this.lottoCount = lottos.size();
        this.lottos = lottos;
        this.winningLotto = winningLottos;
    }

    public List<Integer> calculateInformation() {
        List<Integer> information = new ArrayList<>(List.of(0, 0, 0, 0, 0));

        for (Lotto lotto : lottos) {
            int rankCode = compare(lotto);
            if (rankCode != -1) {
                information.set(rankCode, information.get(rankCode) + 1);
            }
        }

        return information;
    }

    public float calculateProfitRate(List<Integer> information) {
        int totalPrizeMoney = 0;
        List<PrizeMoney> prizeMoney = Arrays.stream(PrizeMoney.values()).collect(Collectors.toList());

        for (int i = 0; i < information.size(); i++) {
            int winningCount = information.get(i);
            totalPrizeMoney += ((prizeMoney.get(i).getMoney()) * winningCount);
        }
        return totalPrizeMoney / (lottoCount * UserInterface.PRICE_UNIT) * 100;
    }

    private int compare(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        int correctCount = 0;
        for (int lottoNumber : lottoNumbers) {
            if(winningNumbers.contains(lottoNumber)) {
                correctCount += 1;
            }
        }

        return judgement(correctCount, winningLotto.getBonus(), lottoNumbers);
    }

    private int judgement(int count, int bonus, List<Integer> lottoNumbers) {
        if ((count == 5) && (lottoNumbers.contains(bonus))) {
            return PrizeMoney.RANK2.ordinal();
        }
        if(count == 6) {
            return PrizeMoney.RANK1.ordinal();
        }

        String name = "RANK" + (8 - count);
        if (count >= 3) {
            return PrizeMoney.valueOf(name).ordinal();
        }

        return -1;
    }
}
