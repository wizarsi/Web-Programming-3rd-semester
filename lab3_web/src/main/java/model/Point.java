package model;

public class Point {
    private float coordX;
    private float coordY;
    private float x;
    private float y;
    private boolean hitValue;

    public Point(float x, float y, boolean hitValue) {
        this.x = x;
        this.y = y;
        this.hitValue =hitValue;
    }

    public void calculateCoordinates(float r){
        convertToCoordinates(r);
    }
    public void convertToCoordinates(float r) {
        float tempCY = convertToCoordinate(y, r);
        float tempCX = convertToCoordinate(x, r);
        setCoordsSystemX(tempCX);
        setCoordsSystemY(tempCY);
    }

    public void setCoordsSystemX(float coordX) {
        float centerX = 150;
        if (coordX < 0) {
            this.coordX = centerX - (-coordX);
        } else {
            this.coordX = centerX+coordX;
        }
    }

    public void setCoordsSystemY(float coordY) {
        float centerY = 150;
        if (coordY < 0) {
            this.coordY = (-(coordY) + centerY);
        } else {
            this.coordY = centerY - coordY;
        }
    }

    public float convertToCoordinate(float value, float r) {
        return (value * 120) / r;
    }

    public boolean isHitValue() {
        return hitValue;
    }

    public void setHitValue(boolean hitValue) {
        this.hitValue = hitValue;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getCoordX() {
        return coordX;
    }

    public void setCoordX(float coordX) {
        this.coordX = coordX;
    }

    public float getCoordY() {
        return coordY;
    }

    public void setCoordY(float coordY) {
        this.coordY = coordY;
    }
}
