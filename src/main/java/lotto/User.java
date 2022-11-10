package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> lottos;
    private List<Winning> winnings;
    private int lottoNum;
    private int money;
    private int earn;


    public User(int money) {
        validateMoney(money);

        this.money = money;
        this.lottoNum = money / 1000;
        generateLottos();
        this.winnings = new ArrayList<>();
        this.earn = 0;
    }


    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void generateLottos() {
        this.lottos = new ArrayList<Lotto>();

        for (int i = 0; i < this.lottoNum; i++) {
            Lotto lotto = Lotto.generate();

            lottos.add(lotto);
        }
    }

    public void printLottos() {
        System.out.println(lottoNum + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }



}
