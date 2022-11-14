package lotto;

import java.util.HashMap;
import java.util.List;

public class Result {
    private final HashMap<Integer, String> map;
    private final HashMap<Integer, Integer> results;
    private final int ordinalMoney;
    public Result(CreateLotto createLotto, Lotto winnerLotto, int bonusNumber) {
        this.map = createMap();
        this.results = createResultMap();
        this.ordinalMoney = 1000 * createLotto.getLottos().size();
        createLotto.getLottos().forEach(lottos->{
             calculateLotto(checkNumber(lottos.getNumbers(), winnerLotto),
            checkBonus(lottos.getNumbers(), bonusNumber));

        });
    }

    private void calculateLotto(int checkNumber, boolean checkBonus) {
        if (checkNumber == 6) results.put(1,results.get(1)+1);
        if (checkNumber == 5 && checkBonus) results.put(2,results.get(2)+1);
        if (checkNumber == 5) results.put(3,results.get(3)+1);
        if (checkNumber == 4) results.put(4,results.get(4)+1);
        if (checkNumber == 3) results.put(5,results.get(5)+1);
    }

    private boolean checkBonus(List<Integer> numbers,int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private HashMap<Integer, Integer> createResultMap() {

        HashMap<Integer, Integer> answer = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            answer.put(i + 1, 0);
        }

        return answer;
    }

    private HashMap<Integer, String> createMap() {

        HashMap<Integer, String> ranks = new HashMap<>();

        ranks.put(1, "6개 일치 (2,000,000,000원)");
        ranks.put(2, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        ranks.put(3, "5개 일치 (1,500,000원)");
        ranks.put(4, "4개 일치 (50,000원)");
        ranks.put(5, "3개 일치 (5,000원)");
        return ranks;
    }

    private int checkNumber(List<Integer> numbers, Lotto winnerLotto) {

        int count = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (winnerLotto.getNumbers().contains(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "당첨 통계"
                + "\n" + "---"
                + "\n" + map.get(5) + " - " + results.get(5) + "개"
                + "\n" + map.get(4) + " - " + results.get(4) + "개"
                + "\n" + map.get(3) + " - " + results.get(3) + "개"
                + "\n" + map.get(2) + " - " + results.get(2) + "개"
                + "\n" + map.get(1) + " - " + results.get(1) + "개"
                + "\n" + calculateMoney();
    }

    private String calculateMoney() {

        double totalMoney = results.get(1)*2000000000 +
                results.get(2)*30000000 +
                results.get(3)*1500000 +
                results.get(4)*50000 +
                results.get(5)*5000
                ;
        System.out.println(totalMoney);
        System.out.println(ordinalMoney);
        double price = (totalMoney / ordinalMoney) * 100;
        return "총 수익률은 " + price + "%입니다.";
    }

}
