package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public Validator() {}

    public int convertToInt(String s) {
        return Integer.parseInt(s);
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
