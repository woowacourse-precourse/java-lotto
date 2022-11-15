package lotto.Validate;

import java.util.*;
import lotto.Constant.*;

public class HandleException {
    public HandleException(){}
    public static void NotDividedBy1000(int inputmoney){
        if (inputmoney % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.INVALID_1000X.print());
    }

    public static <T> void DuplicatedNum(List<T> Check){
        int len = Check.size();
        for (int i = len - 1; i >= 0; i--) {
            if (Check.indexOf(Check.get(i)) != i)
                throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATED.print());
        }
    }

    public static <T> void InputArgsNum(List<T> Check, int maxArgc){
        if (Check.size() != maxArgc)
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUTARGSNUM.print());
    }
}
