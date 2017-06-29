package by.samsolution.filebase.strategy;


import by.samsolution.commands.modelcommand.AddOptions;
import by.samsolution.commands.modelcommand.CountOptions;
import by.samsolution.commands.modelcommand.FindOptions;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

/**
 * Created by QuantumCat on 10.06.2017.
 */
public interface FileStrategy {
    /**
     *
     * @param commandOptions
     * @param filename
     * @param dirname
     * @return
     * @throws IOException
     */
    List<String> getStudentsList(FindOptions commandOptions, String filename, String dirname) throws IOException, SAXException, ParserConfigurationException;

    /**
     *
     * @param commandOptions
     * @param filename
     * @param dirname
     */
    void addStudent(AddOptions commandOptions, String filename, String dirname) throws IOException, SAXException, ParserConfigurationException, TransformerException;

    /**
     *
     * @param commandOptions
     * @param filename
     * @param dirname
     * @return
     * @throws IOException
     */
    int countInYear(CountOptions commandOptions, String filename, String dirname) throws IOException;
}
