package com.madest.dragon;


/**
 * Класс , описывающий дракона , шаблон класса составлен Университетом ИТМО
 * @author Artem Vladimirov ; artfok@bk.ru
 *
 */

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;

public class Dragon implements Comparable<Dragon> , Serializable {


    @Serial
    private static final long serialVersionUID = -1287563493289382341L;
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long age; //Значение поля должно быть больше 0
    private Float wingspan; //Значение поля должно быть больше 0, Поле может быть null
    private Color color; //Поле может быть null
    private DragonType type; //Поле не может быть null
    private DragonHead head;


    public Dragon(String name, Coordinates coordinates, long age, Float wingspan, DragonType type, DragonHead head) {
        this.id = (int) (Math.random() * Integer.MAX_VALUE);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.age = age > 0 ? age : null;
        this.wingspan = wingspan > 0 ? wingspan : null;
        this.type = type;
        this.head = head;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getAge() {
        return age;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public DragonHead getHead() {
        return head;
    }

    @Override
    public int compareTo(Dragon o) {
        return Long.compare(age,o.age);
    }

    @Override
    public String toString() {
        return "com.madest.dragon.Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", wingspan=" + wingspan +
                ", color=" + color +
                ", type=" + type +
                ", head=" + head +
                '}';
    }

    public DragonType getType() {
        return type;
    }
}
