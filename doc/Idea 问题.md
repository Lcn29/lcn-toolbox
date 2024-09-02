## Idea 常用插件
	Java Visualizer
	jclasslib Bytecode Viewer
    Xcode-Dark Theme
    Translation
    MyBatisCodeHelperPro
    Maven Helper
    Jprofiler
    Key Promoter X
    EasyCode
    arthas idea
    JRebel and XRebel
    RestfulToolkit-fix
    arthas idea

## Idea 中使用 Rebel 插件热部署
> 1. 按照官网的步骤安装 Rebel 插件
> 2. JRebel 激活
>> 1. 填写地址: http://42.193.18.168:8088/
>> 2. GUID 生成  https://www.guidgen.com/

## Rebel 项目中启动不起来
Preferences -> Languages & Frameworks -> Reactive Streams
将右侧中的 Enable Reactor Debug mode 中的 Debug mode initialization method 修改为 None。

## Jdk21 在 Idea 报 MaxPermSize=512m 错误

Preferences -> Build, Execution, Deployment -> Compiler
将右侧中的 Shared build process VM options 中的 -XX:MaxPermSize=512m 删除即可。



