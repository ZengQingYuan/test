## 场景测试


### 1 请求Log输出
场景：
* 我希望能在Log上面看到请求的访问情况，便于排查问题

要求：
* 每次请求过来，Log输出：请求路径、请求参数（**application/json** 除外）
* 请求处理结束后，Log输出：请求路径、请求参数（**application/json** 除外）、耗时


### 2 请求Log跟踪
场景：
* 假设某个接口会被频繁访问，若某次突然出现异常的时候，我能在Log里面找到这次请求的所有上下文日志

要求：
* 以 **/test** 接口为例，实现Log关联打印

