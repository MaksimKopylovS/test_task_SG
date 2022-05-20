package org.max_sk.repository;

import org.junit.jupiter.api.Test;
import org.max_sk.model.Clan;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ClanRepositoryTest {

    @Test
    void getClanHashMap() {
        assertEquals(ClanRepository.getClanHashMap(), ClanRepository.getClanHashMap());
    }

    @Test
    void addClan() {
        assertTrue(ClanRepository.addClan(1L, new Clan("Test")));
    }

    @Test
    void getClan() {
        ClanRepository.getClanHashMap().put(1L, new Clan("Test"));
        assertEquals(new Clan("Test"), ClanRepository.getClan(1L));
    }
}