package org.example.Contractor;

import org.example.Assign;
import java.util.List;
import java.util.Map;

public class ContractorAssign implements Assign<Contractor> {
    @Override
    public Contractor assign(String issueDescription) {
        if (issueDescription == null) return Contractor.HelpDesk;
        String description = issueDescription.toLowerCase();

        for (Map.Entry<Contractor, List<String>> rule: ContractorRules.getRules().entrySet()) {
            for (String keyword : rule.getValue()) {
                if (description.contains(keyword)) {
                    return rule.getKey();
                }
            }
        }

        return Contractor.HelpDesk;
    }
}
