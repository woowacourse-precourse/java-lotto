package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public int getInvestmentCash(){
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
