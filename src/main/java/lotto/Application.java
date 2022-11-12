package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    static int check_money(){
        String input_money;
        int money;
        System.out.println("구입금액을 입력해 주세요");
        input_money = Console.readLine();
        if (input_money.isBlank()) throw new IllegalArgumentException("[ERROR] 구입금액은 0원일 수 없습니다.");
        try {
            money = Integer.parseInt(input_money);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
        return money;
    }

    static int money2chance(int money){
        int chance;
        if(money % 1000 !=0) throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야합니다.");
        chance = money/1000;
        System.out.println(chance + "개를 구매했습니다.");
        return chance;
    }
    static List<Integer> make_lotto_num(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
//        Collections.sort(numbers);
        return numbers;
    }
    static List<List<Integer>> buy_lotto(int chance){
        List<List<Integer>> lotto_nums =new ArrayList<>();
        List<Integer> lotto;
        for(int i = 1 ; i <= chance ; i++){
            lotto = make_lotto_num();
            lotto_nums.add(lotto);
            System.out.println(lotto);
        }

        return lotto_nums;
    }

    static List<Integer> check_winning(String[] nums){
        List<Integer> winning_num = new ArrayList<Integer>();
        int num;
        for (int i = 0;i < nums.length;i++){
            try {
                num = Integer.parseInt(nums[i]);
                winning_num.add(num);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자여야 합니다.");
            }
        }
        return winning_num;
    }
    static List<Integer> read_winning(){
        List<Integer> winning_num;
        String num;
        String[] nums;
        int temp;

        System.out.println("당첨 번호를 입력해 주세요.");

        num = Console.readLine();
        nums = num.split(",");
        winning_num = check_winning(nums);

        return winning_num;
    }

    static int read_bonus(){
        String input_num;
        int bonus;
        System.out.println("보너스 번호를 입력해 주세요.");
        input_num = Console.readLine();
        try {
            bonus = Integer.parseInt(input_num);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개의 숫자여야 합니다.");
        }
        return bonus;
    }
    static void check_bonus(Lotto lotto,int bonus){
        lotto.check_bonus(bonus);
    }
    static boolean check_second(List<Integer>lotto_num, int bonus){
        if(lotto_num.contains(bonus)) return true;
        return false;
    }
    static float check_same_num(Lotto lotto,List<Integer> lotto_num,int bonus){
        float result;
        result = lotto.check_rank(lotto_num);
        if(result == 5f){
            if(check_second(lotto_num,bonus)) result = result + 0.5f;
        }
        return result;
    }
    static void check_result(Lotto lotto, List<List<Integer>> lotto_nums, int bonus,int money){
        List<Integer> count_rank = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
        float result;
        int price = 0;
        List<Integer> temp;
        for (int i = 0;i < lotto_nums.size();i++){
            temp = lotto_nums.get(i);
            result = check_same_num(lotto,temp,bonus);
            count_rank = count_result(count_rank,result);
            price = sum_price(price,result);
        }
//        return count_rank;
        write_result(count_rank);
        calculate_price(price,money);
    }

    static List<Integer> count_result (List<Integer> count_rank, float result){
        for(RankType r: RankType.values()){
            if(r.getNum()==result){
                count_rank.set(r.check,count_rank.get(r.check)+1);
            }
        }
        return count_rank;
    }

    static int sum_price(int price,float result){
        for(RankType r: RankType.values()){
            if(r.getNum()==result){
                price += r.getPrice();
            }
        }
        return price;
    }
    static void write_result(List<Integer> count_rank){
        System.out.println("당첨 통계");
        System.out.println("---");
        for(RankType r : RankType.values()){
            System.out.print(r.getResult() + " - "+count_rank.get(r.getCheck()) +"개\n");
//            System.out.println(" - "+count_rank.get(r.getCheck()) +"개");
        }
    }
    static void calculate_price(int price,int money){
        float result = ((float)price /(float)money) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f",result) + "%입니다.\n");

    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;
        int chance;
        List<List<Integer>> lotto_nums;
        List<Integer> winning_num;
        List<Integer> count_rank;
        int bonus;
        try {
            money = check_money();
            chance = money2chance(money);
            lotto_nums = buy_lotto(chance);
            winning_num = read_winning();
            Lotto lotto = new Lotto(winning_num);
            bonus = read_bonus();
            check_bonus(lotto,bonus);
            check_result(lotto, lotto_nums,bonus,money);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public enum RankType{
        RANK_FIFTH(0,3,"3개 일치 (5,000원)",5000),
        RANK_FOURTH(1,4,"4개 일치 (50,000원)",50000),
        RANk_THIRD(2,5,"5개 일치 (1,500,000원)",1500000),
        RANK_SECOND(3,5.5f,"5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
        RANK_FIRST(4,6,"6개 일치 (2,000,000,000원)",2000000000);
        final private int check;
        final private float num;
        final private String result;
        private final int price;

        public int getCheck(){
            return check;
        }
        public float getNum(){
            return num;
        }
        public String getResult(){
            return result;
        }
        public int getPrice(){
            return price;
        }
        private RankType(int check, float num, String result,int price){
            this.check = check;
            this.num = num;
            this.result = result;
            this.price = price;
        }

    }
}
