package lotto.domain;

public class Game {

    private final User user;
    private final Service service;

    public Game(){
        user = new User();
        int nLottoTickets = user.getnLottoTickets();

        service = new Service(nLottoTickets);
    }

    public void runGame(){
        // TODO: service 당첨 통계, 수익률 계산 출력
    }
}
