package by.samsolution.commands.modelcommand;

import by.samsolution.filebase.FileTXT;
import by.samsolution.filebase.strategy.FileStrategy;

import java.util.Map;

/**
 * Created by QuantumCat on 29.06.2017.
 */
public class CountOptions {
    private String year;
    private String filename;
    private String dirname;
    private FileStrategy fileStrategy;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public void setCommandParams(Map<String, String> commandParamsMap, String[] commandArguments) {
        this.year=commandParamsMap.get("year");
        this.filename = commandParamsMap.get("filename");
        this.dirname = commandParamsMap.get("dirname");
        this.fileStrategy = new FileTXT();
    }
}
