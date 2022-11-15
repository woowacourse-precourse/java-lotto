package lotto;

import java.util.NoSuchElementException;

public class Exception {

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String ERROR_LOTTO_NUM_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MONEY_INPUT_MESSAGE = "금액에 숫자가 아닌 값이 포함되어 있습니다.";
    private static final String ERROR_MONEY_MESSAGE = "금액은 1000원 이상, 1000원 단위로 입력해주세요.";

    private static final Integer ERROR_LOTTO_START = 1;
    private static final Integer ERROR_LOTTO_END = 45;


    public static void checkMoneyIncludeString(String userMoney) throws IllegalArgumentException {
        try{
            Integer.parseInt(userMoney);
        } catch (NumberFormatException e){
            System.out.println(ERROR_MESSAGE + ERROR_MONEY_INPUT_MESSAGE);
            throw new NoSuchElementException();
        }catch (NoSuchElementException e){
            System.out.println(ERROR_MESSAGE + ERROR_MONEY_INPUT_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void checkMoney(String userMoney) throws IllegalArgumentException{
        if(Integer.parseInt(userMoney) < 1000 || Integer.parseInt(userMoney) % 1000 != 0){
            System.out.println(ERROR_MESSAGE + ERROR_MONEY_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void checkBonusNumber(String bonusNumber) throws IllegalArgumentException {
        try{
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e){
            System.out.println(ERROR_MESSAGE + ERROR_MONEY_INPUT_MESSAGE);
            throw new NoSuchElementException();
        }catch (NoSuchElementException e){
            System.out.println(ERROR_MESSAGE + ERROR_MONEY_INPUT_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void checkBonusNumberRange(String bonusNumber) throws IllegalArgumentException {
        if(Integer.parseInt(bonusNumber) < ERROR_LOTTO_START || Integer.parseInt(bonusNumber) > ERROR_LOTTO_END){
            System.out.println(ERROR_MESSAGE + ERROR_LOTTO_NUM_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
