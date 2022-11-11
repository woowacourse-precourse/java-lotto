package lotto;

import jdk.jshell.spi.SPIResolutionException;

import java.text.NumberFormat;
import java.util.List;

public class EarningRateCalculator{

    private volatile static EarningRateCalculator calculator;

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
        int divisionValue = 100;
        double decimalValueForReturn = (double)Math.round(value*divisionValue);
        return decimalValueForReturn/divisionValue;
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
