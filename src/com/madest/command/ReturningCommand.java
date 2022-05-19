package com.madest.command;

import com.madest.apprunner.DragonSetHolder;

public interface ReturningCommand {

    String doCommand(DragonSetHolder dragonsSet, boolean returnResponse);
}
