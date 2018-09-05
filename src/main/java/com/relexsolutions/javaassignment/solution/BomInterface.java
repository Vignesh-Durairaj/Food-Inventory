package com.relexsolutions.javaassignment.solution;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BomInterface {
    Set<String> getCodesForComponents(String s);
    Set<String> getCodesForProducts(String s);
    List<Map<String, Object>> getComponents(String s);
}
