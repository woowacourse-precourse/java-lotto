package domain;

public class Profit {
    public String getProfit(int AllWinningMoney, int userMoney) {
        double profit = AllWinningMoney * 100.0 / userMoney;

        return String.format("%.1f", profit) + "%";
    }

}
