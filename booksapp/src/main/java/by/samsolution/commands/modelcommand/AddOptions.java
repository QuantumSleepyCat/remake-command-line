package by.samsolution.commands.modelcommand;

import by.samsolution.filebase.FileTXT;
import by.samsolution.filebase.strategy.FileStrategy;

import java.util.Map;

/**
 * Created by QuantumCat on 27.06.2017.
 */
public class AddOptions{
    private String title;
    private String author;
    private String year;
    private String number;
    private String filename;
    private String dirname;
    private FileStrategy fileStrategy;
    private String[] argumentsCommand;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDirname() {
        return dirname;
    }

    public void setDirname(String dirname) {
        this.dirname = dirname;
    }

    public FileStrategy getFileStrategy() {
        return fileStrategy;
    }

    public void setFileStrategy(FileStrategy fileStrategy) {
        this.fileStrategy = fileStrategy;
    }

    public String[] getArgumentsCommand() {
        return argumentsCommand;
    }

    public void setArgumentsCommand(String[] argumentsCommand) {
        this.argumentsCommand = argumentsCommand;
    }

    public void setCommandParams(Map<String, String> commandParamsMap, String[] commandArguments) {
        this.title = commandParamsMap.get("title");
        this.author = commandParamsMap.get("author");
        this.year = commandParamsMap.get("year");
        this.number = commandParamsMap.get("number");
        this.filename = commandParamsMap.get("filename");
        this.dirname = commandParamsMap.get("dirname");
        this.fileStrategy = new FileTXT();
    }
}
