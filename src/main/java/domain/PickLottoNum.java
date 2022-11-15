package domain;

import domain.enums.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class PickLottoNum {
    public Lotto pickLottoNum;
    public List<Integer> pickNumberList = new ArrayList<>();
    private static final int LOTTO_NUM = 6;

    public PickLottoNum(String pickNum) {
        this.pickNumberList.clear();
        validate(pickNum);
        this.pickLottoNum = new Lotto(this.pickNumberList);
    }

    private void validate(String pickNum) {
        validateInvalidInput(pickNum);
    }

    private void validateInvalidInput(String pickNum) {
        try {
            String[] separateNumber = pickNum.split(",");
            for (String oneNumber : separateNumber) {
                pickNumberList.add(Integer.parseInt(oneNumber));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SEP_MESSAGE.getErrorMessage());
        }
    }
}
