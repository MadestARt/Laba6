package com.madest.dragon;

import java.io.Serial;
import java.io.Serializable;

/**
 * Класс, описывающий голову дракона , шаблон класса составлен Университетом ИТМО
 * @author Artem Vladimirov ; artfok@bk.ru
 *
 */

public class DragonHead implements Serializable {
    @Serial
    private static final long serialVersionUID = -5189354952025135496L;
    private float eyesCount;

    public DragonHead(float eyesCount) {
        this.eyesCount = eyesCount;
    }

    public float getEyesCount() {
        return eyesCount;
    }
}
