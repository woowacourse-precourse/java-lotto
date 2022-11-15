package lotto;

public enum Grade {
    FIRST(2000000000, 6, 0),
    SECOND(30000000, 5, 1),
    THIRD(1500000, 5,0),
    FOURTH(50000, 4, 0),
    FIFTH(5000, 3,0);

    private final int reward;
    private final int correct;
    private final int bonus;

    Grade(int reward, int correct, int bonus){
        this.reward = reward;
        this.correct = correct;
        this.bonus = bonus;
    }

    public static Grade getGrade(int correct, int bonus){
        for (Grade grade: Grade.values()){
            if (correct == grade.correct && bonus == grade.bonus) return grade;
        }
        return null;
    }


}
