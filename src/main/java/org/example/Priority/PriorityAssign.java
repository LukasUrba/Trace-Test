package org.example.Priority;

import org.example.Assign;

import java.util.List;
import java.util.Map;

public class PriorityAssign implements Assign<Priority> {
    @Override
    public  Priority assign(String issueDescription) {
        String description = issueDescription.toLowerCase();

        for (Map.Entry<Priority, List<String>> rule: PriorityRules.getRules().entrySet()) {
            for (String keyword : rule.getValue()) {
                if (description.contains(keyword)) {
                    return rule.getKey();
                }
            }
        }
        return Priority.Medium;
    }
}
