package com.example.models.items;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Stores the item identifiers carried by the player.
 */
public final class Inventory {
    private final Set<Items> items = EnumSet.noneOf(Items.class);

    /**
     * Indicates whether the inventory contains an item.
     *
     * @param item item identifier
     * @return {@code true} when present
     */
    public boolean has(Items item) {
        return items.contains(item);
    }

    /**
     * Adds an item to the inventory.
     *
     * @param item item identifier
     */
    public void add(Items item) {
        items.add(item);
    }

    /**
     * Removes an item from the inventory.
     *
     * @param item item identifier
     */
    public void remove(Items item) {
        items.remove(item);
    }

    /**
     * Returns a read-only view of carried items.
     *
     * @return read-only item identifiers
     */
    public Set<Items> getItems() {
        return Collections.unmodifiableSet(items);
    }

    /**
     * Indicates whether the inventory is empty.
     *
     * @return {@code true} when empty
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
