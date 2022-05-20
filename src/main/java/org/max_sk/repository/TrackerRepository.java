package org.max_sk.repository;

import org.max_sk.model.Track;

import java.util.HashMap;

public class TrackerRepository {
    /*  Нет необходимости сохранять данные в БД, поэтому будем хнарить в HashMap */
    private static final HashMap<Long, Track> trackHashMap = new HashMap<>();

    public static HashMap<Long, Track> getTrackHashMap() {
        return trackHashMap;
    }
}
