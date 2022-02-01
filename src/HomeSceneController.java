import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HomeSceneController {

  @FXML
  void createClicked(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateScene.fxml"));
    Parent root = loader.load();

    Scene scene = new Scene(root);

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setTitle("Flash card");
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  void exitClicked(ActionEvent event) {
    Platform.exit();
    System.exit(0);
  }

  @FXML
  void playClicked(ActionEvent event) {

  }

}
