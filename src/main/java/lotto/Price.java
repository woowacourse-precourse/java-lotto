package lotto;

import lotto.Machine.PrintMachine;
import camp.nextstep.edu.missionutils.Console;

public class Price {

    private final int inputPrice;
    private final int lottoTickets;

    public Price() {
        this.inputPrice = inputPrice();
        this.lottoTickets = LottoTickets(inputPrice);
    }

    public int getInputPrice() {
        return inputPrice;
    }
    public int getLottoTickets(){
        return lottoTickets;
    }


    public int inputPrice() {
        PrintMachine.buyLotto();
        String price = Console.readLine();
        validateInteger(price);
        return Integer.parseInt(price);
    }

    public int LottoTickets(int price) {
        validatePrice(price);
        return price / 1000;
    }
    private void validateInteger(String string) {
        if (!string.matches("-?\\\\d+")) {
            PrintMachine.errorMessage("입력값이 옳지 않습니다.");
            throw new IllegalArgumentException();
        }
    }
    private void validatePrice(int price) {
        if (price % 1000 != 0) {
            PrintMachine.errorMessage("금액이 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

}
