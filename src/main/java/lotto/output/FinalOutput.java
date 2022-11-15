package lotto.output;

import lotto.output.View.*;

import java.util.Collections;
import java.util.List;

public class FinalOutput {

    public static void calculate(List<String> winNum){
        System.out.println("");
        System.out.println(StatisticPrint.PRINT_INIT.getOutput());
        System.out.println(StatisticPrint.PRINT_BORDER.getOutput());
        System.out.println(StatisticPrint.PRINT_THREE.getOutput() + Collections.frequency(winNum,WinNumber.THREE_BALL.getBall())+StatisticPrint.PRINT_QUAN.getOutput());
        System.out.println(StatisticPrint.PRINT_FOUR.getOutput() + Collections.frequency(winNum,WinNumber.FOUR_BALL.getBall())+StatisticPrint.PRINT_QUAN.getOutput());
        System.out.println(StatisticPrint.PRINT_FIVE.getOutput() + Collections.frequency(winNum,WinNumber.FIVE_BALL.getBall())+StatisticPrint.PRINT_QUAN.getOutput());
        System.out.println(StatisticPrint.PRINT_FIVE_BONUS.getOutput() + Collections.frequency(winNum,WinNumber.FIVE_BALL_BONUS.getBall())+StatisticPrint.PRINT_QUAN.getOutput());
        System.out.println(StatisticPrint.PRINT_SIX.getOutput() + Collections.frequency(winNum,WinNumber.SIX_BALL.getBall())+StatisticPrint.PRINT_QUAN.getOutput());
    }
    public static void calculateEarn(List<String> winNum){
        double earn = 5000* Collections.frequency(winNum,WinNumber.THREE_BALL.getBall());
        earn += 50000*Collections.frequency(winNum,WinNumber.FOUR_BALL.getBall());
        earn += 1500000*Collections.frequency(winNum,WinNumber.FIVE_BALL.getBall());
        earn += 30000000*Collections.frequency(winNum,WinNumber.FIVE_BALL_BONUS.getBall());
        earn += 2000000000*Collections.frequency(winNum,WinNumber.SIX_BALL.getBall());
        earn /= 1000*winNum.size();
        System.out.println(StatisticPrint.PRINT_EARN.getOutput()+String.format("%.1f",earn*100)+ StatisticPrint.PRINT_END.getOutput());
    }
}
