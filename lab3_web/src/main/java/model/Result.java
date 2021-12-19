package model;


import javax.persistence.*;

@Entity
@Table(name = "results")
public class Result {
    private float x;
    private float y;
    private float r;
    @Id
    private long number;
    private float time;
    private boolean hitValue;

    public Result(float x, float y, float r, float time, boolean hitValue) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.time = time;
        this.hitValue = hitValue;
    }

    public Result() {

    }

    public boolean isHitValue() {
        return hitValue;
    }

    public void setHitValue(boolean hitValue) {
        this.hitValue = hitValue;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }


    public long getNumber() {
        return number;
    }

    public float getTime() {
        return time;
    }
}
