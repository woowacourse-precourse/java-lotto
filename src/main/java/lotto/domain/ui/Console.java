package lotto.domain.ui;

import lotto.domain.lotto.Lotto;

public class Console {
    public int inputCellCount() {
        int amount = inputCellAmount();
        return calculateCount(amount);
    }

    private int calculateCount(int amount) {
        int count;
        try {
            if (amount % Lotto.PRICE != 0) {
                throw new IllegalArgumentException();
            }
            count = amount / Lotto.PRICE;
        } catch (Exception e) {
            System.out.println("[ERROR] : 1장에 " + Lotto.PRICE + "원 입니다. 딱 맞게 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        return count;
    }

    private int inputCellAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = camp.nextstep.edu.missionutils.Console.readLine();

        int amount;
        try {
            amount = Integer.parseInt(line);
        } catch (Exception e) {
            System.out.println("[ERROR] : 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        return amount;
    }


}
