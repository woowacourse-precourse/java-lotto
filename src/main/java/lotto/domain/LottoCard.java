package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCard {

    private long lottoCardNum;
    private long money;
    private List<Integer> lottoNums = new ArrayList<>();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    List<List<Integer>> lottocard = new ArrayList<>();

    public LottoCard(long money) {
        this.money = money;
        lottoCardNum = money / 1000;
        System.out.println("\n" + lottoCardNum + "개를 구매했습니다.");
        generateRandomLottoNum();
    }

    private void generateRandomLottoNum() {
        for (int i = 0; i < lottoCardNum; i++) {
            lottoNums = randomNumberGenerator.generateRandomNumber();
            System.out.println(lottoNums);
            lottocard.add(lottoNums);
        }
    }

    public List<List<Integer>> getlottocard() {
        return lottocard;
    }

    public long getMoney() {
        return money;
    }

}
