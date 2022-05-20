package org.max_sk.model;

import java.util.Objects;

public class Clan {

    private static long countId = 1;
    private long idClan;
    private String NAME;
    /*  Задание 2
     *  Использовал синхронизацию методов.
     *  Как альтернативный вариант можно было использовать AtomicInteger - он потока безопасен
     *  Или сохранять наши данные в Collections.synchronizedMap
     * */
    private int gold;
    public Clan(String name) {
        try {
            if (name.trim().length() == 0) {
                throw new NullPointerException("Имя не может быть нулевым");
            } else {
                this.NAME = name;
                this.gold = 0;
                idClan = incrementId();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public synchronized int getGold() {
        return gold;
    }

    /* Задание 2 -  Метод сделан синхронизированным,
    для того чтобы при большой количестве обращений из разных потоков
    значение оставалось актуальным  */
    public synchronized boolean incGold(Integer gold) {
        if (gold <= 0) {
            return false;
        }
        this.gold = this.gold + gold;
        return true;
    }

    /*  Задание 2 - Метод сделан синхронизированным,
        для того чтобы при большой количестве обращений из разных потоков
        значение оставалось актуальным  */
    public synchronized boolean decrementGold(int gold) {
        if (gold <= 0 || this.gold - gold < 0) {
            return false;
        }
        this.gold = this.gold - gold;
        return true;
    }

    private synchronized static long incrementId() {
        return countId++;
    }

    public synchronized long getIdClan() {
        return idClan;
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clan clan = (Clan) o;
        return countId == clan.countId &&
                gold == clan.gold &&
                NAME.equals(clan.NAME);
    }

    @Override
    public synchronized int hashCode() {
        return Objects.hash(countId, NAME, gold);
    }

    @Override
    public synchronized String toString() {
        return "Clan{" +
                "idClan=" + idClan +
                ", NAME='" + NAME + '\'' +
                ", gold=" + gold +
                '}';
    }
}
