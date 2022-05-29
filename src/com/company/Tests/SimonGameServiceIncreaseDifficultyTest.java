package com.company.Tests;

import com.company.Services.SimonGameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

public class SimonGameServiceIncreaseDifficultyTest implements Test {

    @Test
    public void testIncreaseDifficultyOnceCallMaxLengthAnd1MultiplePeriod()
    {
        var service = new SimonGameService();
        service.SetMinLengthSequence(3);
        service.SetMaxLengthSequence(5);

        service.IncreaseDifficulty();
        var minLength = service.GetMinLengthSequence();
        var maxLength = service.GetMaxLengthSequence();
        Assertions.assertEquals(minLength, 4);
        Assertions.assertEquals(maxLength, 6);
    }

    @Test
    public void testIncreaseDifficultyOnceCall()
    {
        var service = new SimonGameService();
        service.SetMinLengthSequence(3);
        service.SetMaxLengthSequence(4);

        service.IncreaseDifficulty();
        var minLength = service.GetMinLengthSequence();
        var maxLength = service.GetMaxLengthSequence();
        Assertions.assertEquals(minLength, 3);
        Assertions.assertEquals(maxLength, 5);
    }

    @Test
    public void testIncreaseDifficultyAfterPeriod()
    {
        var service = new SimonGameService();
        service.SetMinLengthSequence(3);
        service.SetMaxLengthSequence(5);

        for (var i = 0; i < SimonGameService.PERIOD_SHIFT_MIN_SEQUENCE_LENGTH; i++) {
            service.IncreaseDifficulty();
        }
        var minLength = service.GetMinLengthSequence();
        var maxLength = service.GetMaxLengthSequence();
        Assertions.assertEquals(minLength, 4);
        Assertions.assertEquals(maxLength, 5 + SimonGameService.PERIOD_SHIFT_MIN_SEQUENCE_LENGTH);
    }


    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
