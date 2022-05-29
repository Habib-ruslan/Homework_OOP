package com.company.Tests;

import com.company.Services.SimonGameService;
import com.company.Views.PlayView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.Collections;

public class SimonGameServiceGenerateSequenceTest implements Test {

    @Test
    public void testGenerateSequenceWithRangeOf5To10()
    {
        var service = new SimonGameService();
        service.SetMinLengthSequence(5);
        service.SetMaxLengthSequence(10);
        var sequence = service.GenerateSequence();
        var size = sequence.size();
        if (size < 5 || size > 10) {
            Assertions.fail();
        }
    }

    @Test
    public void testGenerateSequenceWithRangeOf5To5()
    {
        var service = new SimonGameService();
        service.SetMinLengthSequence(5);
        service.SetMaxLengthSequence(5);
        var sequence = service.GenerateSequence();
        var size = sequence.size();
        if (size != 5) {
            Assertions.fail();
        }
    }

    @Test
    public void testGenerateSequenceWithInvalidRangeReturnZero()
    {
        var service = new SimonGameService();
        service.SetMinLengthSequence(0);
        service.SetMaxLengthSequence(-1);
        var sequence = service.GenerateSequence();
        var size = sequence.size();
        if (size != 0) {
            Assertions.fail();
        }
    }

    @Test
    public void testGenerateSequenceReturnsNotNull()
    {
        var service = new SimonGameService();
        var sequence = service.GenerateSequence();
        if (sequence == null) {
            Assertions.fail();
        }
    }

    @Test
    public void testGenerateSequenceNotOutOfButtonsRange()
    {
        var service = new SimonGameService();
        var sequence = service.GenerateSequence();
        Collections.sort(sequence);
        if (sequence.get(0) > PlayView.BUTTONS_COUNT || sequence.get(0) < 0) {
            Assertions.fail();
        }
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
