package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LottoController {

    public void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validate(input);
        int money = Integer.parseInt(input);
        int count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = makeLotto(count);
        for (int i=0;i<count;i++){
            System.out.println(lottos.get(i).getNumbers());
        }
        getInput(lottos);
    }

    public void getInput(List<Lotto> lottos) {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        inputValueVerificate(input);
        List<Integer> numbers = new ArrayList<>();
        for (String number:input.split(",")){
            numbers.add(Integer.parseInt(number));
        }
        Lotto userLotto = new Lotto(numbers);
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonuseInput = Console.readLine();
        bonusValidate(bonuseInput, userLotto);
        calculateLotto(lottos, userLotto.getNumbers(), Integer.parseInt(bonuseInput));
    }

    public List<Lotto> makeLotto(int count){
        List <Lotto> lottos = new ArrayList<>();
        for (int i=0;i<count;i++){
            Lotto lotto = new Lotto(createRandomNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public void calculateLotto(List<Lotto> lottos, List<Integer> userLotto, int bonusNum) {
        LottoService lottoService = new LottoService();
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<lottos.size();i++){
            int count = lottoService.matchNumbers(lottos.get(i).getNumbers(), userLotto);
            boolean isBonusMatch = lottoService.matchBonus(lottos.get(i).getNumbers(), bonusNum);
            if (count == 5 && isBonusMatch) {
               count = 7;
            }
            result.add(count);
        }
        List<Integer> answer = winningResult(result);
        resultPrint(answer);
    }

    public void resultPrint(List<Integer> answer){
        int winnings = 0;
        for (int i=0;i<5;i++){
            System.out.println(Prize.values()[i].getMessage() + answer.get(i)+ "개");
            winnings += (Prize.values()[i].getReward() * answer.get(i));
        }
    }

    public void printProfit(int winnings, int money){
        double reward = ((double)winnings/(double)money)*100.0;
        System.out.println("총 수익률은 " + Math.round(reward*10.0)/10.0+"%입니다.");
    }

    public List<Integer> winningResult(List<Integer> result){
        List<Integer> answer = Arrays.asList(0, 0, 0, 0, 0);
        System.out.println(result);
        for (Integer number:result){
            if (number == 3) {
                Integer tmp = answer.get(0);
                answer.set(0, tmp + 1);
            }
            if (number == 4) {
                Integer tmp = answer.get(1);
                answer.set(1, tmp + 1);
            }
            if (number == 5) {
                Integer tmp = answer.get(2);
                answer.set(2, tmp + 1);
            }
            if (number == 7){
                Integer tmp = answer.get(3);
                answer.set(3, tmp + 1);
            }
            if (number == 6) {
                Integer tmp = answer.get(4);
                answer.set(4, tmp + 1);
            }
        }
        return answer;
    }

    public void bonusValidate(String input, Lotto userLotto) {
        if (!isNumeric(input)){
            throw new IllegalArgumentException();
        }
        int bonusNum = Integer.parseInt(input);
        for (Integer number:userLotto.getNumbers()) {
            if (number == bonusNum) {
                throw new IllegalArgumentException();
            }
        }
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public void validate(String input) {
        if (!isNumeric(input)){
            throw new IllegalArgumentException();
        }
        int money = Integer.parseInt(input);
        if (money%1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void inputValueVerificate(String input) {
        String pattern = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> createRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
