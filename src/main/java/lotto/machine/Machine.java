package lotto.machine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.UI;
import static lotto.ui.ErrorMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Machine {
    private Integer Money;
    private Integer Lotto_count;
    private List<Lotto> lotto = new ArrayList<>();
    private List<Integer> Winning_numbers;
    private Integer Bonus;
    private List<Integer> correct_numbers = new ArrayList<>();
    private List<Integer> statistics = new ArrayList<>();
    private Double rate;
    private Integer winning_money;
    private final Integer correct_3 = 5000;
    private final Integer correct_4 = 50000;
    private final Integer correct_5 = 1500000;
    private final Integer correct_Bonus = 30000000;
    private final Integer correct_6 = 2000000000;

    public Machine() {
        winning_money = 0;
    }

    public void run() {
        Insert();
        Generate();
        Winning_numbers();
        Compare();
        Calculate_rate();
    }

    public void Insert() {
        UI.insert_money();
        insert_money();
        UI.money(Money);
    }

    private void insert_money() {
        try {
            Money =  Integer.valueOf(Console.readLine());
        }catch (Exception err){
            throw new IllegalArgumentException(MONEY_FORM_ERROR.getErrorMessage());
        }
        ValidCheck.money(Money);
    }

    public void Generate() {
        count_lotto(Money);
        UI.lotto_count(Lotto_count);
        generate_lotto(Lotto_count);
        UI.lotto(lotto);
    }

    private void count_lotto(Integer money) {
        Lotto_count = money/1000;
    }

    private void generate_lotto(Integer lotto_count) {
        for(int count = 0; count<lotto_count; count++) {
            Lotto numbers = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotto.add(numbers);
        }
    }

    public void Winning_numbers() {
        UI.insert_Winning_number();
        insert_winning_numbers();
        UI.Winning_number(Winning_numbers);
        insert_Bonus_number();
    }

    private void insert_winning_numbers() {
        Winning_numbers = Insert_Winning_numbers();
        Winning_number_validate(Winning_numbers);
    }

    public List<Integer> Insert_Winning_numbers() {
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void Winning_number_validate(List<Integer> Winning_numbers) {
        ValidCheck.Lotto_length(Winning_numbers);
        ValidCheck.Lotto_range(Winning_numbers);
        ValidCheck.Lotto_duplicated(Winning_numbers);
    }

    private void insert_Bonus_number() {
        try {
            Bonus = Integer.valueOf(Console.readLine());
        }catch (NumberFormatException err){
            throw new IllegalArgumentException(BONUS_FORM_ERROR.getErrorMessage());
        }
        ValidCheck.Bonus(Bonus, Winning_numbers);
    }

    public void Compare() {
        compare_Winning_numbers();
        compare_Bonus_number();
        statistic_3();
        statistic_4();
        statistic_5();
        statistic_Bonus();
        statistic_6();
        UI.statistics(statistics);
    }

    private void compare_Winning_numbers() {
        for(int index = 0; index<lotto.size(); index++) {
            correct_numbers.add(lotto.get(index).compare(Winning_numbers));
        }
    }

    private void compare_Bonus_number() {
        List<Integer> Bonus_index = Bonus_index(correct_numbers);
        for(int index = 0; index<Bonus_index.size(); index++) {
            if(lotto.get(Bonus_index.get(index)).compare(Bonus)) correct_numbers.set(Bonus_index.get(index), 7);
        }
    }

    private List<Integer> Bonus_index(List<Integer> correct_numbers) {
        List<Integer> Bonus_index = new ArrayList<>();
        for(int index = 0; index<correct_numbers.size(); index++) {
            if(correct_numbers.get(index) == 5) Bonus_index.add(index);
        }

        return Bonus_index;
    }

    private void statistic_3() {
        Integer correct_3 = 0;
        for(int index = 0; index<correct_numbers.size(); index++) {
            if(correct_numbers.get(index) == 3) correct_3++;
        }
        statistics.add(correct_3);
    }

    private void statistic_4() {
        Integer correct_4 = 0;
        for(int index = 0; index<correct_numbers.size(); index++) {
            if(correct_numbers.get(index) == 4) correct_4++;
        }
        statistics.add(correct_4);
    }

    private void statistic_5() {
        Integer correct_5 = 0;
        for(int index = 0; index<correct_numbers.size(); index++) {
            if(correct_numbers.get(index) == 5) correct_5++;
        }
        statistics.add(correct_5);
    }

    private void statistic_Bonus() {
        Integer correct_Bonus = 0;
        for(int index = 0; index<correct_numbers.size(); index++) {
            if(correct_numbers.get(index) == 7) correct_Bonus++;
        }
        statistics.add(correct_Bonus);
    }

    private void statistic_6() {
        Integer correct_6 = 0;
        for(int index = 0; index<correct_numbers.size(); index++) {
            if(correct_numbers.get(index) == 6) correct_6++;
        }
        statistics.add(correct_6);
    }

    public void Calculate_rate() {
        winning_money();
        rate();
        UI.rate(rate);
    }

    private void rate() {
        rate = ((double)winning_money/Money)*100;
    }

    private void winning_money() {
        correct_3_money();
        correct_4_money();
        correct_5_money();
        correct_Bonus_money();
        correct_6_money();
    }

    private void correct_3_money() {
        winning_money += correct_3 * statistics.get(0);
    }

    private void correct_4_money() {
        winning_money += correct_4 * statistics.get(1);
    }

    private void correct_5_money() {
        winning_money += correct_5 * statistics.get(2);
    }

    private void correct_Bonus_money() {
        winning_money += correct_Bonus * statistics.get(3);
    }

    private void correct_6_money() {
        winning_money += correct_6 * statistics.get(4);
    }

    public void Print_ERROR(String ERROR_MESSAGE) {
        System.out.println(ERROR_MESSAGE);
    }
}
