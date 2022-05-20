package org.max_sk.manager;

import org.junit.jupiter.api.Test;
import org.max_sk.model.Clan;
import org.max_sk.repository.ClanRepository;

import static org.junit.jupiter.api.Assertions.*;

class ClanManagerTest {

    @Test
    void getClan() {
        ClanRepository.getClanHashMap().put(1L,new Clan("Test"));
        assertEquals(new Clan("Test"), ClanManager.getClan(1L));
    }

    @Test
    void saveClan() {
        assertTrue(ClanManager.saveClan(1L, new Clan("Test")));
    }

    @Test
    void addGoldToClan() {
        ClanRepository.getClanHashMap().put(1L,new Clan("Test"));
        assertTrue(ClanManager.addGoldToClan(1,2));
        assertFalse(ClanManager.addGoldToClan(0,2));
        assertFalse(ClanManager.addGoldToClan(1,0));
    }

    @Test
    void decrementGoldToClan() {
        ClanRepository.getClanHashMap().put(1L,new Clan("Test"));
        ClanManager.addGoldToClan(1,200);
        assertTrue(ClanManager.decrementGoldToClan(1,100));
        assertFalse(ClanManager.addGoldToClan(1,0));
        assertFalse(ClanManager.addGoldToClan(0,100));
    }
}