package lotto.Model;

public class Profit extends Money{
    public double getProfits(int origin_money){
        double profit = ((double)this.getMoney() / (double)origin_money) * 100;
        return  Math.round(profit * 100) / 100.0;
    }
}
