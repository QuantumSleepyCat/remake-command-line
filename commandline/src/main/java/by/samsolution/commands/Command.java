package by.samsolution.commands;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by QuantumCat on 20.06.2017.
 */
public interface Command {
    /**
     *
     * @param commandArgumentsMap
     * @param commandAguments
     * @throws ParserConfigurationException
     * @throws TransformerException
     * @throws SAXException
     * @throws IOException
     */
    void execute(Map<String,String> commandArgumentsMap, String[] commandAguments)throws ParserConfigurationException,TransformerException, SAXException, IOException;
}
