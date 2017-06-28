package by.samsolution.params;

/**
 * Created by QuantumCat on 20.06.2017.
 */
public class ParamDefinition {
    private String name;
    private boolean isMandatory;
    private String paramPrefix="--";
    public ParamDefinition(String name, boolean isMandatory)
    {
        this.name=paramPrefix+name;
        this.isMandatory=isMandatory;
    }

    public ParamDefinition(String name)
    {
        this.name=paramPrefix+name;
        this.isMandatory=true;
    }

    public boolean getIsMandatory(){return isMandatory;}

    public String getName() {
        return name;
    }

}
