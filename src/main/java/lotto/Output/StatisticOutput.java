package lotto.Output;

public class StatisticOutput {
    public void getStatisticOutput(int three, int four, int five, int six_YesBonus, int six) {
        String sb = String.valueOf(PrintWinning.WIN_THREE) + three + PrintWinning.ENDMESSAGE + "\n" +
                PrintWinning.WIN_FOUR + four + PrintWinning.ENDMESSAGE + "\n" +
                PrintWinning.WIN_FIVE_NOBONUS + five + PrintWinning.ENDMESSAGE + "\n" +
                PrintWinning.WIN_SIX_YESBONUS + six_YesBonus + PrintWinning.ENDMESSAGE + "\n" +
                PrintWinning.WIN_SIX + six + PrintWinning.ENDMESSAGE + "\n";
        System.out.println(sb);


    }
}
