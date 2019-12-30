package judds.github.com.base64modelloaderexample;

import android.os.Environment;

import androidx.annotation.NonNull;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileDataFetcher implements DataFetcher<InputStream> {
    private final FileEnveloper fileEnveloper;

    FileDataFetcher(FileEnveloper fileEnveloper) {
        this.fileEnveloper = fileEnveloper;
    }

    @Override
    public void loadData(@NonNull Priority priority, DataCallback<? super InputStream> callback) {
        try {
            unzip(); //Works fine!

            FileInputStream fin = new FileInputStream(fileEnveloper.getFile());
            ZipInputStream zin = new ZipInputStream(fin);
            zin.getNextEntry();//Essential!!!
            callback.onDataReady(zin);
        } catch (IOException e) {
            e.printStackTrace();
            callback.onLoadFailed(e);
        }
    }

    @Override
    public void cleanup() {
        // Intentionally empty only because we're not opening an InputStream or another I/O resource!
    }

    @Override
    public void cancel() {
        // Intentionally empty.
    }

    @NonNull
    @Override
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @NonNull
    @Override
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    private void unzip() throws IOException {
        String location = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator ;
        FileInputStream fin = new FileInputStream(fileEnveloper.getFile());
        ZipInputStream zin = new ZipInputStream(fin);
        ZipEntry ze;
        while ((ze = zin.getNextEntry()) != null) {
            if (ze.isDirectory()) {
                File dir = new File(location + ze.getName());
                if (!dir.exists() || !dir.isDirectory())
                    dir.mkdirs();
            } else {
                FileOutputStream fout = new FileOutputStream(location + ze.getName());
                byte[] buffer = new byte[1024];
                int read = 0;
                while ((read = zin.read(buffer)) != -1) {
                    fout.write(buffer, 0, read);
                }
                zin.closeEntry();
                fout.close();
            }
        }
        zin.close();
    }
}
