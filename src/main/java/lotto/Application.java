package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Application {
    static List<Lotto> lottos = new ArrayList<>();
    static HashMap<String,Integer> win_list = new HashMap<>();
    final static int lotto_price = 1000;
    final static int min_number = 1;
    final static int max_number = 45;
    final static int lotto_size = 6;
    public static void main(String[] args) {
        String inputmoney = InputMoney();
        int lotto_count = CheckUnit(inputmoney);
        LottoNumber(lotto_count);
        PrintLotto(lottos);
        List<Integer> win_numbers = InputNumber();
        int bonus_number = BonusNumber();

        for(Lotto lotto : lottos){
            int count = CompareNumber(lotto,win_numbers);
        }
    }

    public static String InputMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        String inputmoney = Console.readLine();
        return inputmoney;
    }
    public static int CheckUnit(String inputmoney){
        try{
            Integer money = Integer.valueOf(inputmoney);
            if(money % lotto_price !=0){
                throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위입니다.");
            }
            return money/lotto_price;
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요");
        }
    }

    public static void LottoNumber(int lotto_count){
        System.out.println(lotto_count + "개를 구매했습니다.");
        for(int i =1 ; i <= lotto_count; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min_number, max_number, lotto_size);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }
    public static void PrintLotto(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto.GetNumbers());
        }
    }
    public static List<Integer> InputNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] win_number = Console.readLine().split(",");
        List<Integer> win_numbers = new ArrayList<>();
        for(String number : win_number){
            win_numbers.add(Integer.valueOf(number));
        }
        return win_numbers;
    }

    public static int BonusNumber(){
        String bonus = Console.readLine();
        return Integer.valueOf(bonus);
    }
    public static int CompareNumber(Lotto lotto, List<Integer> win_number){
        int count = 0;
        for(int number : lotto.GetNumbers()){
            if(win_number.contains(number)){
                count++;
            }
        }
        return count;
    }

    public static int CompareBonus(){

    }

    public static List<Integer> CountWin(){

    }

    public static void PrintWin(){

    }

    public static int CalculateMoney(){

    }
}

