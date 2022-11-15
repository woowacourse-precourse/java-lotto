package lotto;

public enum Win {
    FIRST_PLACE(6, Constant.FIRST_PLACE_EARNING),
    SECOND_PLACE(5, Constant.SECOND_PLACE_EARNING),
    THIRD_PLACE(4, Constant.THIRD_PLACE_EARNING),
    FORTH_PLACE(4, Constant.FORTH_PLACE_EARNING),
    FIFTH_PLACE(3, Constant.FIFTH_PLACE_EARNING),
    LOSE(null, 0);

    public final Integer match;
    public final Integer earning;

    Win(Integer match, Integer earning) {
        this.match = match;
        this.earning = earning;
    }
}
