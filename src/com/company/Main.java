package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //read input from file
        List<Point> points = readFile();
        int count = 0;

        for (Point leftDown : points
        ) { //for each point in the array generate list of possible left ups
            List<Point> leftUp = generateLeftUp(points, leftDown);
            for (Point leftU : leftUp
            ) { //for each point in the left ups, generate right down points
                List<Point> rightDown = generateRightDown(points, leftDown);
                for (Point rightD : rightDown
                ) {
                    //for each right down point generate the final point
                    Point point = new Point(rightD.getX(), leftU.getY());
                    //verify if it exists in the array
                    if (points.contains(point))
                        count++;

                }

            }

        }
        System.out.println(count);

    }

    //read sample input from a file
    public static List<Point> readFile() {
        List<Point> points = new ArrayList<>();
        try {
            File myObj = new File("points.in");
            Scanner myReader = new Scanner(myObj);
            String line = myReader.nextLine();
            line = line.replaceAll("\\)", "");
            line = line.replaceAll(" ", "");
            String[] arr = line.replaceAll("\\(", "").split(",");

            for (int i = 0; i < arr.length; i += 2)
                points.add(new Point(Integer.parseInt(arr[i]), Integer.parseInt(arr[i + 1])));

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return points;
    }

    //generate list of elements that could be possible left up elements
    public static List<Point> generateLeftUp(List<Point> points, Point point) {
        List<Point> leftUp = new ArrayList<>();
        for (Point p : points
        ) {
            if (p.getX() == point.getX())
                if (p.getY() > point.getY()) leftUp.add(p);

        }
        return leftUp;
    }

    //generate list of elements that could be possible right down elements
    public static List<Point> generateRightDown(List<Point> points, Point point) {
        List<Point> rightDown = new ArrayList<>();
        for (Point p : points
        ) {
            if (p.getY() == point.getY())
                if (p.getX() > point.getX()) rightDown.add(p);

        }

        return rightDown;
    }


}
