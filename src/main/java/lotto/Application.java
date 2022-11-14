package lotto;

import Controller.OrderBonusNumber;
import Controller.OrderNumber;
import UI.LottoView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            LottoView.printBuy();

            final long USER_PAY = LottoPay.LottoPay();
            final long USER_TICKET = LottoTicket.LottoTicket(USER_PAY);


            LottoView.printTicket(USER_TICKET);

            LottoUserNumber lottoUserNumber = new LottoUserNumber();
            lottoUserNumber.createRandomNumber(USER_TICKET);

            final List<List<Integer>> USER_LOTTO_NUMBERS = new ArrayList<>(lottoUserNumber.createRandomNumber(USER_TICKET));

            LottoView.printUserLottoNumber(USER_LOTTO_NUMBERS, USER_TICKET);

            LottoView.inputLottoNumber();

            OrderNumber userOrderNumber = new OrderNumber();
            final String ORDER_NUMBER = userOrderNumber.getLottoNumber();


            LottoCreateNumber createNumber = new LottoCreateNumber(ORDER_NUMBER);
            final List<Integer> ORDER_NUMBERS = createNumber.getCreateNumber();

            Lotto lotto = new Lotto(ORDER_NUMBERS);
            final List<Integer> LOTTO_NUMBERS = lotto.getNumbers();

            LottoView.printBonusNumber();

            OrderBonusNumber userOrderBonusNumber = new OrderBonusNumber();
            final String ORDER_BONUS_NUMBER = userOrderBonusNumber.getLottoNumber();

            LottoBonus lottoBonus = new LottoBonus(LOTTO_NUMBERS, ORDER_BONUS_NUMBER);
            final int LOTTO_BONUS_NUMBER = lottoBonus.getBonusNumber();

            LottoCountWin lottoCountWin = new LottoCountWin(LOTTO_NUMBERS, LOTTO_BONUS_NUMBER, USER_LOTTO_NUMBERS, USER_TICKET);
            final int count1Win = lottoCountWin.getCount1Win();
            final int count2Win = lottoCountWin.getCount2Win();
            final int count3Win = lottoCountWin.getCount3Win();
            final int count4Win = lottoCountWin.getCount4Win();
            final int count5Win = lottoCountWin.getCount5Win();

            final long PRIZE_MONEY_1WIN = LottoWinnings.LOTTO_1_WIN.money(count1Win);
            final long PRIZE_MONEY_2WIN = LottoWinnings.LOTTO_2_WIN.money(count2Win);
            final long PRIZE_MONEY_3WIN = LottoWinnings.LOTTO_3_WIN.money(count3Win);
            final long PRIZE_MONEY_4WIN = LottoWinnings.LOTTO_4_WIN.money(count4Win);
            final long PRIZE_MONEY_5WIN = LottoWinnings.LOTTO_5_WIN.money(count5Win);
            final long TOTAL_PRIZE_MONEY = PRIZE_MONEY_1WIN + PRIZE_MONEY_2WIN +
                    PRIZE_MONEY_3WIN + PRIZE_MONEY_4WIN + PRIZE_MONEY_5WIN;

            LottoView.winningView(count1Win, count2Win, count3Win, count4Win, count5Win);

            LottoRate lottoRate = new LottoRate(TOTAL_PRIZE_MONEY, USER_PAY);

            LottoView.printRate(lottoRate.getRate());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
