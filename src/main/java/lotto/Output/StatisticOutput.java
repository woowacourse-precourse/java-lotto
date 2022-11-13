package lotto.Output;

public class StatisticOutput {
    public static void getStatisticOutput(int three, int four, int five_NoBonus, int five_YesBonus, int six) {
        PrintOutput.WIN_THREE.printMessage(three);
        PrintOutput.WIN_FOUR.printMessage(four);
        PrintOutput.WIN_FIVE_NOBALL.printMessage(five_NoBonus);
        PrintOutput.WIN_FIVE_YESBALL.printMessage(five_YesBonus);
        PrintOutput.WIN_SIX.printMessage(six);
    }
}
