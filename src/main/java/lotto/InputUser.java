package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import static lotto.ErrorMsg.ERRMSG;

public class InputUser {
    public static int inputUserPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String userPrice = Console.readLine();
        try {
            validateValue(userPrice);
            int price = Integer.parseInt(userPrice);
            divideValidate(price);
            return price;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputUserPrice();
        }
    }
    public static void validateValue(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERRMSG.getErrMsg());
        }
    }
    public static void divideValidate(int price) {
        if (price % 1000 != 0){
            throw new IllegalArgumentException(ERRMSG.getErrMsg());
        }
    }
    public static List<List<Integer>> lottoNumber(int price) {
        List<List<Integer>> result = new ArrayList<>();
        price/=1000;
        System.out.println(price+"개를 구매했습니다.");
        for (int i = 0; i < price; i++) {
            List<Integer> lottoList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(lottoList);
            result.add(lottoList);
        }
        return result;
    }
    public static List<Integer> inputLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoNo = Console.readLine();
        List<Integer> params = new ArrayList<>();
        for (String lottoN : lottoNo.split(",")) {
            validateValue(lottoN);
            int lottoNumber = Integer.parseInt(lottoN);
            validateRange(lottoNumber);
            params.add(lottoNumber);
        }
        return params;
    }
    public static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERRMSG.getErrMsg());
        }
    }
    public static int inputBonusNumber(List<Integer> lottoNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNo = Console.readLine();
        validateValue(bonusNo);
        int bonusNumber = Integer.parseInt(bonusNo);
        validateRange(bonusNumber);
        checkContainLotto(lottoNumber, bonusNumber);
        return bonusNumber;
    }
    public static void checkContainLotto(List<Integer> lottoNumber, int bonus) {
        if (lottoNumber.contains(bonus)) {
            throw new IllegalArgumentException(ERRMSG.getErrMsg());
        }
    }
}