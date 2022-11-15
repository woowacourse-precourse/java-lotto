package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static lotto.utils.ErrorCode.INVALID_TYPE_LOTTO_NUMBER;
import static lotto.utils.ErrorCode.NOT_INT_TYPE;

public class Validator {

    public Validator() {}

    public int convertToInt(String s) {
        int result;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println(NOT_INT_TYPE.getMessage());
            throw new NoSuchElementException(NOT_INT_TYPE.getMessage());
        }
        return result;
    }

    public List<Integer> convertToIntList(String s) {
        String[] tmp_str = s.replace(" ", "").split(",");
        List<Integer> result = new ArrayList<>();
        for (String str : tmp_str) {
            int number;
            try {
                number = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println(INVALID_TYPE_LOTTO_NUMBER.getMessage());
                throw new NoSuchElementException(INVALID_TYPE_LOTTO_NUMBER.getMessage());
            }
            result.add(number);
        }
        return result;
    }

    public boolean isThousandMultiples(int price) {
        if (price == 0 || price % 1000 != 0) {
            return false;
        }
        return true;
    }
}
