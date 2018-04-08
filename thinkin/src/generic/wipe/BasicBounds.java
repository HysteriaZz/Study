package generic.wipe;

import java.awt.*;

/**
 * Created by KaiLin.Guo on 2018-04-08.
 * 边界 extends 多个（1 class & n interface）
 */
public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();

    }
}
interface HasColord {
    Color getColor();
}

class Colored<T extends HasColord> {
    T item;

    public Colored(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }
}

class Dimension {
    public int x,y,z;
}

// class must be first, then interfaces, such as Dimension & HasColord
class ColoredDimension<T extends Dimension & HasColord> {
    T item;

    public ColoredDimension(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
}

interface Weight { int weight(); }

class Solid<T extends Dimension & HasColord & Weight> {
    T item;

    public Solid(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }

    int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColord,Weight {
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}
