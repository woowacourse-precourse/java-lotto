package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static config.Error.*;

public class Application {

    static String InputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    static String InputWinningNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    static List<Integer> SeparateInput(String input){
        String[] inputs = input.split(",");
        List<Integer> winningNum = new ArrayList<>();
        if(inputs.length != 6) throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_INPUT_NUM);
        for(int i=0; i<6; i++){
            Integer num = stringToInt(inputs[i]);
            winningNum.add(num);
        }
        return winningNum;
    }

    public static int stringToInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_INTEGER);
        }
    }

    static List<Integer> InputWinningNumException(List<Integer>input) throws IllegalArgumentException{
        List<Integer> winningNum = new ArrayList<>();
        for(int i=0; i<6; i++){
            if(input.get(i) < 1 || input.get(i) > 45) {
                System.out.println(ERROR_MESSAGE+ERROR_NUM_RANGE);
                throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_NUM_RANGE);
            }
            if(winningNum.contains(input.get(i))) {
                System.out.println(ERROR_MESSAGE+ERROR_DUPLICATION_NUM);
                throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_DUPLICATION_NUM);
            }
            winningNum.add(input.get(i));
        }
        return winningNum;
    }

    static Integer InputMoneyException(String input) throws IllegalArgumentException{

        int money = stringToInt(input);
        if(money % 1000 == 0 ){
            return money / 1000;
        }

        System.out.println(ERROR_MESSAGE+ERROR_INPUT_MONEY);
        throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_INPUT_MONEY);
    }

    static List<Integer> RandomPicked(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    static int CompareLotto(List<Integer> lotto, List<Integer> winningNum) {
        int count = 0;
        for(int i=0; i<7; i++){
            if(lotto.contains(winningNum.get(i)) && i != 6) count +=1;
        };
        return count;
    }

    static boolean CheckBonus(List<Integer> lotto, List<Integer> winningNum) {
        boolean bonus = false;
        if(lotto.contains(winningNum.get(6))) bonus = true;
        return bonus;
    }


    static int printWinning(List<Lotto> lottoList, List<Integer> winningNum){
        int [] winning = new int[6];
        for(int i=0; i<lottoList.size(); i++){
            int count = CompareLotto(lottoList.get(i).getLotto(),winningNum);
            boolean bonus = CheckBonus(lottoList.get(i).getLotto(),winningNum);
            winning[CheckWinning(count, bonus)]++;
        }
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Winning.FIFTH.getMatch()+" - "+winning[Winning.FIFTH.getRanking()]+"개");
        System.out.println(Winning.FOURTH.getMatch()+" - "+winning[Winning.FOURTH.getRanking()]+"개");
        System.out.println(Winning.THIRD.getMatch()+" - "+winning[Winning.THIRD.getRanking()]+"개");
        System.out.println(Winning.SECOND.getMatch()+" - "+winning[Winning.SECOND.getRanking()]+"개");
        System.out.println(Winning.FIRST.getMatch()+" - "+winning[Winning.FIRST.getRanking()]+"개");
        return CalculateProfit(winning);
    }

    static int CalculateProfit(int[] winning){
        int money = 0;
        money += Winning.FIFTH.getMoney()*winning[Winning.FIFTH.getRanking()];
        money += Winning.FOURTH.getMoney()*winning[Winning.FOURTH.getRanking()];
        money += Winning.THIRD.getMoney()*winning[Winning.THIRD.getRanking()];
        money += Winning.SECOND.getMoney()*winning[Winning.SECOND.getRanking()];
        money += Winning.FIRST.getMoney()*winning[Winning.FIRST.getRanking()];
        return money;
    }

    static int CheckWinning(int count, boolean bonus){
        if(count < 3) return 0;
        if(count == 3) return 5;
        if(count == 4) return 4;
        if(count == 5 && bonus) return 3;
        if(count == 5 && !bonus) return 2;
        if(count == 6 && bonus) return 1;
        return 0;
    }

    public static void main(String[] args) {
        String inputMoney = InputMoney();
        int chance = InputMoneyException(inputMoney);
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<chance; i++){
            Lotto lotto = new Lotto(RandomPicked());
            lottoList.add(lotto);
            System.out.println(lotto.getString());
        }
        String inputWinningNum = InputWinningNum();
        List<Integer> winningNum = SeparateInput(inputWinningNum);
        InputWinningNumException(winningNum);
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = stringToInt(Console.readLine());
        if(winningNum.contains(bonus)) throw new IllegalArgumentException();
        winningNum.add(stringToInt(Console.readLine())); // 보너스 번호 입력

        float profit=  Math.round((float)printWinning(lottoList,winningNum)*100/stringToInt(inputMoney)*100/100.0);

        System.out.println("총 수익률은 "+profit+"%입니다.");
    }
}
