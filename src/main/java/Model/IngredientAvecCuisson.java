package Model;

public class IngredientAvecCuisson extends Ingredient{

    private int tempsCuisson;
    private String typeCuisson;

    public IngredientAvecCuisson(int id, String nom, int tempsCuisson, String typeCuisson) {
        super(id, nom);
        this.tempsCuisson = tempsCuisson;
        this.typeCuisson = typeCuisson;
    }

    public int getTempsCuisson() {
        return tempsCuisson;
    }

    public void setTempsCuisson(int tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }

    public String getTypeCuisson() {
        return typeCuisson;
    }

    public void setTypeCuisson(String typeCuisson) {
        this.typeCuisson = typeCuisson;
    }
}
