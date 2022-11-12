package lotto;

public class Judge {

    public boolean correctAmount(int amount) {
        return amount % 1000 == 0;
    }

    public int containCount(List<Integer> lotto, List<Integer> winningNumbers) {
        int contained = 0;
        for (int i = 0; i < lotto.size(); i++) {
            if(!winningNumbers.contains(lotto.get(i))) {
                continue;
            }
            contained++;
        }
        return contained;
    }

    public boolean isNumber(String num) {
        try{
            Integer.parseInt(num);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
