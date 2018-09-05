package com.relexsolutions.javaassignment;

import java.util.List;

import com.relexsolutions.javaassignment.api.DataProvider;
import com.relexsolutions.javaassignment.api.Entry;
import com.relexsolutions.javaassignment.api.Forecast;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class DataProviderTest {
    @Test public void testReturnsPart1Data() {
        List<Entry> entries = DataProvider.getEntriesForPart1();
        assertThat(entries, isA(List.class));
        assertThat(entries, hasSize(14));
    }

    @Test public void testReturnsPart2Data() {
        List<Entry> entries = DataProvider.getEntriesForPart2();
        assertThat(entries, isA(List.class));
        assertThat(entries, hasSize(21));
    }

    @Test public void testReturnsPart3Data() {
        List<Entry> entries = DataProvider.getEntriesForPart3();
        assertThat(entries, isA(List.class));
        assertThat(entries, hasSize(19));
    }

    @Test public void testReturnsForecasts() {
        List<Forecast> entries = DataProvider.getForecasts();
        assertThat(entries, isA(List.class));
        assertThat(entries, hasSize(3));
    }
}
