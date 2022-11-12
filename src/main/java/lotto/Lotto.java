package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private static final int lottoStart = 1;
    private static final int lottoEnd = 45;
    private static final int lottoCount = 6;
    private static final String printSalesLottoAmount = "%d개를 구매했습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            Error.error(Error.errMsg_WrongLottoSize);

        for(int number : numbers){
            if(number < 1 || number > 45)
                Error.error(Error.errMsg_WrongLottoNumber);

            if(Collections.frequency(numbers,number) >= 2)
                Error.error(Error.errMsg_ExistSameNumber);
        }
    }

    public static List<Lotto> PurchaseLotto(int count){
        List<Lotto> lottos = GetRandomLotto(count);
        PrintLotto(lottos);
        return lottos;
    }

    public static void PrintLotto(List<Lotto> lottos){
        System.out.println(String.format(printSalesLottoAmount, lottos.size()));

        for(Lotto lotto : lottos){
            System.out.println(lotto.numbers.toString());
        }
    }

    private static List<Lotto> GetRandomLotto(int count){
        List<Lotto> lottos = new ArrayList<>();
        for(int i =0; i < count; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(lottoStart, lottoEnd, lottoCount);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }


}
