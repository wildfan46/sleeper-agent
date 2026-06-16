package com.sleeperagent.function;

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;

// Bean name must match SPRING_CLOUD_FUNCTION_DEFINITION in template.yaml.
// FunctionInvoker looks this bean up by name and routes the EventBridge payload to it.
@Component("rosterAnalysisFunction")
@Slf4j
public class RosterAnalysisFunction implements Function<ScheduledEvent, String> {

    // TODO: inject services here as they are built out, e.g.:
    // private final SleeperApiService sleeperApiService;
    // private final ScoringService scoringService;
    // private final DiscordNotificationService discordNotificationService;

    @Override
    public String apply(ScheduledEvent event) {
        // EventBridge puts the rule ARN in resources — tells us which schedule fired
        // (sleeper-agent-tuesday-waivers vs sleeper-agent-sunday-pregame)
        String triggerSource = event.getResources() != null && !event.getResources().isEmpty()
                ? event.getResources().get(0)
                : "unknown";

        log.info("SleeperAgent triggered by: {}", triggerSource);

        // TODO: replace stub with real pipeline:
        // 1. sleeperApiService.fetchRoster()    -> your current players + statuses
        // 2. sleeperApiService.fetchFAPool()    -> available free agents
        // 3. scoringService.scoreRoster()       -> flag drop candidates
        // 4. scoringService.scoreFATargets()    -> rank waiver priorities
        // 5. discordNotificationService.send()  -> post digest to Discord webhook

        log.info("Stub complete — real pipeline not yet wired");
        return "OK";
    }
}