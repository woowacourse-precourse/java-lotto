package lotto.Domain.Exception;

import lotto.Input.LottoValue;

public class CheckException {
    private IllegalArgumentException illegalArgument = new IllegalArgumentException();
    public int check_HaveChar_And_Convert(String str) {
        if(!str.matches("[+-]?\\d*(\\.\\d+)?")){
            throw illegalArgument;
        }
        return Integer.parseInt(str);
    }

    public void check_OutOfRange(int number) {
        if(number< LottoValue.MIN.getNum() || LottoValue.MAX.getNum()<number) {
            throw illegalArgument;
        }
    }

    public void check_Thousand(int money) {
        if (money % 1000 != 0) {
            throw illegalArgument;
        }
    }

    public void check_LottoSize(int size) {
        if (size != LottoValue.SIZE.getNum()) {
            throw illegalArgument;
        }
    }

    public void check_RelativeLottoSize(int size, int compareSize) {
        if(size != compareSize) {
            throw illegalArgument;
        }
    }
}
