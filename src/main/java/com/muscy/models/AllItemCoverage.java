package com.muscy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class AllItemCoverage {
    private String subjectOfInsurance;

    private List<ItemCoverage> itemCoverages;

}
