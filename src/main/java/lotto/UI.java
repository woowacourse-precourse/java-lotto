package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class UI {
    private int cost;
    private List<Integer> userInput;
    private int userBonus;

    public UI() {
        this.userInput = new ArrayList<>();
    }

    public int getCost() {
        return cost;
    }

    public List<Integer> getUserInput() {
        return userInput;
    }

    public int getUserBonus() {
        return userBonus;
    }

    public void requestInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        makeCost();
    }

    private void makeCost() {
        this.cost = Integer.parseInt(readLine());
    }
}
