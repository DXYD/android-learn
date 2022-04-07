package com.example.myapplication.命名规范的一些说明;

/**
 * The type Case.
 *
 * @author CodeMilk
 * @version 1.0
 * @title CamelCase
 * @projectName My Application
 * @description TODO
 * @date 2022 /4/7 20:03
 */
public class Case {
    /**
     * 小驼峰命名(lowerCamelCase)
     * 方法名、参数名、成员变量、局部变量需要使用小驼峰命名法
     *
     * getUserInfo()
     * createCustomThreadPool()
     * findAllByUserName(String userName)
     * TaskRepository taskRepository;
     */

    /**
     * 大驼峰命名(CamelCase)
     * 常用于类名，命名空间
     *
     * class TaskDateToSend{}
     * class TaskLabelToSend{}
     * SettingRepository
     */

    /**
     * 蛇形命名法(snake_case)
     * 蛇形法是全由小写字母和下划线组成，在两个单词之间用下滑线连接即可。
     * 测试方法名、常量、枚举名称需要使用蛇形命名法
     *
     * first_name
     * last_name
     * MAX_ITERATION
     * LAST_DATA
     */

    /**
     * 串式命名法(kebab-case)
     * 在串式命名法中，各个单词之间通过下划线“-”连接，比如：
     * 项目文件夹名称使用串式命名法(kebab-case)
     *
     * hello-world
     * first-project
     */

    /**
     * Java总体命名规范
     *
     * 类名需要使用大驼峰命名法（UpperCamelCase）风格。
     * 方法名、参数名、成员变量、局部变量需要使用小驼峰命名法（lowerCamelCase）。
     * 测试方法名、常量、枚举名称需要使用蛇形命名法（snake_case） ，比如test_get_user()、TIME_LIMIT。并且，测试方法名称要求全部小写，常量以及枚举名称需要全部大写。
     * 项目文件夹名称使用串式命名法（kebab-case），比如dubbo-registry。
     * 包名统一使用小写，尽量使用单个名词作为包名，各个单词通过 "." 分隔符连接，并且各个单词必须为单数。
     * 抽象类命名使用 Abstract 开头。如：public abstract class AbstractClient extends AbstractEndpoint{}。
     * 异常类命名使用 Exception 结尾。如：public class NoSuchMethodException extends RuntimeException{}。
     * 测试类命名以它要测试的类的名称开始，以 Test 结尾。如：public class AnnotationUtilsTest{}。
     */
}


