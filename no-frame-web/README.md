# tech skills contained in this project
### Filter managed by Spring
### Servlet managed by Spring
### cactus test servlet
### easymock test servlet
### httpunit test servlet
### httpclient test servlet
### jetty test servlet
### AOP
[Tutorial](https://www.tutorialspoint.com/springaop/springaop_implementations.htm "tutorialspoint")
>* Aspect - 方面<br>
    <p>
    一个关注点的模块化，这个关注点实现可能另外横切多个对象
>* JoinPoint - 连接点<br>
    <p>
    程序执行过程中明确的点，如方法的调用或特定的异常被抛出
>* Advice - 通知<br>
    <p>
    在特定的连接点，AOP框架执行的动作。各种类型的通知包括“around”、“before”和“throws”通知。<br>
    通知类型将在下面讨论。许多AOP框架包括Spring都是以拦截器做通知模型，维护一个“围绕”连接点的拦截器链
    - before<br>
    - after<br>
    - after-returning<br>
    - after-throwing<br>
    - around<br>
>* PointCut - 切入点<br>
    <p>
    指定一个通知将被引发的一系列连接点的集合。AOP框架必须允许开发者指定切入点，例如，使用正则表达式
>* Introduction - 引入<br>
    <p>
    添加方法或字段到被通知的类。Spring允许引入新的接口到任何被通知的对象。<br>
    例如，你可以使用一个引入使任何对象实现IsModified接口，来简化缓存
>* Target object - 目标对象<br>
    <p>
    包含连接点的对象，也被称作被通知或被代理对象
>* Weaving - 编织<br>
    <p>
    组装方面来创建一个被通知对象。这可以在编译时完成（例如使用AspectJ编译器），也可以在运行时完成。<br>
    Spring和其他纯Java AOP框架一样，在运行时完成织入