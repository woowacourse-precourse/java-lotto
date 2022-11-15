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
    static String hit3 = "3개 일치 (5,000원) - ";
    static String hit4 = "4개 일치 (50,000원) - ";
    static String hit5 = "5개 일치 (1,500,000원) - ";
    static String hit5_bonus = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    static String hit6 = "6개 일치 (2,000,000,000원) - ";
    static List<String> keys = List.of(hit3,hit4,hit5,hit5_bonus,hit6);
    public static void main(String[] args) {
        String inputmoney = InputMoney();
        int lotto_count = CheckUnit(inputmoney);
        LottoNumber(lotto_count);
        PrintLotto(lottos);
        List<Integer> win_numbers = InputNumber();
        int bonus_number = BonusNumber();
        MakeMap(keys);
        for(Lotto lotto : lottos){
            int count = CompareNumber(lotto,win_numbers);
            boolean bonus = CompareBonus(lotto, bonus_number);
            String win = CountWin(count,bonus);
            if(win != null){
                win_list.put(win,win_list.get(win) + 1);
            }
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

    public static boolean CompareBonus(Lotto lotto, int bonus_number){
        for(int number : lotto.GetNumbers()){
            if(number == bonus_number) {
                return true;
            }
        }
        return false;
    }
    public static void MakeMap(List<String> keys){
        for(String key : keys){
            win_list.put(key,0);
        }
    }
    public static String CountWin(int count, boolean bonus){
        if (count == 3){
            return hit3;
        }
        if (count == 4){
            return hit4;
        }
        if (count == 5){
            if (bonus == true){
                return hit5_bonus;
            }
            return hit5;
        }
        if (count == 6){
            return hit6;
        }
        return null;
    }

    public static void PrintWin(){

    }

    public static int CalculateMoney(){

    }
}

