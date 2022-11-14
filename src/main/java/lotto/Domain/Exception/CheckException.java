package lotto.Domain.Exception;

import lotto.Input.LottoValue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CheckException {
    public int check_HaveChar_And_Convert(String str) {
        String pattern = "^[0-9]*$";

        if(!Pattern.matches(pattern, str)){
            throw new IllegalArgumentException(PrintException.NOT_A_NUMBER.getMessage());
        }
        return Integer.parseInt(str);
    }

    public int check_OutOfRange(int number) {
        if(number< LottoValue.MIN.getNum() || LottoValue.MAX.getNum()<number) {
            throw new IllegalArgumentException(PrintException.OUT_OF_RANGE.getMessage());
        }
        return number;
    }

    public int check_Thousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(PrintException.CANNOT_DIVIDE_THOUSAND.getMessage());
        }
        return money;
    }

    public int check_LottoSize(int size) {
        if (size != LottoValue.SIZE_No_Bonus.getNum()) {
            throw new IllegalArgumentException(PrintException.OUT_OF_SIZE.getMessage());
        }
        return size;
    }

    public int check_ListWithBonusNumSizeIsSeven(List<Integer> addedNums) {
        Set<Integer> addedNum = new HashSet<>(addedNums);

        if(LottoValue.SIZE_No_Bonus.getNum() == addedNum.size()) {
            throw new IllegalArgumentException(PrintException.BONUS_OVERLAP_LOTTONUM.getMessage());
        }

        return addedNum.size();
    }

    public int check_ListHaveNoOverlapNum(List<Integer> haveToCheck) {
        Set<Integer> noOverlap = new HashSet<>(haveToCheck);

        if(LottoValue.SIZE_No_Bonus.getNum() != noOverlap.size()) {
            throw new IllegalArgumentException(PrintException.HAVE_OVERLAP_IN_LIST.getMessage());
        }

        return noOverlap.size();
    }
}
