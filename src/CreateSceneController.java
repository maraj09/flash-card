
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

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

  Stack<String> question_list = new Stack<String>();
  Stack<String> answer_list = new Stack<String>();

  FileChooser fileChooser = new FileChooser();

  @FXML
  void nextCard(ActionEvent event) throws IOException {

    question_list.push(question.getText());
    answer_list.push(answer.getText());
    answer.setText("");
    question.setText("");
  }

  @FXML
  void saveAs(ActionEvent event) {
    File file = fileChooser.showSaveDialog(new Stage());

    if (file != null) {
      Object[] val1 = question_list.toArray();
      Object[] val2 = answer_list.toArray();

      try {
        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 0; i < val1.length; i++) {
          printWriter.write(val1[i].toString() + "\n");
          printWriter.write(val2[i].toString() + "\n");
        }
        printWriter.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

    }

  }
  @FXML Label menuHome;

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
