package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private static final int lottoStart = 1;
    private static final int lottoEnd = 45;
    private static final int lottoCount = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumberSize(numbers);
        for(int number : numbers){
            checkNumberInterval(number);
            checkDuplicate(numbers, number);
        }
    }

    private void checkNumberSize(List<Integer> numbers){
        if (numbers.size() != lottoCount)
            Error.error(Error.errMsg_WrongLottoSize);
    }

    private void checkNumberInterval(int number){
        if(number < lottoStart || number > lottoEnd)
            Error.error(Error.errMsg_WrongLottoNumber);
    }

    private void checkDuplicate(List<Integer> numbers, int number){
        if(Collections.frequency(numbers,number) >= 2)
            Error.error(Error.errMsg_ExistSameNumber);
    }


    public static List<Lotto> purchaseLotto(int count){
        List<Lotto> lottos = getRandomLotto(count);
        printLotto(lottos);
        return lottos;
    }

    public static void printLotto(List<Lotto> lottos){
        System.out.println(String.format(PrintMessage.resultPurchasingAmount, lottos.size()));

        for(Lotto lotto : lottos){
            System.out.println(lotto.numbers.toString());
        }
    }

    private static List<Lotto> getRandomLotto(int count){
        List<Lotto> lottos = new ArrayList<>();
        for(int i =0; i < count; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(lottoStart, lottoEnd, lottoCount);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public static int countSameNumber(Lotto target, Lotto winning){
        int count = 0;
        for(int num : target.numbers){
            if(winning.numbers.contains(num))
                count++;
        }
        return count;
    }

    public static boolean checkBonus(Lotto target, int bonus){
        if(target.numbers.contains(bonus))
            return true;

        return false;
    }

    public boolean checkContainNumber(int num){
        if(numbers.contains(num))
            return true;

        return false;
    }
}
