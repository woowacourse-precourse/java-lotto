package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Exception {
    public enum ErrorMessage {
        ERROR_MESSAGE("[ERROR] "),
        SIZE_ERROR("로또의 당첨 번호는 6개여야 합니다."),
        NO_DUPLICATED("로또의 당첨 번호는 중복되면 안됩니다."),
        WRONG_INPUT_ERROR("구입 금액은 1000원 단위로 입력해야 합니다.");
        private final String message;
        ErrorMessage(String message) {
            this.message = message;
        }
        public String print() {
            return (ERROR_MESSAGE.message + message);
        }
    }

    private boolean validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Exception.ErrorMessage.SIZE_ERROR.print());
        }
        return true;
    }
    public static boolean checkMoney(String Money){
        if(Integer.valueOf(Money)%1000 != 0){
            throw new IllegalArgumentException(Exception.ErrorMessage.WRONG_INPUT_ERROR.print());
        }
        return true;
    }
    public static void checkWinNumber(List<Integer> winNumber){
        Set<Integer> numSet = new HashSet<>(winNumber);
        if(numSet.size() != winNumber.size()){
            throw new IllegalArgumentException(Exception.ErrorMessage.NO_DUPLICATED.print());
        }
    }
    public static boolean checkChar(char n){
        if( !(n>='0'&& n<='9')){
            System.out.println(Exception.ErrorMessage.WRONG_INPUT_ERROR.print());
            throw new NoSuchElementException();
        }
        return true;
    }
}
