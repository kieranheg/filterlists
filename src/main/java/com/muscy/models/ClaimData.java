package com.muscy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Data
@Builder
public class ClaimData {

    private List<AllItemCoverage> allItemCoverages;

    public void getValidCoverages() {
        allItemCoverages = allItemCoverages
                .stream()
                .filter(allItemCoverage -> allItemCoverage.isSubjectOfInsurance())
                .peek(allItemCoverage -> {System.out.println(allItemCoverage.getSubjectOfInsurance());})
                .filter(allItemCoverage -> allItemCoverage.getItemCoverages()
                        .stream()
                        .peek(itemCoverage -> {
                            System.out.println(itemCoverage.getLineCode());
                        })
                        .anyMatch(itemCoverage -> itemCoverage.isValidItemCoverage()))
                .collect(toList());
    }

}
