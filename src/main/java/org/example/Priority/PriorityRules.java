package org.example.Priority;

import java.util.List;
import java.util.Map;

public class PriorityRules {
    private static final Map<Priority, List<String>> rules = Map.of(
            Priority.Urgent,
            List.of("leak", "flood", "gas","smell","burst"),
            Priority.Medium,
            List.of("power","heating","hot"),
            Priority.Low,
            List.of("lightbulb", "light bulb","light")
    );

    public static Map<Priority, List<String>> getRules() {
        return rules;
    }
}
