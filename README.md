# LasyLoadFragment
fragment懒加载，适用于淘宝我的订单。可选功能：切换activity返回刷新数据
适用tablayout+viewpage+fragment，场景：淘宝我的订单页
只需要复制LazyLoadFragment，继承即可

Fragment预加载问题的解决方案：
1.可以懒加载的Fragment，每次启动页面刷新数据
2.切换到其他页面时停止加载数据（可选）
3.任意fragment切换都会刷新数据


主要方法介绍
setContentView：添加布局文件
findViewById：实例化控件
finishCreateView：布局初始化完成，可以初始化工具类或context赋值
lazyLoad：开始请求网络数据
stopLoad()：取消网络请求

注意：
跳转activity，返回也会刷新数据，如果不需要，注释LazyLoadFragment类中onResume方法即可
