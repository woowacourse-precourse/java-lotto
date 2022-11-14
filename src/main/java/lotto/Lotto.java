package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

import javax.print.attribute.standard.MediaSize;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void game(){
        int cost;
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();

        Output.printCost();
        cost = Integer.parseInt(Console.readLine());
        int cnt = Output.printOrder(cost);
        //로또 생성
        total=MakeLotto.totallotto(cnt);

        //당청 번호 입력 받기

        String lottonum;
        int bonus;
        Output.printNum();
        lottonum = Console.readLine();
        String[] lottolst = lottonum.split(",");

        Output.printBonus();
        //보너스 번호 입력받기
        bonus = Integer.parseInt(Console.readLine());

        int[] result = CompareLotto.comparelotto(total,lottolst,bonus);
        Output.printResult(result);






    }
    // TODO: 추가 기능 구현
}
