package Model;

public class IngredientAvecCuisson extends Ingredient{

    private int tempsCuisson;
    private String typeCuisson;

    public IngredientAvecCuisson(int id, String nom, int tempsCuisson, String typeCuisson) {
        super(id, nom);
        this.tempsCuisson = tempsCuisson;
        this.typeCuisson = typeCuisson;
    }
}
