package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    static final Integer lottoPrice = 1000;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("구매금액을 입력해 주세요");
        String input = sc.nextLine();
        validateInput(input);

        Integer money = Integer.parseInt(input);
        validateMoney(money);
        Integer nums = money/lottoPrice;

        List<Lotto> lottos = new ArrayList<>();
        for(int num = 0; num<nums; num++) {
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto =new Lotto(lottoNums);
            lotto.printNumbersOfLotto();
            lottos.add(lotto);
        }

        System.out.println("당첨 번호를 입력해 주세요");
        String winNumberString = sc.nextLine();
        List<String> splitWinNumbersString = Arrays.stream(winNumberString.split(","))
                .collect(Collectors.toList());
        validateSplitWinNumbersString(splitWinNumbersString);
        List<Integer> winNumbers = converseWinNumbersToInteger(splitWinNumbersString);



    }

    static void validateSplitWinNumbersString(List<String> splitWinNumbersString) {
        if(splitWinNumbersString.size()!=6){
            System.out.println("[ERROR] 당첨 번호를 정확히 입력해 주시기 바랍니다.");
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 정확히 입력해 주시기 바랍니다.");
        }
    }

    static List<Integer> converseWinNumbersToInteger(List<String> splitWinNumbersString ){
        List<Integer> winNumbers;
        try {
            winNumbers = splitWinNumbersString.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        }catch (Throwable e){
            System.out.println("[ERROR] 당첨 번호를 정확히 입력해 주시기 바랍니다.");
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 정확히 입력해 주시기 바랍니다.");
        }
        return winNumbers;
    }
    static void validateInput(String inputMoney){
        try{
            Integer money = Integer.parseInt(inputMoney);
        }catch(Throwable e){
            System.out.println("[ERROR] 금액을 정확히 입력해 주시기 바랍니다.");
            throw new IllegalArgumentException("[ERROR] 금액을 정확히 입력해 주시기 바랍니다.");
        }
    }

    static void validateMoney(Integer money){
        if(money%1000 != 0){
            System.out.println("[ERROR] 1000원 단위로 금액을 입력해 주시기 바랍니다.");
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 금액을 입력해 주시기 바랍니다.");
        }
    }
}
