package com.madest.apprunner;

import com.madest.dragon.Dragon;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class DragonSetHolder {

    private Set<Dragon> dragonSet;


    public DragonSetHolder() {
        dragonSet = new HashSet<>();
    }

    public boolean add(Dragon dragon) {
        return dragonSet.add(dragon);

    }


    public boolean remove(Dragon dragon) {
        return dragonSet.remove(dragon);
    }

    public Set<Dragon> getDragonSet() {
        return dragonSet;
    }

    public int size() {
        return dragonSet.size();
    }

    public void clear() {
        dragonSet.clear();
    }

    public Stream<Dragon> stream() {
        return dragonSet.stream();
    }

    @Override
    public String toString() {
        return dragonSet.toString();
    }
}
