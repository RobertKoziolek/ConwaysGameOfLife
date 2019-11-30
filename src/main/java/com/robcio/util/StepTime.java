package com.robcio.util;

import lombok.Getter;

import static com.robcio.util.Constants.*;

public class StepTime {
    @Getter
    private int stepTime = STEP_TIME;
    private final int changeStep = MAX_STEP_TIME / 30;

    public void slowSpeed() {
        stepTime = Math.min(stepTime + changeStep, MAX_STEP_TIME);
    }

    public void hastenSpeed() {
        stepTime = Math.max(stepTime - changeStep, MIN_STEP_TIME);
    }
}
