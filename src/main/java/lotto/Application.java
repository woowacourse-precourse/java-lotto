package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void validationCheck(int money) {
        if(money % 1000 != 0){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
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

    public static double compareMyLotto(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber){
        double count = 0;
        for(Integer eachNumber: lotto.asList()){
            if(winningNumbers.contains(eachNumber)){
                count += 1;
            }
        }

        if(count == 5 || lotto.asList().contains(bonusNumber)){
            count += 0.5;
        }
        return count;
    }

    public static List<Integer> getWinningNumbers(){
        String[] userInput = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for(String str : userInput){
            winningNumbers.add(Integer.parseInt(str));
        }

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return winningNumbers;
    }


    public static void main(String[] args) {
        int money = Integer.parseInt(Console.readLine());
        validationCheck(money);
        List<Lotto> Lottos = createLottos(money);

        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = Integer.parseInt(Console.readLine());
/*
        for(lotto : Lottos){
            compareMyLotto(lotto,winningNumbers,bonusNumber);
        }
*/
        // TODO: 프로그램 구현
    }
}
