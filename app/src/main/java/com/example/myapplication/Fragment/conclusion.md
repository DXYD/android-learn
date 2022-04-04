## 动态添加Fragment
+   创建一个待处理的fragment
+   获取FragmentManager，一般都是通过getSupportFragmentManager()
+   开启一个事务transaction，一般调用fragmentManager的beginTransaction()
+   使用transaction进行fragment的替换
+   提交事务

## Activity 与 Fragment 通信
原生方案 ： Bundle
>   见code_MainFragment

Java方案 ： 通过面向接口来通讯
>   通过接口实现弱关联

