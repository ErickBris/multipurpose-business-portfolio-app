package com.csform.businessportfolio;

import android.content.Context;
import android.widget.ImageView;

import com.csform.businessportfolio.syncdata.SyncDataHelper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

public class Utils {
	
	public static void setImageWithImageLoader(ImageView imageView, Context context, String id,
			String image, SimpleImageLoadingListener listener) {
		ImageLoader loader = ImageLoader.getInstance();
		DisplayImageOptions options = getDisplayImageOtions();
		if (!loader.isInited()) {
			loader.init(getImageConfig(context));
		}
		try {
			String uri;
			if (id != null) {
				uri = SyncDataHelper.URL_UPLOADS + id + image;
			} else {
				uri = image;
			}
			loader.displayImage(uri, imageView, options, listener);
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
	}
	
	public static ImageLoaderConfiguration getImageConfig(Context context) {
		ImageLoaderConfiguration imageConfig = new ImageLoaderConfiguration.Builder(context)
				.build();
		return imageConfig;
	}
	
	public static DisplayImageOptions getDisplayImageOtions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
					.imageScaleType(ImageScaleType.EXACTLY)
					.showImageForEmptyUri(R.drawable.icon_default)
					.showImageOnLoading(R.drawable.icon_default)
					.showImageOnFail(R.drawable.icon_default)
					.cacheOnDisc(true)
					.cacheInMemory(true)
					.build();
		return options;
	}
}
