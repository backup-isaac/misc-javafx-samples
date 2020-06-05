/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 *
 * @author IsaacWeintraub
 */
public class FXMLExampleController {
    
    @FXML private Text actionTarget;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent evt) {
        actionTarget.setText("Sign in button pressed");
    }
}
