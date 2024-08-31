
## 线程排查

获取占用资源的进程             top                   
列出子线程                    ps -mp 16928 -o THREAD,tid,time | sort -r
获取子线程ID的十六进制          printf "%x\n" 17087
获取当前线程运行情况            jstack 16928 |grep 42bf -A 30
装载大小                      jstat -class 14018 30
前30大的类                    jmap -histo 4513 30
