package by.samsolution.utility;



/**
 * Created by QuantumCat on 10.06.2017.
 */
public class AttributesPars {

    public String getAttr(String arg)
    {
        String[] attr = arg.split("=");
        if(attr.length==1)
        {
            throw new RuntimeException("Параметры указаны неверно");
        }
        return attr[1];
    }

    public String getAttrName(String arg)
    {
        String[] attr = arg.split("=");
        if(attr.length==1)
        {
            throw new RuntimeException("Параметры указаны неверно");
        }
        return attr[0].replace("--","");
    }

}
