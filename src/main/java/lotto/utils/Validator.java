package lotto.utils;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.ErrorCode.INVALID_TYPE_BONUS_NUMBER;

public class Validator {

    public Validator() {}

    public int convertToInt(String s) {
        int result;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TYPE_BONUS_NUMBER.getMessage());
        }
        return result;
    }

    public List<Integer> convertToIntList(String s) {
        String[] tmp_str = s.replace(" ", "").split(",");
        List<Integer> result = new ArrayList<>();
        for (String str : tmp_str) {
            result.add(Integer.parseInt(str));
        }
        return result;
    }

    public boolean isValidPrice(int price) {
        if (price % 1000 != 0) {
            return false;
        }
        return true;
    }
}
