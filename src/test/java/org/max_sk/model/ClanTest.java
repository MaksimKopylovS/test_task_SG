package org.max_sk.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClanTest {

    @Test
    void getGold() {
        Clan clan = new Clan("Test");
        clan.incGold(100);
        assertEquals(100, clan.getGold());
    }

    @Test
    void incGold() {
        Clan clan = new Clan("Test");
        assertTrue(clan.incGold(100));
    }

    @Test
    void decrementGold() {
        Clan clan = new Clan("Test");
        clan.incGold(100);
        assertTrue(clan.decrementGold(100));
    }

    @Test
    void getIdClan() {
        Clan clan = new Clan("Test");
        assertEquals(4L, clan.getIdClan());
    }

    @Test
    void testEquals() {
        Clan clan = new Clan("Test");
        assertEquals(clan, clan);
    }

    @Test
    void testHashCode() {
        Clan clan = new Clan("Test");
        assertEquals(clan.hashCode(),clan.hashCode());
    }

    @Test
    void testToString() {
        Clan clan = new Clan("Test");
        assertEquals(clan.toString(),clan.toString());
    }
}