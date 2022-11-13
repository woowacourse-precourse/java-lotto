package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lucky {
    private final List<Integer> lucky = Arrays.asList(0, 0, 0, 0, 0, 0);

    public Lucky(String lucky){
        validateLucky(Arrays.asList(lucky.split(",")));
    }

    private void validateLucky(List<String> lucky_num){
        validateSize(lucky_num.size());
        for (int i = 0; i < lucky_num.size(); i++){
            lucky.set(i, validateVal(lucky_num.get(i)));
        }
    }

    private void validateSize(int size){
        if (size != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개로 이루어진 숫자여야합니다. ");
    }

    private int validateVal(String lucky){
        int val = Integer.parseInt(lucky);
        if (val >= 1 && val <= 45)
            return val;
        throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 ~ 45사이의 숫자여야합니다.");
    }

    public int Get_size(){
        return lucky.size();
    }

    public int Get_val(int index){
        return lucky.get(index);
    }

}
