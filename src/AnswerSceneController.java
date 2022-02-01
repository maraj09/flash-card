import java.io.File;

import java.io.IOException;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AnswerSceneController {
  FileChooser fileChooser = new FileChooser();
  @FXML
  private TextArea question;
  Scanner sc;
  Boolean show;
  @FXML
  Button showAnswer; 

  @FXML
  void openAs(ActionEvent event) throws Exception {
    File file = fileChooser.showOpenDialog(new Stage());
    if (file != null) {

      sc = new Scanner(file);
      question.setText(sc.nextLine());
      show = false;
      showAnswer.setText("Show Answer");
      showAnswer.setStyle("-fx-background-color: orange");
    }

  }

  @FXML
  Label menuHome;
 

  @FXML 
  void menuHome(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScene.fxml"));
    Parent root = loader.load();

    Scene scene = new Scene(root);

    Stage stage = (Stage) menuHome.getScene().getWindow();
    stage.setTitle("Flash card");
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  void menuExit(ActionEvent event) {
    Platform.exit();
    System.exit(0);
  }
  @FXML
  void showAnswer(){
    question.setText(sc.nextLine());
    show = !show;
    if (show) {
      showAnswer.setStyle("-fx-background-color: green");
      showAnswer.setText("Next");
    }else{
      showAnswer.setStyle("-fx-background-color: orange");
      showAnswer.setText("Show Answer");
    }
  }
}
