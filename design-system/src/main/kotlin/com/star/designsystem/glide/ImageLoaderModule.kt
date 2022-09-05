package com.star.designsystem.glide

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import okhttp3.OkHttpClient
import java.io.InputStream
import java.util.concurrent.TimeUnit

private const val CACHE_SIZE: Long = (20 * 1024 * 1024).toLong()
private const val READ_TIME_OUT = 20.toLong()
private const val CONNECT_TIME_OUT = 20.toLong()

@GlideModule
class ImageLoaderModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        val okHttpClient =
            OkHttpClient
                .Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .build()

        val factory = OkHttpUrlLoader.Factory(okHttpClient)

        glide.registry.replace(
            GlideUrl::class.java,
            InputStream::class.java,
            factory
        )
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        builder.setMemoryCache(LruResourceCache(CACHE_SIZE))
        builder.setDefaultRequestOptions(RequestOptions().setDefaultOption())
    }
}
