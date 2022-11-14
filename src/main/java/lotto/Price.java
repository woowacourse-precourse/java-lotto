package lotto;

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

    public int getLottoTickets() {
        return lottoTickets;
    }


    public int inputPrice() {
        View.buyLotto();
        String price = Console.readLine();
        Validation.Integer(price);
        return Integer.parseInt(price);
    }

    public int LottoTickets(int price) {
        Validation.price(price);
        return price / 1000;
    }


}
