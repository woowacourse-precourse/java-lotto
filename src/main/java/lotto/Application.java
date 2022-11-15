package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.*;



public class Application {


    public static ArrayList<Lotto> get_lotto_numbers(int input_money){

        ArrayList<Lotto> lottos = new ArrayList<>();
        int number = input_money / 1000;
        System.out.printf("%d개를 구매했습니다.\n", number);

        for (int i=0; i < number; i++){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Lotto lotto = new Lotto(numbers);
            lotto.sort();
            lotto.print_lotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    public static Lotto get_lotto_answer(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String get_lotto_answer = Console.readLine();
        System.out.println(get_lotto_answer);

        List<Integer> lotto_answer = new ArrayList<Integer>();
        String[] answer_numbers = get_lotto_answer.split(",");

        for (String answer_number : answer_numbers) {
            int number = Integer.parseInt(answer_number);
            lotto_answer.add(number);}

        Lotto lotto = new Lotto(lotto_answer);
        lotto.sort();
        return lotto;
    }

    public static int bonus(Lotto lotto){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        if (lotto.return_lotto().contains(bonus)){
            System.out.println("[ERROR] 로또 번호와 보너스 번호가 동일합니다.");
            throw new IllegalArgumentException();
        }
        System.out.println(bonus);
        return bonus;
    }

    public static int verify_lotto(Lotto input_lotto, Lotto answer_lotto, int bonus){
        int matching = 0;
        boolean Bonus_exist = false;
        List<Integer> return_answer_lotto = answer_lotto.return_lotto();
        for (int i = 0; i < 6; i++){
            if (return_answer_lotto.contains(input_lotto.get_lotto_number(i))){
                matching += 1;}}
        if (return_answer_lotto.contains(bonus)){Bonus_exist = Boolean.TRUE;}
        if (matching == 3){return 5000;}
        if (matching == 4){return 50000;}
        if (matching == 5 && !Bonus_exist){return 1500000;}
        if (matching == 5){return 30000000;}
        if (matching == 6){return 2000000000;}
        return 0;
    }

    public static int[] win_lotto_number(int[] win_lotto, int input_lotto_get_money){
        if (input_lotto_get_money == 5000){
            win_lotto[0] += 1;}
        if (input_lotto_get_money == 50000){
            win_lotto[1] += 1;}
        if (input_lotto_get_money == 1500000){
            win_lotto[2] += 1;}
        if (input_lotto_get_money == 30000000){
            win_lotto[3] += 1;}
        if (input_lotto_get_money == 2000000000){
            win_lotto[4] += 1;}
        return win_lotto;
    }

    public static void print_result(int[] win_lotto, int get_money, int input_money){
        System.out.println("\n당첨 통계");
        System.out.println("---");

        System.out.printf("3개 일치 (5,000원) - %d개\n", win_lotto[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", win_lotto[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", win_lotto[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", win_lotto[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", win_lotto[4]);
        double percent = (get_money / (double) input_money) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", percent);

    }


    public static void main(String[] args) {
        int get_money = 0;

        System.out.println("구입 금액을 입력해주세요.");
        String input_money_string = Console.readLine();

        try{
            int A = Integer.parseInt(input_money_string);
            if ((A % 1000) > 0){
                throw new IllegalArgumentException();
            }
        }
        catch (NumberFormatException e){
            System.out.printf("[ERROR] 로또 구입 금액은 int 값만 받을 수 있습니다.");
            throw new NoSuchElementException();
        }
        catch (IllegalArgumentException Ie){
            System.out.printf("[ERROR] 로또 구입 금액은 1000원 단위로 받을 수 있습니다.");
            throw new NoSuchElementException();
        }
        int input_money = Integer.parseInt(input_money_string);

        ArrayList<Lotto> lottos = get_lotto_numbers(input_money);
        Lotto answer_lotto = get_lotto_answer();

        int Bonus = bonus(answer_lotto);
        int[] win_lotto = {0, 0, 0, 0, 0};

        for (int i =0; i < lottos.size(); i++){
            Lotto input_lotto = lottos.get(i);
            int input_lotto_get_money = verify_lotto(input_lotto, answer_lotto, Bonus);
            win_lotto = win_lotto_number(win_lotto, input_lotto_get_money);
            get_money += input_lotto_get_money;
        }

        print_result(win_lotto, get_money, input_money);

        // TODO: 프로그램 구현
    }
}
