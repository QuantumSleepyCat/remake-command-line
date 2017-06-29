package by.samsolution;

import by.samsolution.commands.AddCommand;
import by.samsolution.commands.CountCommand;
import by.samsolution.commands.FindCommand;
import by.samsolution.commands.definition.CommandDefinition;
import by.samsolution.params.ParamDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by QuantumCat on 28.06.2017.
 */
public class EntryPointApplication {

    public static void main(String[] args)
    {
        List<ParamDefinition> paramsAdd = new ArrayList<ParamDefinition>();
        paramsAdd.add(new ParamDefinition("title"));
        paramsAdd.add(new ParamDefinition("author"));
        paramsAdd.add(new ParamDefinition("year"));
        paramsAdd.add(new ParamDefinition("number"));
        paramsAdd.add(new ParamDefinition("filename", false));
        paramsAdd.add(new ParamDefinition("dirname", false));
        List<ParamDefinition> paramsFind = new ArrayList<ParamDefinition>();
        paramsFind.add(new ParamDefinition("author"));
        paramsFind.add(new ParamDefinition("filename", false));
        paramsFind.add(new ParamDefinition("dirname", false));
        List<ParamDefinition> paramsCount = new ArrayList<ParamDefinition>();
        paramsCount.add(new ParamDefinition("year"));
        paramsCount.add(new ParamDefinition("filename", false));
        paramsCount.add(new ParamDefinition("dirname", false));
        Map<String, String> config = new HashMap<String, String>();
        config.put("filename", "books.txt");
        config.put("dirname", "books");
        StudentsApplication application = new StudentsApplicationBuilder()
                .withCommand(new CommandDefinition("add", AddCommand.class, paramsAdd))
                .withCommand(new CommandDefinition("find", FindCommand.class, paramsFind))
                .withCommand(new CommandDefinition("count", CountCommand.class, paramsCount))
                .withConfig(config).build();
        application.run(args);
    }

}
