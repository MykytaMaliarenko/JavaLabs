package com.maliarenko.mykyta;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCSVParser {
    private CSVParser instance;

    public TestCSVParser() {
        this.instance = new CSVParser();
    }

    @Test
    public void testParseString() {
        assertEquals(this.instance.parseString("a,b,c"), "1+1+1");
        assertEquals(this.instance.parseString("a,\"b,c\",c"), "1+3+1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionsTestParseString() {
        this.instance.parseString("a,b,\"c");
    }
}
