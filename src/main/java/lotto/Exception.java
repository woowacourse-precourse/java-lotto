package lotto;

import java.util.*;

public class Exception extends Throwable {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String ERROR_MESSAGE_MOD_ERROR = " 로또 금액은 1000원 단위로 나누어떨어져야합니다.";
    private static final String ERROR_MESSAGE_CONTAIN_STRING = " 로또 금액은 숫자로만 이루어져 있어야 합니다.";
    private static final String ERROR_MESSAGE_DUPLICATE = " 로또 발행에 중복된 수가 포함되어 있습니다.";
    private static final String ERROR_MESSAGE_LOTTO_COUNT = " 로또 발행은 6개의 숫자를 가지고 있어야합니다.";

    public void validatePrice(int price){
        if(price % 1000 != 0){
            System.out.println(ERROR_MESSAGE + ERROR_MESSAGE_MOD_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public void validateInteger(String priceString){
        try{
            Integer.parseInt(priceString);
        } catch (NumberFormatException e){
            System.out.println(ERROR_MESSAGE + ERROR_MESSAGE_CONTAIN_STRING);
            throw new NoSuchElementException();
        }
        catch (NoSuchElementException e){
            System.out.println(ERROR_MESSAGE + ERROR_MESSAGE_CONTAIN_STRING);
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicate(List<Integer> numbers){
        if(!checkDuplicate(numbers)){
            System.out.println(ERROR_MESSAGE + ERROR_MESSAGE_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicateLotto(Lotto lotto){
        if(!checkDuplicate(lotto.getNumbers())){
            System.out.println(ERROR_MESSAGE + ERROR_MESSAGE_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicateInputNumber(Set<Integer> isExist, int number){
        if(isExist.contains(number)){
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void validateLottoCount(List<Integer> numbers){
        if(numbers.size() != 6){
            System.out.println(ERROR_MESSAGE + ERROR_MESSAGE_LOTTO_COUNT);
            throw new IllegalArgumentException();
        }
    }

    private boolean checkDuplicate(List<Integer> numbers){
        Set<Integer> isDuplicate = new HashSet<>();
        for (Integer number : numbers) {
            if(isDuplicate.contains(number)) return false;
            isDuplicate.add(number);
        }
        return true;
    }


}
