package lotto.dto;

public class MatchStatusDto {
    private Double income;
    private Integer grade;

    public MatchStatusDto(Double income, Integer grade) {
        this.income = income;
        this.grade = grade;
    }

    public Double getIncome() {
        return income;
    }

    public Integer getGrade() {
        return grade;
    }
}
