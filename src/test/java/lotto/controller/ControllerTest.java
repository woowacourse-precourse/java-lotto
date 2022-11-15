package lotto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerTest {
    private AutomaticDispenser automaticDispenser;
    private HistoryBuilder historyBuilder;
    private LottoTicket lottoTicket;
    private MatchBuilder matchBuilder;
    private Matcher matcher;
    private Printer printer;

    @BeforeEach
    public void setUp() {
        automaticDispenser = new AutomaticDispenser();
        historyBuilder = new HistoryBuilder();
        lottoTicket = new LottoTicket();
        matchBuilder = new MatchBuilder();
        matcher = new Matcher();
        printer = new Printer();
    }

    @Test
    public void() throws Exception{
        //given

        //when

        //then
    }

}