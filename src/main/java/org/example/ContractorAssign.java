package org.example;

import java.util.List;
import java.util.Map;

public class ContractorAssign implements Assign<Contractor>{
    @Override
    public Contractor assign(String issueDescription) {
        String description = issueDescription.toLowerCase();

        for (Map.Entry<Contractor, List<String>> rule
                : ContractorRules.getRules().entrySet()) {

            for (String keyword : rule.getValue()) {

                if (description.contains(keyword)) {
                    return rule.getKey();
                }
            }
        }

        return Contractor.Maintenance;
    }
}
