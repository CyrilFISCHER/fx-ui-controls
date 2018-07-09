package org.modernclients.ch3.samples;

import java.util.function.Consumer;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.modernclients.ch3.Sample;

/**
 * @author Cyril FISCHER <contact@CyrilFischer.fr>
 */
public class ToolTipDemo implements Sample {

    @Override
    public void buildDemo(Pane container, Consumer<String> console) {

        Rectangle rectangle = new Rectangle(120, 120, Color.RED);
        Tooltip rectangleTooltip = new Tooltip("A Red Square (size : 120px)");
        Tooltip.install(rectangle, rectangleTooltip);
        Circle circle = new Circle(50, Color.BLUE);

        Button hoverButton = new Button("Hover over me");
        Tooltip buttonTootlip = new Tooltip("A button \n"
                + "Tooltip on control can be added with a convenient method");
        hoverButton.setTooltip(buttonTootlip);

        Tooltip circleTooltip = new Tooltip("A Blue Circle (radius : 50px)");
        Tooltip.install(circle, circleTooltip);

        layoutDemo(rectangle, hoverButton, circle, container);
    }

    private void layoutDemo(Rectangle rectangle, Button hoverButton, Circle circle, Pane container) {
        Text instructionText = new Text("Hover over nodes");
        instructionText.setStyle("-fx-font-size: 18;");
        HBox hBox = new HBox(rectangle, hoverButton, circle);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-spacing : 3em");
        VBox vBox = new VBox(instructionText, hBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-spacing : 3em");
        container.getChildren().add(vBox);
    }
}
