## 使用

# 1. 下载 arthas-boot.jar

curl -O https://arthas.aliyun.com/arthas-boot.jar

# 2. 启动 arthas-boot.jar

java -jar arthas-boot.jar

## 断点方法

watch com.xxx.DemoApi demoFunction "{params,returnObj,throwExp}" -x 2

-e 抛出异常时, 才执行

## 查看方法的调用链

trace com.xxx.DemoApi demoFunction

## 向上看调用链

stack com.xxx.DemoApi demoFunction  -n 5 

