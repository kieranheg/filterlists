package com.muscy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class ItemCoverage {
    private String lineCode;

    private List<ItemCoverageDetail> itemCoverageDetails;
}
