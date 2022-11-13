package lotto.domain;

public enum Grade {
    FIFTH_GRADE(5, 5_000, "3개 일치 (5,000원) - "),
    FORTH_GRADE(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD_GRADE(3, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND_GRADE(2, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_GRADE(1, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int grade;
    private final long reward;
    private final String result;

    Grade(int grade, long reward, String result) {
        this.grade = grade;
        this.reward = reward;
        this.result = result;
    }

    public int getGrade() {
        return grade;
    }

    public long getReward() {
        return reward;
    }

    public String getResult() {
        return result;
    }
}
