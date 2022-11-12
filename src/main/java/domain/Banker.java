package domain;

import com.sun.jdi.Value;

import java.util.*;

public class Banker {
    public Banker() {
    }

    public final int VICTORY_LOCATION = 0;
    public final int BONUS_LOCATION = 1;
    private Map<Victory, Integer> map = new LinkedHashMap<>();
    private List<Integer> winningNumber = new ArrayList<>();
    private int bonusNumber;

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int[] correctCount(Lotto lotto) {
        int[] victoryNumber = new int[2];
        int result = 0;
        int resultBonus = 0;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (lotto.getNumbers().contains(winningNumber.get(i))) {
                result++;
            }
        }
        if (lotto.getNumbers().contains(bonusNumber)) {
            resultBonus++;
        }
        victoryNumber[VICTORY_LOCATION] = result;
        victoryNumber[BONUS_LOCATION] = resultBonus;
        return victoryNumber;
    }

    public void setMap() {
        for (int i = 0; i < Victory.values().length; i++) {
            map.put(Victory.values()[i], 0);
        }
    }

    public void compareCount(int[] victoruNumber) {
        setMap();
        for (int i = 0; i < map.size(); i++) {
            if (isBonusCount(victoruNumber)) {
                map.put(Victory.MATCH_BONUS, +1);
                return;
            }
            if (victoruNumber[VICTORY_LOCATION] == Victory.values()[i].getMatchCount()) {
                map.put(Victory.values()[i], +1);
            }
        }
    }

    public void printWinner() {
        for (Map.Entry<Victory,Integer> entry : map.entrySet()) {
            if (entry.getKey().isBonus() == false) {
                System.out.println(entry.getKey().getMatchCount() + "개 일치" +
                        "("+entry.getKey().getWinningMoney()+")" + "-" + entry.getValue() + "개");
            }
            if (entry.getKey().isBonus() == true) {
                System.out.println(entry.getKey().getMatchCount() + "개 일치, 보너스 볼 일치" +
                        "(" + entry.getKey().getWinningMoney()+")" + "-" + entry.getValue() + "개");
            }
        }
    }


    public boolean isBonusCount(int[] victoruNumber) {
        if (victoruNumber[VICTORY_LOCATION] == 5 && victoruNumber[BONUS_LOCATION] == 1) {
            return true;
        }
        return false;
    }

    public Map<Victory, Integer> getMap() {
        return map;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
