package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * A social media app that you are working on includes a piece of UI to show events that have occurred over time.
 * These events are represented as plain objects with three fields:
 * ```
 * {
 * timestamp: 1, // the timestamp in milliseconds
 * category: 'USER_FOLLOW', // the category of the event (see below)
 * displayText: '..' // the text to render to the screen
 * }
 * ```
 * You will be given an array of events, sorted by timestamp in ascending order.
 * <p>
 * Events will be one of three categories:
 * * `USER_FOLLOW`
 * * `TRENDING_TOPIC`
 * * `DIRECT_MESSAGE`
 * <p>
 * The issue is that when a user logs on there could potentially be 100s of events, and we want to keep the UI contained.
 * Therefore, we want to collapse events based on the following rules:
 * * `USER_FOLLOW` events are never collapsed.
 * * `TRENDING_TOPIC` events are collapsed if there are 2 or more consecutive events
 * * `DIRECT_MESSAGE` events are collapsed if there are 5 or more consecutive events
 * <p>
 * When events are collapsed, we show only the first event, with all the rest hidden:
 * * `USER_FOLLOW`
 * * `USER_FOLLOW`
 * * `TRENDING_TOPIC` (+ 6 more)
 * * `DIRECT_MESSAGE` (+ 5 more)
 * * `TRENDING_TOPIC`
 * <p>
 * Create a function, `collapseEvents(events)` which will take an array of events and return a data structure
 * representing the events in their collapsed form. You may represent these events using any structure you wish, but
 * try to think about a structure that will be useful for the frontend engineer to implement the UI with.
 */

enum CATEGORY {
    USER_FOLLOW,
    TRENDING_TOPIC,
    DIRECT_MESSAGE
}

class Event {
    public int timestamp;
    public CATEGORY category;
    public String displayText;

    public Event(CATEGORY category) {
        this.category = category;
    }
}

class CollapsedEvents {
    private final CATEGORY category;
    private final int count;

    public CollapsedEvents(CATEGORY category, int counter) {
        this.category = category;
        this.count = counter;
    }

    @Override
    public String toString() {
        if (count != 0) {
            return category + "(+" + count + " more times)\n";
        } else {
            return category + "\n";
        }
    }
}


public class DisplayCollapsedEvents {
    public static List<CollapsedEvents> collapseEvents(List<Event> events) {
        List<CollapsedEvents> list = new ArrayList<>();

        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).category.equals(CATEGORY.USER_FOLLOW)) {
                list.add(new CollapsedEvents(events.get(i).category, 0));
            } else if (events.get(i).category.equals(CATEGORY.TRENDING_TOPIC)) {
                int k = 0;
                while (i < events.size() && events.get(i).category.equals(CATEGORY.TRENDING_TOPIC)) {
                    k++;
                    i++;
                }
                i--;
                if (k >= 2 && i < events.size()) {
                    list.add(new CollapsedEvents(events.get(i).category, k - 1));
                } else if (i < events.size()) {
                    list.add(new CollapsedEvents(events.get(i).category, 0));
                }

            } else {
                int k = 0;
                while (i < events.size() && events.get(i).category.equals(CATEGORY.DIRECT_MESSAGE)) {
                    k++;
                    i++;
                }
                i--;
                if (k >= 5 && i < events.size()) {
                    list.add(new CollapsedEvents(events.get(i).category, k - 1));
                } else if (i < events.size()) {
                    while (k > 0) {
                        list.add(new CollapsedEvents(events.get(i).category, 0));
                        k--;
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();

        events.add(new Event(CATEGORY.USER_FOLLOW));
        events.add(new Event(CATEGORY.USER_FOLLOW));
        events.add(new Event(CATEGORY.TRENDING_TOPIC));
        events.add(new Event(CATEGORY.TRENDING_TOPIC));
        events.add(new Event(CATEGORY.TRENDING_TOPIC));
        events.add(new Event(CATEGORY.DIRECT_MESSAGE));
        events.add(new Event(CATEGORY.USER_FOLLOW));
        events.add(new Event(CATEGORY.TRENDING_TOPIC));

        System.out.println(collapseEvents(events));
    }

}
