package model;

import database.ResultService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class PointsManager implements Serializable {
    private String strX;
    private String strY;
    private String strR;
    private float x,y,r;
    private ArrayList<Result> results;
    private AreaChecker areaChecker;
    private long number;
    private AreaManager areaManager;
    private ResultService resultService;

    public PointsManager() {
        areaChecker = new AreaChecker();
        areaManager = new AreaManager(areaChecker);
        resultService = new ResultService();
        init();
        initArea();
    }

    public void init(){
        results = (ArrayList<Result>) resultService.getAllResults();
        Collections.reverse(results);
        try {
            number=results.get(0).getNumber();
        }catch (Exception ignored){
            number = 0;
        }
    }

    public void initArea(){
        r= 1;
        areaManager.setR(r);
        for(Result result:results){
            Point point = new Point(result.getX(), result.getY(), result.isHitValue());
            areaManager.addPoint(point);
        }
    }

    public void valuesToFloat(String strX,String strY,String strR){
        r = Float.parseFloat(strR);
        x = Float.parseFloat(strX);
        y = Float.parseFloat(strY);
    }

    public void submitButton() {
        valuesToFloat(strX,strY,strR);
        Result result;
        number++;
        result = areaChecker.handleNumbers(x,y,r);
        result.setNumber(number);
        resultService.addResult(result);
        results.add(0,result);
        Point point = new Point(x, y, result.isHitValue());
        areaManager.setR(r);
        areaManager.addPoint(point);
    }

    public void clearButton(){
        number = 0;
        results.clear();
        areaManager.clearPoints();
        resultService.clearResults();
    }


    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }


    public String getStrX() {
        return strX;
    }

    public void setStrX(String strX) {
        this.strX = strX;
    }

    public String getStrY() {
        return strY;
    }

    public void setStrY(String strY) {
        this.strY = strY;
    }

    public String getStrR() {
        return strR;
    }

    public void setStrR(String strR) {
        this.strR = strR;
        this.r = Float.parseFloat(strR);
        areaManager.setR(r);
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

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public AreaManager getAreaManager() {
        return areaManager;
    }

    public void setAreaManager(AreaManager areaManager) {
        this.areaManager = areaManager;
    }


}
