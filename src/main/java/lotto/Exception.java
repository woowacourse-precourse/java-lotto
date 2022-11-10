package lotto;

public class Exception {

    public static void UserContainExceptNumber(String stringLottoMoney) throws IllegalArgumentException{
        for (int i=0;i<stringLottoMoney.length();i++){
            char oneNumber = stringLottoMoney.charAt(i);

            if (!Character.isDigit(oneNumber)) {
                throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
            }
        }
    }

    public static void UserMoneyDivide1000(Integer lottoMoney) throws IllegalArgumentException{

        if (lottoMoney%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 입력받은 구입금액은 천원 단위만 가능합니다.");
        }
    }

}
