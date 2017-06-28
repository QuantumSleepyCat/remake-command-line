package by.samsolution.commands.modelcommand;




import by.samsolution.filebase.FileTXT;
import by.samsolution.filebase.strategy.FileStrategy;

import java.util.Map;

/**
 * Created by QuantumCat on 27.06.2017.
 */
public class FindOptions {
    private String author;
    private String filename;
    private String dirname;
    private FileStrategy fileStrategy;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        this.author=commandParamsMap.get("author");
        this.filename = commandParamsMap.get("filename");
        this.dirname = commandParamsMap.get("dirname");
        this.fileStrategy = new FileTXT();
    }
}
