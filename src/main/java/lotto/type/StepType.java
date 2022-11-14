package lotto.type;

import java.util.stream.IntStream;

public enum StepType {
    INIT,
    BUY_LOTTO,
    DECIDE_WINNER,
    DECIDE_BONUS,
    GIVE_RESULT,
    FINISH;

    private StepType nextStep;
    private StepType prevStep;

    public StepType getNextStep() {
        return this.nextStep;
    }

    public StepType getPrevStep() {
        return prevStep;
    }

    /**
     * 다음 단계(nextStep)와 이전 단계(prevStep)를 매핑해주는 코드입니다.
     */
    static {
        StepType[] stepTypes = StepType.values();
        IntStream.range(0, stepTypes.length - 1).forEach((index) -> {
            stepTypes[index].nextStep = stepTypes[index + 1];
            stepTypes[index + 1].prevStep = stepTypes[index];
        });
    }
}
