package controller.Business;

public class CreditController {
    private static int points;

    public static void setPoints(int points) {
        CreditController.points = points;
    }
    public static int getPoints() {
        return points;
    }

    public CreditController(){}
}
