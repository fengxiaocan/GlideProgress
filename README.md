# GlideProgress
通过hook Glide的请求,给Glide添加下载进度监听,基于4.11.0版本,可向下兼容.
Glide默认使用HttpUrlConnect下载图片,通过hook下载方法来实现下载进度监听.

使用方式:
  通过
      
      GlideInitialize.initialize(Context,GlideBuilder);
  
  来初始化,暂时不能使用xml来配置,也不能通过引用
  
      com.bumptech.glide.GeneratedAppGlideModuleImpl
  
  来添加额外配置
  GlideBuilder中可以实现绝大部分的Glide配置了。
  
  调用:
      
      GlidePack.with(Context).load(String/URL).onProgressListener().attach(ImageView);
      
  通过into无效,通过load(bitmap)无效,图片下载完成自动清理progressListener,防止内存泄漏;
  
引用:  
Step 1. Add the JitPack repository to your build file gradle

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.fengxiaocan:GlideProgress:1.0.4'
	}
