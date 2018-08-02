package com.muscy.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClaimDataTest {


    @Test
    public void claimDataCoverageAmounts() {
        List<ItemCoverageDetail> itemCoverageDetails1 = buildItemCoverageDetail("10", "20", "100");
        List<ItemCoverageDetail> itemCoverageDetails2 = buildItemCoverageDetail("20", "40", "200");
        List<ItemCoverageDetail> itemCoverageDetails3 = buildItemCoverageDetail("30", "60", "900");

        List<ItemCoverage> itemCoverages = buildItemCoverage(itemCoverageDetails1, itemCoverageDetails2, itemCoverageDetails3);

        List<AllItemCoverage> allItemCoverages = buildAllItemCoverages(itemCoverages);

        ClaimData claimData = buildClaimData(allItemCoverages);

        assertEquals(3, claimData.getAllItemCoverages().size());
    }

    private ClaimData buildClaimData(List<AllItemCoverage> allItemCoverages) {
        ClaimData claimData = ClaimData.builder().allItemCoverages(allItemCoverages).build();
        return claimData;
    }

    private List<AllItemCoverage> buildAllItemCoverages(List<ItemCoverage> itemCoverages) {
        AllItemCoverage allItemCoverage1 = AllItemCoverage.builder().subjectOfInsurance("N").itemCoverages(itemCoverages).build();
        AllItemCoverage allItemCoverage2 = AllItemCoverage.builder().subjectOfInsurance("").itemCoverages(itemCoverages).build();
        AllItemCoverage allItemCoverage3 = AllItemCoverage.builder().subjectOfInsurance("Y").itemCoverages(itemCoverages).build();
        List<AllItemCoverage> allItemCoverages = new ArrayList<>();
        allItemCoverages.add(allItemCoverage1);
        allItemCoverages.add(allItemCoverage2);
        allItemCoverages.add(allItemCoverage3);
        return allItemCoverages;
    }

    private List<ItemCoverage> buildItemCoverage(List<ItemCoverageDetail> itemCoverageDetails1, List<ItemCoverageDetail> itemCoverageDetails2, List<ItemCoverageDetail> itemCoverageDetails3) {
        ItemCoverage itemCoverage1 = ItemCoverage.builder().lineCode("XXX1").itemCoverageDetails(itemCoverageDetails1).build();
        ItemCoverage itemCoverage2 = ItemCoverage.builder().lineCode("YYY2").itemCoverageDetails(itemCoverageDetails2).build();
        ItemCoverage itemCoverage3 = ItemCoverage.builder().lineCode("ZZZ3").itemCoverageDetails(itemCoverageDetails3).build();
        List<ItemCoverage> itemCoverages = new ArrayList<>();
        itemCoverages.add(itemCoverage1);
        itemCoverages.add(itemCoverage2);
        itemCoverages.add(itemCoverage3);
        return itemCoverages;
    }

    private List<ItemCoverageDetail> buildItemCoverageDetail(String limAmount1, String limAmount2, String ded) {
        ItemCoverageDetail itemCoverageDetail1 = ItemCoverageDetail.builder().type("LIM").position("1").amount(limAmount1).build();
        ItemCoverageDetail itemCoverageDetail2 = ItemCoverageDetail.builder().type("LIM").position("2").amount(limAmount2).build();
        ItemCoverageDetail itemCoverageDetail3 = ItemCoverageDetail.builder().type("DED").position("1").amount(ded).build();
        List<ItemCoverageDetail> itemCoverageDetails = new ArrayList<>();
        itemCoverageDetails.add(itemCoverageDetail1);
        itemCoverageDetails.add(itemCoverageDetail2);
        itemCoverageDetails.add(itemCoverageDetail3);
        return itemCoverageDetails;
    }
}