package lotto.job;

import lotto.job.types.BonusDecider;
import lotto.job.types.LottoSeller;
import lotto.job.types.ResultAnnouncer;
import lotto.job.types.WinnerDecider;
import lotto.printer.Printer;
import lotto.printer.PrinterType;
import lotto.reader.Reader;
import lotto.reader.ReaderType;

public enum JobType {


    BUY_LOTTO {
        @Override
        void run() {
            Printer printer = PrinterType.TEXT_PRINTER.getPrinter();
            Reader reader = ReaderType.STORE.getReader();

            Job store = new LottoSeller(printer, reader);

            store.doJob();
        }
    },

    DECIDE_WINNER {
        @Override
        void run() {
            Printer printer = PrinterType.TEXT_PRINTER.getPrinter();
            Reader reader = ReaderType.WINNER.getReader();

            Job winnerDecider = new WinnerDecider(printer, reader);

            winnerDecider.doJob();
        }
    },

    DECIDE_BONUS {
        @Override
        void run() {
            Printer printer = PrinterType.TEXT_PRINTER.getPrinter();
            Reader reader = ReaderType.BONUS.getReader();

            Job bonusDecider = new BonusDecider(printer, reader);

            bonusDecider.doJob();
        }
    },

    ANNOUNCE_RESULT {
        @Override
        void run() {
            Printer printer = PrinterType.MODEL_PRINTER.getPrinter();

            Job resultAnnouncer = new ResultAnnouncer(printer);

            resultAnnouncer.doJob();
        }
    };


    abstract void run();
}
