package com.muscy.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class ClaimData {
    private List<AllItemCoverage> allItemCoverages;
}
