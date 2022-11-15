package lotto.step;

import lotto.application.LottoApplicationContext;

public abstract class LottoStep implements Step {

   protected final LottoApplicationContext context;

   public LottoStep(final LottoApplicationContext context) {
       this.context = context;
   }
}
