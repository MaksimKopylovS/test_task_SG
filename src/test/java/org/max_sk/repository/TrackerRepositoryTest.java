package org.max_sk.repository;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TrackerRepositoryTest {

    @Test
    void getTrackHashMap() {
        assertEquals(TrackerRepository.getTrackHashMap(), TrackerRepository.getTrackHashMap());
        assertNotEquals(new ArrayList<String>(),TrackerRepository.getTrackHashMap());
    }
}