package com.madest.command;

import com.madest.apprunner.DragonSetHolder;
import com.madest.dragon.Dragon;

import java.util.Set;

@FunctionalInterface
public interface Command {

    void doCommand(DragonSetHolder dragonsSet);
}
