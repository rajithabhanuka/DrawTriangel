package DrawTriangle;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bhanuka
 */
public class Demo extends Application {

    Pane pane = new Pane();
    double width = 500;
    double height = 500;

    @Override
    public void start(Stage stage) throws Exception {
        Circle c = new Circle(width / 2, height / 2, 150);
        c.setFill(Color.YELLOW);
        c.setStroke(Color.DARKBLUE);
        pane.getChildren().add(c);

        Circle[] circles = new Circle[3];
        Line[] lines = new Line[3];
        Text[] texts = new Text[3];

        for (int i = 0; i < circles.length; i++) {
            texts[i] = new Text();
            circles[i] = new Circle(0, 0, 5);
            new DrawCircleImpl().setRandomLocation(circles[i], c);

            final int index = i;

            circles[i].setOnMouseDragged(e -> {

                double radian = Math.atan2(e.getY() - c.getCenterY(), e.getX() - c.getCenterX());
                double x = c.getCenterX() + c.getRadius() * Math.cos(radian);
                double y = c.getCenterY() + c.getRadius() * Math.sin(radian);
                circles[index].setCenterX(x);
                circles[index].setCenterY(y);
                new DrawCircleImpl().updateLines(lines, circles, texts);
            });

        }
        
        for (int i = 0; i < lines.length; i++) {
            int cIndex2 = (i + 1 >= circles.length) ? 0 : i + 1;
            lines[i] = new Line(
                    circles[i].getCenterX(), circles[i].getCenterY(),
                    circles[cIndex2].getCenterX(), circles[cIndex2].getCenterY());

        }
        
        new DrawCircleImpl().updateLines(lines, circles, texts);
        pane.getChildren().addAll(lines);
        pane.getChildren().addAll(texts);
        pane.getChildren().addAll(circles);

        Scene scene = new Scene(pane, width, height);
        stage.setTitle("Dyanamic Triangle By Bhanu");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
