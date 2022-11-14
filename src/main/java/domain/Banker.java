package domain;

import com.sun.jdi.Value;

import java.util.*;

public class Banker {
    private static Banker instance = new Banker();
    public static Banker getInstance = instance;
    User user = User.getInstance;

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

    public void compareCount(int[] victoryNumber) {
        setMap();
        for (int i = 0; i < map.size(); i++) {
            if (isBonusCount(victoryNumber)) {
                map.put(Victory.MATCH_BONUS, +1);
                return;
            }
            if (victoryNumber[VICTORY_LOCATION] == Victory.values()[i].getMatchCount()) {
                map.put(Victory.values()[i], +1);
            }
        }
    }

    public void printWinner() {
        map.get(Victory.MATCH3).intValue();
        System.out.println("3개 일치 (5,000원) - " + map.get(Victory.MATCH3).intValue() + "개");
        System.out.println("4개 일치 (50,000원) - " + map.get(Victory.MATCH4).intValue() + "개");
        System.out.println("5개 일치 (1,500,000원) - "+ map.get(Victory.MATCH5).intValue()+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ map.get(Victory.MATCH_BONUS).intValue()+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ map.get(Victory.MATCH_ALL).intValue()+"개");
    }

    public double getWinnerMoney() {
        int sum = 0;
        for (Map.Entry<Victory, Integer> entry : map.entrySet()) {
            sum += entry.getKey().getWinningMoney() * entry.getValue();
        }
        double money = Math.round(sum / (double) user.getMoney() * 1000) / 10.0;
        return money;
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
