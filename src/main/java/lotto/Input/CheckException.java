package lotto.Input;

public class CheckException {
    private final IllegalArgument illegalArgument = new IllegalArgument();
    public int check_HaveChar(String str) {
        if(!str.matches("[+-]?\\d*(\\.\\d+)?")){
            throw illegalArgument.withMessage(PrintError.NOT_A_NUMBER.getMessage());
        }
        return Integer.parseInt(str);
    }

    public void check_OutOfRange(int number) {
        if(number<LottoValue.MIN.getNum() || LottoValue.MAX.getNum()<number) {
            throw illegalArgument.withMessage(PrintError.OUT_OF_NUMBER_RANGE.getMessage());
        }
    }

    public void check_Thousand(int money) {
        if (money % 1000 != 0) {
            throw illegalArgument.withMessage(PrintError.OUT_OF_MONEY_UNIT.getMessage());
        }
    }

    public void check_LottoSize(int size) {
        if (size != LottoValue.SIZE.getNum()) {
            throw illegalArgument.withMessage(PrintError.NO_SIX_NUM.getMessage());
        }
    }

    public void check_RelativeLottoSize(int size, int compareSize) {
        if(size != compareSize) {
            throw illegalArgument.withMessage(PrintError.OVERLAP.getMessage());
        }
    }
}
