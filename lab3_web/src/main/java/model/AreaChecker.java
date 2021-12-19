package model;

import org.primefaces.PrimeFaces;

public class AreaChecker {
    private long startTime;

    public Result handleNumbers(float x, float y, float r) {
        startTime = System.nanoTime();
        boolean hitValue = checkGetInto(x,y,r);
        //PrimeFaces.current().executeScript("drawPoint(" + hitValue+ ")");
        float time = (float) (System.nanoTime() - startTime);
        return new Result(x, y, r, time, hitValue);
    }

    public boolean checkGetInto(float x, float y, float r) {
        if (checkIntoTriangle(x, y, r) || checkIntoRectangle(x, y, r) || checkIntoCircle(x, y, r)) {
            return true;
        }
        return false;
    }

    public boolean checkIntoTriangle(float x, float y, float r) {
        if ((x <= 0 && x >= -r  /2) && (y <= 0 && y >= -r)) {
            float d = ((x - (-r / 2)) * (-r - 0))- ((0 - (-r / 2) )* (y - 0));
            //(x - x1) * (y2 - y1) - (x2 - x1) * (y - y1) = 0
            if (d <= 0) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIntoRectangle(float x, float y, float r) {
        if ((x <= 0 && x >= -r) && (y <= r && y >= 0)) {
            return true;
        }
        return false;
    }

    public boolean checkIntoCircle(float x, float y, float r) {
        if (((x <= r && x >= 0) && (y <= 0 && y >= -r))) {
            if (((x * x + y * y) <= r * r)) {
                return true;
            }
        }
        return false;
    }
}
