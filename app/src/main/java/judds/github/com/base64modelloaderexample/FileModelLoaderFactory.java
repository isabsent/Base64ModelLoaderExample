package judds.github.com.base64modelloaderexample;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;

import java.io.InputStream;

public class FileModelLoaderFactory implements ModelLoaderFactory<FileEnveloper, InputStream> {

  @NonNull
  @Override
  public ModelLoader<FileEnveloper, InputStream> build(@NonNull MultiModelLoaderFactory multiFactory) {
    return new FileModelLoader();
  }

  @Override
  public void teardown() {
    // Do nothing.
  }
}
