package org.max_sk.model;

import java.util.Objects;

public class Track {

    private static long countId = 1;
    private long id;
    private long clanId;
    private long userId;
    private int gold;

    public Track(long clanId, long userId, int gold) {
        try {
            if (clanId <= 0 || userId <=0 || gold <= 0) {
                throw new NullPointerException();
            } else {
                this.clanId = clanId;
                this.userId = userId;
                this.gold = gold;
                id = incrementTrackId();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public synchronized  long getId() {
        return id;
    }

    private synchronized static long incrementTrackId(){
        return countId++;
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return clanId == track.clanId &&
                userId == track.userId &&
                gold == track.gold;
    }

    @Override
    public synchronized int hashCode() {
        return Objects.hash(clanId, userId, gold);
    }

    @Override
    public synchronized String toString() {
        return "Track{" +
                "id=" + id +
                ", clanId=" + clanId +
                ", userId=" + userId +
                ", gold=" + gold +
                '}';
    }
}
