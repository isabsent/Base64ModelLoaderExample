# Base64ModelLoaderExample
An example of how to write a custom ModelLoader for Base 64 encoded Strings

Adaptation to ZIP-archive

While unzip method works fine (file 00.JPG have been  successfully created on the disk), Glide doesn't show zipped picture from the file 00.zip in the ImageView.

Stacktrace:

    2019-12-22 13:57:22.605 28803-28803/judds.github.com.base64modelloaderexample W/Glide: Load failed for judds.github.com.base64modelloaderexample.FileEnveloper@2d3a6e1c with size [720x1257]
    class com.bumptech.glide.load.engine.GlideException: Failed to load resource
      Cause (1 of 1): class com.bumptech.glide.load.engine.GlideException: Failed LoadPath{ZipInputStream->Object->Drawable}, LOCAL
        Cause (1 of 3): class com.bumptech.glide.load.engine.GlideException: Failed DecodePath{ZipInputStream->GifDrawable->Drawable}
        Cause (2 of 3): class com.bumptech.glide.load.engine.GlideException: Failed DecodePath{ZipInputStream->Bitmap->Drawable}
        Cause (3 of 3): class com.bumptech.glide.load.engine.GlideException: Failed DecodePath{ZipInputStream->BitmapDrawable->Drawable}
