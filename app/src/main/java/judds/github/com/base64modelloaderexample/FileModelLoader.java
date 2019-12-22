package judds.github.com.base64modelloaderexample;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

import java.io.InputStream;

/**
 * Loads an {@link InputStream} from a Base 64 encoded String.
 */
public final class FileModelLoader implements ModelLoader<FileEnveloper, InputStream> {
//  private static final String DATA_URI_PREFIX = "data:";

    @Override
    public LoadData<InputStream> buildLoadData(@NonNull FileEnveloper fileEnveloper, int width, int height, @NonNull Options options) {
        return new LoadData<>(new ObjectKey(fileEnveloper), new FileDataFetcher(fileEnveloper));
    }

    @Override
    public boolean handles(FileEnveloper fileEnveloper) {
        return fileEnveloper.getFile().exists();
    }
}
