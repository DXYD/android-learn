package com.example.myapplication.Glide;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * @author CodeMilk
 * @title: MyAppModule
 * @projectName My Application
 * @description: TODO
 * @date 2022/4/6 20:53
 */

/**
 * 在 Application 模块中的使用
 * 在 Application 模块中，可创建一个添加有 @GlideModule 注解，继承自 AppGlideModule 的类。此类可生成出一个流式 API，内联了多种选项，和集成库中自定义的选项：
 */
@GlideModule
public final class MyAppModule extends AppGlideModule {
}
