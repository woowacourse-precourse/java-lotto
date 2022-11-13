package lotto.model;

public class Game {
    public static final Integer price = 1000;
    public static final Integer maximumLottoNumber = 45;
    public static final Integer numberToDraw = 6;

    private Integer budget = 0;

    public Game(){

    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget){
        validateBudget(budget);
        this.budget = budget;
    }

    private void validateBudget(Integer budget){
        if (budget % price != 0) throw new IllegalArgumentException();
    }




}
