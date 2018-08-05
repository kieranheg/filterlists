package com.muscy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
@Builder
public class ItemCoverage {
    private String lineCode;

    private List<ItemCoverageDetail> itemCoverageDetails;

    private static final List<String> VALID_COVERAGE_CODES = Arrays.asList("VALID1", "VALID2");
    private static final Set<String> VALID_ITEM_COVERAGE_CODES = new HashSet<>(VALID_COVERAGE_CODES);

    public boolean isValidItemCoverage() {
        return VALID_ITEM_COVERAGE_CODES.contains(lineCode);
    }
}
