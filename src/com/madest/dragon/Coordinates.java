package com.madest.dragon;

import java.io.Serial;
import java.io.Serializable;

/**
 * Класс, описывающий размер дракона , шаблон класса составлен Университетом ИТМО
 * @author Artem Vladimirov ; artfok@bk.ru
 *
 */

public class Coordinates implements Serializable {

    @Serial
    private static final long serialVersionUID = -6627275768211792515L;
    private double x;
    private float y; //Значение поля должно быть больше -643


    public Coordinates(double x, float y) {
        this.x = x;
        this.y = y > -643 ? y : 0;
    }

    public  synchronized void setX(double x) {
        this.x = x;
    }

    public  synchronized double getX() {
        return x;
    }

    public synchronized void setIncrementedX() {
        x++;
    }
}
