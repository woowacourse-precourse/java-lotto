package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoCount = validateBudget(Console.readLine());
        List<Lotto> lottoArray = generateLottoNumbers(lottoCount);
    }

    public static int validateBudget(String input){
        int budget = 0;
        try{
            budget = Integer.parseInt(input);
        }catch(Exception e){throwException("구입 금액은 숫자이어야 합니다.");}
        if (budget % 1000 != 0) throwException("구입 금액은 1000의 배수여야 합니다.");
        System.out.println("\n" + (budget/1000) + "개를 구매했습니다.");
        return (budget / 1000);
    }

    public static List<Lotto> generateLottoNumbers(int count){
        List<Lotto> lottoArray = new ArrayList<>();
        for(int i=0; i<count; i++){
            List<Integer> numberList = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lotto = new Lotto(numberList);
            lottoArray.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return lottoArray;
    }

    public static void throwException(String message){
        System.out.println("[ERROR] " + message);
        throw new IllegalArgumentException();
    }

}
