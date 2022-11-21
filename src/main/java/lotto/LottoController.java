package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LottoController {

    public static InputService inputService = new InputService();
    public static LottoService lottoService = new LottoService();

    public void lottoPlay() {
        int money = getMoney();
        int count = getCount(money);
        List<Lotto> lottos = getLotto(count);
        Lotto userLotto = getLottoNumber();
        int bonusNumber = getBonusNumber(userLotto);
        List<Integer> countResult = lottoService.calculateLotto(lottos, userLotto, bonusNumber);
        List<Integer> answer = lottoService.winningResult(countResult);
        printResult(answer);
        int winnings = getWinnings(answer);
        printProfit(winnings,money);
    }

    public List<Lotto> getLotto(int count) {
        List<Lotto> lottos = lottoService.makeLotto(count);
        for (int i=0;i<count;i++){
            System.out.println(lottos.get(i).getNumbers());
        }
        return lottos;
    }

    public int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        inputService.moneyValidate(input);
        return Integer.parseInt(input);
    }

    public int getCount(int money){
        int count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    public Lotto getLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        inputService.lottoInputValidate(input);
        List<Integer> numbers = new ArrayList<>();
        for (String number:input.split(",")){
            numbers.add(Integer.parseInt(number));
        }
        return new Lotto(numbers);
    }

    public int getBonusNumber(Lotto userLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonuseInput = Console.readLine();
        inputService.bonusValidate(bonuseInput,userLotto);
        return Integer.parseInt(bonuseInput);
    }

    public void printResult(List<Integer> answer){
        for (int i=0;i<5;i++){
            System.out.println(Prize.values()[i].getMessage() + answer.get(i)+ "개");
        }
    }

    public int getWinnings(List<Integer> answer){
        int winnings = 0;
        for (int i=0;i<5;i++){
            winnings += (Prize.values()[i].getReward() * answer.get(i));
        }
        return winnings;
    }

    public void printProfit(int winnings, int money){
        double reward = ((double)winnings/(double)money)*100.0;
        System.out.println("총 수익률은 " + Math.round(reward*10.0)/10.0+"%입니다.");
    }

}
