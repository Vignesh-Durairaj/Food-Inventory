package com.relexsolutions.javaassignment;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Sets;
import com.relexsolutions.javaassignment.api.DataProvider;
import com.relexsolutions.javaassignment.solution.BomProcessor;
import com.relexsolutions.javaassignment.solution.BomInterface;
import org.junit.Test;

import static com.google.common.collect.ImmutableMap.of;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * This test class contains a few rudimentary tests to verify that the
 * implementation works in basic cases.
 */
public class BasicTests {
    @Test
    public void testGetComponents() {
        assertTrue("getComponents returns a hash of components for the given product code", true);
    }

    @Test
    public void testgetCodesForComponents() {
        assertTrue("getCodesForComponents returns the codes of each component of the given product", true);
        BomInterface processor = new BomProcessor(DataProvider.getEntriesForPart1());
        assertEquals(
            Sets.newHashSet("BREAD", "MAYO", "BACON", "FLOUR", "YEAST", "EGG", "EGG_WHITE", "EGG_YOLK", "OIL", "MUSTARD", "GARLIC_POWDER", "GARLIC"),
            processor.getCodesForComponents("CLUB_SANDWICH")
        );

        assertEquals(
            Sets.newHashSet("GARLIC_POWDER", "GARLIC"),
            processor.getCodesForComponents("MUSTARD")
        );
    }

    @Test
    public void testgetCodesForProducts() {
        assertTrue("getCodesForProducts returns the codes of each product that contains the given component", true);
        BomInterface processor = new BomProcessor(DataProvider.getEntriesForPart1());

        assertEquals(
            Sets.newHashSet("GARLIC_POWDER", "MUSTARD", "MAYO", "CLUB_SANDWICH"),
            processor.getCodesForProducts("GARLIC")
        );

        assertEquals(
            Sets.newHashSet("MAYO", "CLUB_SANDWICH"),
            processor.getCodesForProducts("MUSTARD")
        );
    }

    @Test @SuppressWarnings("unchecked")
    public void testGetTreeForEggs() {
        assertTrue("getCodesForProducts returns the codes of each product that contains the given component", true);
        BomInterface processor = new BomProcessor(DataProvider.getEntriesForPart1());
        List<Map<String, Object>> components = processor.getComponents("FRIED_EGGS");
        assertThat(components, hasItems(
            of("depth", 1, "name", "EGG"),
            of("depth", 1, "name", "OIL"),
            of("depth", 2, "name", "EGG_WHITE"),
            of("depth", 2, "name", "EGG_YOLK")
        ));
    }

    @Test @SuppressWarnings("unchecked")
    public void testGetTreeForSandwich() {
        assertTrue("getCodesForProducts returns the codes of each product that contains the given component", true);
        BomInterface processor = new BomProcessor(DataProvider.getEntriesForPart1());
        List<Map<String, Object>> components = processor.getComponents("CLUB_SANDWICH");
        assertThat(components, hasItems(
                of("depth", 1, "name", "BREAD"),
                of("depth", 1, "name", "MAYO"),
                of("depth", 1, "name", "BACON"),
                of("depth", 2, "name", "FLOUR"),
                of("depth", 2, "name", "YEAST"),
                of("depth", 2, "name", "EGG"),
                of("depth", 2, "name", "OIL"),
                of("depth", 2, "name", "MUSTARD"),
                of("depth", 3, "name", "EGG_WHITE"),
                of("depth", 3, "name", "EGG_YOLK"),
                of("depth", 3, "name", "GARLIC_POWDER"),
                of("depth", 4, "name", "GARLIC")
        ));
    }

    @Test
    public void testgetCodesForActiveComponents() {
        assertTrue("getCodesForProducts(code, date) returns the codes of each product that contains the given component which are active for the given date", true);
    }
}
