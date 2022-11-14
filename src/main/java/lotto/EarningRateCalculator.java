package lotto;

import java.util.List;

public class EarningRateCalculator{

    private volatile static EarningRateCalculator calculator;
    private static final Integer DIVISION_VALUE = 100;

    private EarningRateCalculator(){}
    public double calculate(List<Prize> prizeLottos, Integer price) {
        double sum = 0L;
        for (Prize prizeLotto : prizeLottos) {
            sum += prizeLotto.getPrice();
        }
        double percent = getPercentage(sum,price);
        return roundAtTwoDecimalPoint(percent);
    }


    private double roundAtTwoDecimalPoint(double value)
    {

        double decimalValueForReturn = (double)Math.round(value*DIVISION_VALUE);
        return decimalValueForReturn/DIVISION_VALUE;
    }

    private double getPercentage(double total ,double portion)
    {
        return (total/portion)*100;
    }

    public static EarningRateCalculator getInstance()
    {
        if(calculator == null)
        {
            synchronized (EarningRateCalculator.class)
            {
                if(calculator == null)
                {
                    calculator = new EarningRateCalculator();
                }
            }
        }
        return calculator;
    }
}
