package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.EuropakartenModel;

public class Verwaltungsstart {
    private EuropakartenModel ekM;
    private ViewControll vC;
    private ViewController viewController;
    private SQLControll sqlControll;

    public Verwaltungsstart(ViewController viewController){
        this.viewController = viewController;
        ekM = new EuropakartenModel();
        vC = new ViewControll(viewController, ekM);
        sqlControll = new SQLControll();
    }
}
