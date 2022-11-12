package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.GameDTO;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private static final String WINNING_REQUEST = "당첨 번호를 입력해주세요.";
    private static final String BONUS_REQUEST = "보너스 번호를 입력해주세요.";
    private String inputData;
    private String inputBonus;

    public GameDTO makeGameData() {
        GameDTO gameDTO = new GameDTO();
        setInputWin();
        gameDTO.setWinningNumber(makeWinNumber(this.inputData));
        setInputBonus();
        gameDTO.setBonusNumber(makeBounsNumber(this.inputBonus));
        return gameDTO;
    }

    private void setInputWin() {
        System.out.println();
        System.out.println(WINNING_REQUEST);
        this.inputData = Console.readLine();
    }
    private void setInputBonus() {
        System.out.println();
        System.out.println(BONUS_REQUEST);
        this.inputBonus = Console.readLine();
    }

    private List<Integer> makeWinNumber(String inputData) {
        String[] winNumber = inputData.split(",");
        List<Integer> winNumberList = new ArrayList<Integer>();
        int tempNumber;

        checkLenght(winNumber);
        for (int i = 0; i < winNumber.length; i++) {
            if (checkNum(winNumber[i])) {
                tempNumber = Integer.parseInt(winNumber[i]);
                winNumberList.add(tempNumber);
            }
        }
        checkDuplicate(winNumberList);
        return winNumberList;
    }
    private void checkDuplicate(List<Integer> winNumberList) {
        for (int i = 0; i < winNumberList.size(); i++) {
            if (winNumberList.contains(winNumberList.get(i))) {
                throw new IllegalArgumentException("[ERROR]중복된 숫자는 사용할수 없습니다");
            }
        }
    }

    private int makeBounsNumber(String inputBonus) {
        int result = 0;
        if(checkNum(inputBonus)) {
            result = Integer.parseInt(inputBonus);
        }
        return result;
    }

    private void checkLenght(String[] winNumber) {
        if (winNumber.length != 6) {
            throw new IllegalArgumentException("6개의 숫자만 가능합니다.");
        }
    }
    private boolean checkNum(String target) {
        int checkNumber;

        try {
            checkNumber = Integer.parseInt(target);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자값만 들어 올 수 있습니다.");
        }
        if (checkNumber < 1 || checkNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 값만 들어올 수 있습니다");
        }
        return true;
    }
}
