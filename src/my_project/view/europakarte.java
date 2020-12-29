package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class europakarte extends GraphicalObject {

    public europakarte(){
        setNewImage("daten/zentraleuropa.jpeg");
    }

    public void draw(DrawTool drawTool){
        drawTool.drawImage(getMyImage(), 0, 0);
    }
}
