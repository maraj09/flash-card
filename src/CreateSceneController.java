
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CreateSceneController {

  @FXML
  private TextArea question;
  @FXML
  private TextArea answer;

  Queue<String> question_list = new LinkedList<>();
  Queue<String> answer_list = new LinkedList<>();

  FileChooser fileChooser = new FileChooser();

  @FXML
  void nextCard(ActionEvent event) throws IOException {

    question_list.add(question.getText());
    answer_list.add(answer.getText());
    answer.setText("");
    question.setText("");
  }

  @FXML
  void saveAs(ActionEvent event) {
    File file = fileChooser.showSaveDialog(new Stage());

    if (file != null) {
      int size = question_list.size();
      try {
        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 0; i < size; i++) {
          printWriter.write(question_list.poll() + "\n");
          printWriter.write(answer_list.poll() + "\n");
        }
        printWriter.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

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
}
