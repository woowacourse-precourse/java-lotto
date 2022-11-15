package lotto;

import lotto.Lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {


    static int buy_count = 0;   // 구매하는 로또의 개수
    static Scanner s = new Scanner(System.in);
    static int[] win_number;
    static int bonus_number;
    static List<Lotto> my_lotto = new ArrayList<Lotto>();   // 내가 구매한 로또의 번호를 저장해주는 리스트.
    static long winning_money = 0;
    static int[] winning_status = new int[5]; // 각 등수별로 몇번 당첨되었는지 출력.


    public static void make_winning_number(){  //당첨번호와 보너스 번호를 생성하는 함수
        System.out.println("당첨 번호를 입력해 주세요.");
        String k = Console.readLine();
        String temp[] = k.split(",");
        for(int i = 0 ; i < temp.length ; i++){
            win_number[i] = Integer.parseInt(temp[i]);
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        String tt = Console.readLine();
        bonus_number = Integer.parseInt(tt);
    }


    public static boolean check_winning_number_is_valid(){  
        boolean valid = true;
        for(int i = 0 ; i < win_number.length ; i++){           // 당첨번호가 유효한 범위에 있는지
            if(win_number[i] > 45 || win_number[i] <= 0) valid = false;
        }
        if(bonus_number > 45 || bonus_number <= 0) valid = false;    // 보너스 번호가 유효한 범위에 있는지
        if(!valid) { 
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return valid;
    }


    public static void make_my_number(){
        for(int i = 0 ; i < buy_count ; i++){
            List<Integer> temp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto k = new Lotto(temp);
            my_lotto.add(k);
        }
    }

    
    public static int check_number_if_winning(List<Integer> k){
        int price = -1;
        boolean bonus = false;
        for(var i : k){
            int count = 0;
            if(k.contains(i)) price++;
            if(bonus_number == i) bonus = true;
        }
        if(price == 6) return 4;
        if(price == 3 || price == 4) return price - 3;
        if(price == 5 && bonus) return 3;
        if(price == 5 && !bonus) return 2;
        return price;
    }


    public static void count_winning_status(){
        for(int i = 0; i < buy_count ; i++){
            //List<Integer> test = my_lotto.get(i);
            Lotto tt = my_lotto.get(i);
            List<Integer> temp = tt.give_number();
            int price = check_number_if_winning(temp);
            if(price != -1) winning_status[price]++;
        }
    }


    public static void cal_winning_money(){
        winning_money += 5000 * winning_status[0];
        winning_money += 50000 * winning_status[1];
        winning_money += 1500000 * winning_status[2];
        winning_money += 30000000 * winning_status[3];
        winning_money += 2000000000 * winning_status[4];
    }


    public static void print_winning_status(){
        System.out.println("당첨 통계\n---");
        System.out.print("3개 일치 (5,000원) - "+winning_status[0]+"개");
        System.out.print("4개 일치 (50,000원) - "+winning_status[1]+"개\n");
        System.out.print("5개 일치 (1,500,000원) - "+winning_status[2]+"개\n");
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - "+winning_status[3]+"개\n");
        System.out.print("6개 일치 (2,000,000,000원) - "+winning_status[4]+"개\n");
        System.out.printf("총 수익률은 %.1f입니다.\n", winning_money / (buy_count * 1000) * 100 );
    }


    public static void run(){
        System.out.println("구입금액을 입력해 주세요.");
        String tt = Console.readLine();
        buy_count = Integer.parseInt(tt);
        buy_count /= 1000;
        System.out.println(buy_count+"개를 구매했습니다.");
        make_my_number();
        make_winning_number();
        if (check_winning_number_is_valid()){
            count_winning_status();
            cal_winning_money(); // 전체 당첨금 계산
        }
    }


    public static void main(String[] args) {
        run();
    }
}