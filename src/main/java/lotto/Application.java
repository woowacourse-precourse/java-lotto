package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean validationCheck(int money){
        return money % 1000 == 0;
    }

    public static List<Lotto> createLottos(int money){
        int numberOfGames = money / 1000;
        List<Lotto> Lottos = new ArrayList<>();

        for(int i=0; i<numberOfGames; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            Lottos.add(lotto);
        }
        return Lottos;
    }

    public static double compareMyLotto(Lotto lotto, List<Integer> winningNumber, Integer bonusNumber){
        double count = 0;
        for(Integer eachNumber: lotto.asList()){
            if(winningNumber.contains(eachNumber)){
                count += 1;
            }
        }

        if(count == 5 || lotto.asList().contains(bonusNumber)){
            count += 0.5;
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
