package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {

    enum RANK {
        NOTHING("0"),FIVE("5000"), FOUR("50000"), THREE("1500000"),
        TWO("30000000"), ONE("2000000000");

        final private String prize;
        public String getPrize(){
            return prize;
        }
        private RANK(String prize){
            this.prize = prize;
        }
    }

    void run(){
        Input input = new Input();
        int playerMoney = input.inputMoney();
        Money money = new Money(playerMoney);

        int numberOfLottos = money.numberOfPurchase();
        List<Lotto> purchasedLottos = lottos(numberOfLottos);
    }

    List<Lotto> lottos(int numberOfLotto){
        List<Lotto> purchasedLotto = new ArrayList<>();
        for(int loop = 0; loop < numberOfLotto; loop++){
            Input input = new Input();
            List<Integer> numbers = input.randomLottoNumber();
            Lotto lotto = new Lotto(numbers);
            purchasedLotto.add(lotto);
        }
        return purchasedLotto;
    }

    List<RANK> result(List<Lotto> lottos, List<Integer> winNumber, int bonusNumber){
        List<RANK> ranks = new ArrayList<>();
        for(Lotto playerNumber : lottos){
            RANK rank = countRank(playerNumber,winNumber,bonusNumber);
            ranks.add(rank);
        }
        return ranks;
    }

    RANK countRank(Lotto playerLotto, List<Integer> winNumber, int bonusNumber){
        int countSame = playerLotto.countSameNumber(winNumber);
        boolean bonus = playerLotto.isBonusNumber(bonusNumber);
        RANK rank = lookForRank(countSame, bonus);
        return rank;
    }

    RANK lookForRank(int countSame, boolean bonus){
        if(countSame < 3) return RANK.NOTHING;
        if(countSame == 3 && !bonus) return RANK.FIVE;
        if(countSame == 4 && bonus) return RANK.TWO;
        if(countSame == 4) return RANK.FOUR ;
        if(countSame == 5 && !bonus) return RANK.THREE;
        return RANK.ONE;
    }

    int calculatePrize(List<RANK> ranks){
        int sumOfPrize = 0;
        for(RANK rank : ranks){
            int prize = Integer.parseInt(rank.getPrize());
            sumOfPrize += prize;
        }
        return sumOfPrize;
    }

}
