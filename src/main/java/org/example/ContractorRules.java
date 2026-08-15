package org.example;

import java.util.List;
import java.util.Map;

public class ContractorRules {
    private static final Map<Contractor, List<String>> rules = Map.of(
            Contractor.Plumber,
            List.of("leak", "flood", "toilet", "pipe", "tap"),
            Contractor.Electrician,
            List.of("light", "socket", "electric", "power"),
            Contractor.Maintenance,
            List.of("door", "lock", "wall", "furniture")
    );

    public static Map<Contractor, List<String>> getRules() {
        return rules;
    }
}
