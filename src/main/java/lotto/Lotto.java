package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.Input.input;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List randomLottoNum(){
        List<Integer> randomLotto = new ArrayList<>();

        int num = 0;
        while(num != 6){
            int number = Randoms.pickNumberInRange(1, 45);
            if(!randomLotto.contains(number)){
                num++;
                randomLotto.add(number);
            }
        }
        return randomLotto;
    }

    public static List<List<Integer>> makeLotto(int num) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < num; i ++){
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            lotto = lotto.stream().sorted().collect(Collectors.toList());
            lottos.add(lotto);
        }

        return lottos;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNotDuplicate(numbers);
        checkRangeLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
    public static void validateNotDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void checkRangeLottoNumber(List<Integer> numbers) {
        final int start = 1;
        final int end = 45;
        for (int number : numbers) {
            if (!(number >= start || number <= end)) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }


    public static int lottoNum(int money){
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR]");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }

        int num = money / 1000;

        System.out.println(num + "개를 구매했습니다.");
        return num;
    }

    public static List statistics(List<List<Integer>> lottos, List<Integer> prize, int bonus) {
        List<Integer> result = new ArrayList<>();
        for (int lottoNum = 0; lottoNum < lottos.size(); lottoNum++) {
            int num = 0;
            int count = 0;
            for (int index = 0; index < lottos.get(lottoNum).size(); index++) {

                if (prize.get(num) == lottos.get(lottoNum).get(index)) {
                    count++;
                    num++;
                }
            }
            if(count == 5){
                for (int index = 0; index < lottos.get(lottoNum).size(); index++) {
                    if (bonus == lottos.get(lottoNum).get(index)) {
                        count = 7;
                    }
                }
            }

            result.add(count);
            //System.out.println("result: " + result.toString());
        }
        return result;
    }

    public static int statisticsFinal(List<Integer> result) {
        int[] count = new int[5];
        for(int index = 0; index < result.size(); index++){
            if(result.get(index) == 3){
                count[0] += 1;
            }

            if(result.get(index) == 4){
                count[1] += 1;
            }

            if(result.get(index) == 5){
                count[2] += 1;
            }

            if(result.get(index) == 7){
                count[3] += 1;
            }

            if(result.get(index) == 6){
                count[4] += 1;
            }
        }
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + count[0]);
        System.out.println("4개 일치 (50,000원) - " + count[1]);
        System.out.println("5개 일치 (1,500,000원) - " + count[2]);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count[3]);
        System.out.println("6개 일치 (2,000,000,000원) - " + count[4]);

        int sum = 0;

        sum += count[0] * 5000;
        sum += count[1] * 50000;
        sum += count[2] * 1500000;
        sum += count[3] * 30000000;
        sum += count[4] * 2000000000;

        return sum;

    }

    public static void rate(int prizeAmount, int total){
        double rate = prizeAmount / total;
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "입니다.");
    }



    // TODO: 추가 기능 구현
}
