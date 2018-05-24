package onogonQuestMain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class onogonMap extends Application {

  private static final int RECT_SIZE = 50;
  private static final int AREA_SIZE = 500;

  @Override
  public void start(Stage primaryStage) throws Exception {
    Pane root = new Pane();

    Rectangle rect = new Rectangle(0, 0, RECT_SIZE, RECT_SIZE);
    root.getChildren().add(rect);

    Scene scene = new Scene(root, AREA_SIZE, AREA_SIZE);
    scene.setOnKeyPressed(event -> {
      double nextX = rect.getX();
      double nextY = rect.getY();
      switch (event.getCode()) {
        case RIGHT:
          if (nextX + RECT_SIZE <= AREA_SIZE - RECT_SIZE) {
            nextX += RECT_SIZE;
          }
          break;
        case LEFT:
          if (nextX - RECT_SIZE >= 0) {
            nextX -= RECT_SIZE;
          }
          break;
        case UP:
          if (nextY - RECT_SIZE >= 0) {
            nextY -= RECT_SIZE;
          }
          break;
        case DOWN:
          if (nextY + RECT_SIZE <= AREA_SIZE - RECT_SIZE) {
            nextY += RECT_SIZE;
          }
          break;
        default:
          break;
      }
      rect.setX(nextX);
      rect.setY(nextY);
    });

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
