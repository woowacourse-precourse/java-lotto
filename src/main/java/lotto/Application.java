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
        Lotto lottoAnswer = validateLottoAnswers(Console.readLine());
        int bonusNumber = validateBonusNumber(lottoAnswer.getNumbers(), Console.readLine());

    }

    public static int validateBudget(String input){
        int budget = 0;
        try{
            budget = Integer.parseInt(input);
        }catch(NumberFormatException e){throwException("구입 금액은 숫자이어야 합니다.");}
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

    public static Lotto validateLottoAnswers(String input){
        List<Integer> numberList = new ArrayList<>();
        String[] strings = input.split(",");
        for(int i=0; i<strings.length; i++){
            try{
                int elem = Integer.parseInt(strings[i]);
                numberList.add(elem);
            }catch(NumberFormatException e){throwException("당첨 번호는 모두 숫자이어야 합니다.");}
        }
        if(!isUniqueList(numberList)) throwException("당첨 번호는 중복되지 않아야 합니다.");
        return new Lotto(numberList);
    }

    public static boolean isUniqueList(List<Integer> numberList){
        for(int i=0; i<numberList.size(); i++){
            int elem = numberList.get(i);
            if(numberList.indexOf(elem) != numberList.lastIndexOf(elem)) return false;
        }
        return true;
    }

    public static int validateBonusNumber(List<Integer> numberList, String input){
        int bonusNumber = 0;
        try{
            bonusNumber = Integer.parseInt(input);
        }catch(NumberFormatException e){throwException("보너스 번호는 숫자이어야 합니다.");}
        if(numberList.contains(bonusNumber)) throwException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        return bonusNumber;
    }

    public static void throwException(String message){
        System.out.println("[ERROR] " + message);
        throw new IllegalArgumentException();
    }

}
