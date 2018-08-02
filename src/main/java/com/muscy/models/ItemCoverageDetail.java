package com.muscy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@AllArgsConstructor
@Data
@Builder
public class ItemCoverageDetail {
    private String type;
    private String position;
    private String amount;
}
