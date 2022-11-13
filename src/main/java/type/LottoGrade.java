package type;

public enum LottoGrade {

    // 로또 등수
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    NOTHING(6);

    private final int value;

    LottoGrade(int value) {
        this.value = value;
    }
}
