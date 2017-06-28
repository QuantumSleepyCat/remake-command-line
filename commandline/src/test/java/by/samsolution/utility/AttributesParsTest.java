package by.samsolution.utility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by QuantumCat on 23.06.2017.
 */
public class AttributesParsTest {

    @Test(expected = RuntimeException.class)
    public void getAttrRuntimeException() {
        new AttributesPars().getAttr("str");
    }

    @Test(expected = RuntimeException.class)
    public void getAttrNameRuntimeException(){
        new AttributesPars().getAttrName("str");
    }

    @Test(expected = NullPointerException.class)
    public void getAttrNullPointerException() {
        new AttributesPars().getAttr(null);
    }

    @Test(expected = NullPointerException.class)
    public void getAttrNameNullPointerException(){
        new AttributesPars().getAttrName(null);
    }

    @Test
    public void getAttr() throws Exception {
        assertEquals(new AttributesPars().getAttr("--name=somename"),"somename");
    }

    @Test
    public void getAttrName() throws Exception {
        assertEquals(new AttributesPars().getAttrName("--name=somename"),"name");
    }


}