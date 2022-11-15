package lotto.domain;

import java.util.List;

public class LottoCard {

    private long lottoCardNum;
    private List<Integer> lottoNums;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public LottoCard(long money) {
        lottoCardNum = money / 1000;
        System.out.println("\n" + lottoCardNum + "개를 구매했습니다.");
        generateRandomLottoNum();
    }

    private void generateRandomLottoNum() {
        for (int i = 0; i < lottoCardNum; i++) {
            lottoNums = randomNumberGenerator.generateRandomNumber();
            System.out.println(lottoNums);
        }
    }

}
