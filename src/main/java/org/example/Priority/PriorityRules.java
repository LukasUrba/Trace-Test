package org.example.Priority;

import org.example.Priority.Priority;

import java.util.List;
import java.util.Map;

public class PriorityRules {
    private static final Map<Priority, List<String>> rules = Map.of(
            Priority.Urgent,
            List.of("leak", "flood", "gas"),
            Priority.Low,
            List.of("lightbulb", "light bulb")
    );

    public static Map<Priority, List<String>> getRules() {
        return rules;
    }
}
