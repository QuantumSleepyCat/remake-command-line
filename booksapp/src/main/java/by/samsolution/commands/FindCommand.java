package by.samsolution.commands;

import by.samsolution.commands.modelcommand.FindOptions;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by QuantumCat on 28.06.2017.
 */
public class FindCommand implements Command {
    public void execute(Map<String, String> commandArgumentsMap, String[] commandArguments) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        FindOptions findOptions = new FindOptions();
        findOptions.setCommandParams(commandArgumentsMap,commandArguments);
        for(String book:findOptions.getFileStrategy().getStudentsList(findOptions,findOptions.getFilename(),
                findOptions.getDirname()))
        {
            System.out.println(book);
        }
    }
}
