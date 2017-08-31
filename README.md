# LasyLoadFragment
### fragment懒加载，
 * Fragment预加载问题的解决方案：
 * 1.可以懒加载的Fragment
 * 2.切换到其他页面时停止加载数据（可选）

### 适用场景
 * 适用于淘宝我的订单。
 * 适用tablayout+viewpage+fragment，淘宝我的订单页

### 主要方法介绍
 * setContentView：添加布局文件
 * findViewById：实例化控件
 * finishCreateView：布局初始化完成，可以初始化工具类或context赋值
 * lazyLoad：开始请求网络数据
 * stopLoad()：取消网络请求
  

### 注意事项
 * 任意fragment切换都会刷新数据
 * 跳转activity，返回也会刷新数据，如果不需要，注释onResume方法即可
 * 如果使用onResume方法，解锁屏幕也会刷新数据
   没必要最好不要用，容易出现问题，建议使用onActivityResult刷新数据

### 最后是效果图

![image](https://github.com/TurnTears/LasyLoadFragment/blob/a2fda9d97460d68fb87fb03e2477764bf9d0924e/imag/1.gif)