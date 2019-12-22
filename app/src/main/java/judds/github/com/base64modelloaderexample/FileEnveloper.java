package judds.github.com.base64modelloaderexample;

import java.io.File;

public class FileEnveloper {
    private File file;

    public FileEnveloper(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileEnveloper that = (FileEnveloper) o;

        return file.equals(that.file);
    }

    @Override
    public int hashCode() {
        return file.hashCode();
    }
}
