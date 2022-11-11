package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private static final int lottoStart = 1;
    private static final int lottoEnd = 45;
    private static final int lottoCount = 6;
    private static final String printSalesLottoAmount = "%d개를 구매했습니다.";
    private final List<Integer> numbers;

    private static List<List<Integer>> salesLottos;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void SalesLotto(int count){
        salesLottos = new ArrayList<>();
        for(int i =0; i < count; i++){
            salesLottos.add(GetRandomLotto());
        }
        Lotto.PrintSalesLotto();
    }

    public static void PrintSalesLotto(){
        System.out.println(String.format(printSalesLottoAmount, salesLottos.size()));
        for(List<Integer> saleLotto : salesLottos){
            System.out.println(saleLotto.toString());
        }
    }

    private static List<Integer> GetRandomLotto(){
        return Randoms.pickUniqueNumbersInRange(lottoStart, lottoEnd, lottoCount);
    }
}
