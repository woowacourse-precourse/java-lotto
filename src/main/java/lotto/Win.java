package lotto;

public enum Win {
    FIRST_PLACE(6, 1, Constant.FIRST_PLACE_EARNING),
    SECOND_PLACE(5, 2, Constant.SECOND_PLACE_EARNING),
    THIRD_PLACE(5, 3, Constant.THIRD_PLACE_EARNING),
    FORTH_PLACE(4, 4, Constant.FORTH_PLACE_EARNING),
    FIFTH_PLACE(3, 5, Constant.FIFTH_PLACE_EARNING),
    LOSE(0, 0, 0);

    public final Integer match;
    public final Integer grade;
    public final Integer earning;

    Win(Integer match, Integer grade, Integer earning) {
        this.match = match;
        this.grade = grade;
        this.earning = earning;
    }
}
