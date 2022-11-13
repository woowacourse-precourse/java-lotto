package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private List<Lotto> lottos;
    private LottoGenerator lottoGenerator;

    public User() {
        this.lottos = new ArrayList<>();
        this.lottoGenerator = new LottoGenerator();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void buyLotto(long price) {
        while (price >= 1000) {
            lottos.add(lottoGenerator.publish());
            price -= 1000;
        }
    }

    public List<Integer> getWinningHistory(List<Integer> answer, int bonus) {
        int[] history = new int[]{0, 0, 0, 0, 0, 0};
        lottos.forEach(lotto -> {
            int index = lotto.draw(answer, bonus);
            history[index]++;
        });
        return Arrays.stream(history).boxed().collect(Collectors.toList());
    }

    public double getYield(List<Integer> winningHistory, long investment) {
        long totalMoney = getTotalMoney(winningHistory);
        if(investment == 0) return investment;
        return Double.parseDouble(String.format("%.1f", (totalMoney / (double) investment) * 100.0));
    }

    private long getTotalMoney(List<Integer> winningHistory) {
        Place[] places = Place.values();
        int index = 0;
        long totalMoney = 0;
        for (Place place : places) {
            long prizeMoney = Integer.parseInt(place.getPrizeMoney().replaceAll(",", ""));
            totalMoney += (prizeMoney * winningHistory.get(index++));
        }
        return totalMoney;
    }

}
