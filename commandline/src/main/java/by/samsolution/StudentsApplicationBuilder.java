package by.samsolution;

import by.samsolution.commands.definition.CommandDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by QuantumCat on 20.06.2017.
 */
public class StudentsApplicationBuilder {

    private Map<String, String> config;
    private List<CommandDefinition> commandDefinitionList = new ArrayList<CommandDefinition>();

    public StudentsApplicationBuilder withCommand(CommandDefinition commandDefinition)
    {
        commandDefinitionList.add(commandDefinition);
        return this;
    }

    public StudentsApplicationBuilder withConfig(Map<String, String> config)
    {
        this.config=config;
        return this;
    }

    public StudentsApplication build(){
        return new StudentsApplication(config, commandDefinitionList);
    }

}
