package model;


import java.util.ArrayList;


public class AreaManager {
    private float r;
    private ArrayList<Point> points =new ArrayList<>();
    private AreaChecker areaChecker;
    public AreaManager(AreaChecker areaChecker) {
        this.areaChecker = areaChecker;
    }

    public void addPoint(Point point){
        point.calculateCoordinates(r);
        point.setHitValue(areaChecker.checkGetInto(point.getX(),point.getY(),r));
        points.add(point);
    }

    public void clearPoints(){
        points.clear();
    }

    public void updateCoordinates(){
        for (Point point:points) {
            point.calculateCoordinates(r);
            point.setHitValue(areaChecker.checkGetInto(point.getX(),point.getY(),r));
        }
    }


    public float getR() {
        return r;
    }

    public void setR(float r) {
        if(r !=this.r) {
            this.r = r;
            updateCoordinates();
        }
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

}
