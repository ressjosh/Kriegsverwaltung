package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;

public class Verwaltungsoptionen extends GraphicalObject implements ButtonUser {

    private Button ab, cb, cd, de, ef, fg;

    public Verwaltungsoptionen() {
        //ab = new Button("", 950, 0,  )

    }

    @Override
    public void buttoneffect(int buttonNummer) {

    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }

    @Override
    public void registriereButtons(ViewController vC) {

    }
}
