package org.max_sk.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    @Test
    void getTrackId() {
        Track track = new Track(1, 1, 100);
        assertEquals(1, track.getId());
    }

    @Test
    void testEquals() {
        Track track = new Track(1, 1, 100);
        assertEquals(track,track);
    }

    @Test
    void testHashCode() {
        Track track = new Track(1, 1, 100);
        assertEquals(track.hashCode(), track.hashCode());
    }

    @Test
    void testToString() {
        Track track = new Track(1, 1, 100);
        assertEquals(track.hashCode(), track.hashCode());
    }
}