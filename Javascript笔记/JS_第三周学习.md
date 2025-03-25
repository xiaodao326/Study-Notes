# 01_事件监听
## 认识事件监听
- 事件是在编程时系统内发生的动作或者发生的事情
    比如用户在网页上单击一个按钮
- 什么是事件监听？
    - 就是让程序检测是否有事件产生，一旦有事件触发，就立即调用一个函数做出响应，也称为 绑定事件或者注册事件
    - 比如鼠标经过显示下拉菜单，比如点击可以播放轮播图等等
- 语法：
    `元素对象.addEventListener('事件类型’，要执行的函数)`
- 事件监听三要素：
    - 事件源： 那个dom元素被事件触发了，要获取dom元素
    - 事件类型：用什么方式触发，比如鼠标单击click、鼠标经过 mouseover
    - 事件调用的函数：要做什么事
- 举例：
```
<button>按钮</button>
<script>
const btn = document.querySelector('.btn')
// 修改元素样式
btn.addEventListener('click',function (){
alert('点击了~'）
})
</script>
```
- 注意：
    1. 事件类型要加引号
    2. 函数是点击之后再去执行，每次点击都会执行一次
### 总结
1. 什么是事件监听？
    就是让程序检测是否有事件产生，一旦有事件触发，就立即调用一个函数做出响应，也称为注册事件
2. 事件监听三要素是什么?
    - 事件源（谁被触发了）
    - 事件类型（用什么方式触发，点击还是鼠标经过等）
    - 事件处理程序（要做什么事情）
## 事件类型
### 鼠标事件
- 触发方式：鼠标触发
    click 鼠标点击
    mouseenter 鼠标经过
    mouseleave 鼠标离开
### 焦点事件
- 触发事件：表单获得光标
    focus 获得焦点
    blur 失去焦点
### 键盘事件
- 触发事件：键盘触发
    Keydown 键盘按下触发
    Keyup 键盘抬起触发
### 文本事件
- 触发事件：表单输入触发
    input 用户输入事件
## 事件对象
- 事件对象是什么
    也是个对象，这个对象里有事件触发时的相关信息
    例如：鼠标点击事件中，事件对象就存了鼠标点在哪个位置等信息
- 使用场景
    可以判断用户按下哪个键，比如按下回车键可以发布新闻
    可以判断鼠标点击了哪个元素，从而做相应的操作
### 获取事件对象

- 语法：如何获取
    在事件绑定的回调函数的第一个参数就是事件对象
    一般命名为event、ev、e
`元素.addEventListener('click'，function(e){}`
#### 总结
1. 事件对象是什么？
    也是个对象，这个对象里有事件触发时的相关信息
2. 事件对象在哪里？
    在事件绑定的回调函数的第一个参数就是事件对象
3. 语法:
    `元素.addEventListener('click'，function(e){}`
### 部分常用属性
- type
    获取当前的事件类型
- clientX/clientY
    获取光标相对于浏览器可见窗口左上角的位置
- offsetX/offsetY
    获取光标相对于当前DOM元素左上角的位置
- key
    用户按下的键盘键的值
    现在不提倡使用keyCode
## 环境对象
- 环境对象：
    指的是函数内部特殊的变量this，它代表着当前函数运行时所处的环境
- 作用：
    弄清楚this的指向，可以让我们代码更简洁
- 函数的调用方式不同，this指代的对象也不同
- 【谁调用，this就是谁】是判断this指向的粗略规则
- 直接调用函数，其实相当于是 window.函数，所以 this 指代 window
### 总结
1. 环境对象this是什么？
    它代表着当前函数运行时所处的环境
2. 判断this指向的粗略规则是什么？
    【谁调用，this就是谁】
## 回调函数
- 定义：
    如果将函数A做为参数传递给函数B时，我们称函数A为回调函数
- 简单理解：
    当一个函数当做参数来传递给另外一个函数的时候，这个函数就是回调函数
- 常见的使用场景：
```
function fn(){
console.log('我是回调函数...‘）
//fn传递给了setInterval，fn就是回调函数
setInterval(fn,1000)

box.addEventListener('click',function (){
console.log('我也是回调函数‘）
})
```
### 总结
1. 回调函数
    - 把函数当做另外一个函数的参数传递，这个函数就叫回调函数
    - 回调函数本质还是函数，只不过把它当成参数使用
    - 使用匿名函数做为回调函数比较常见
## 拓展
### 事件监听版本
- DOM L0
    事件源.on事件=function(){}
- DOM L2
    事件源.addEventListener（事件，事件处理函数）
- 区别：
    on方式会被覆盖，addEventListener方式可绑定多次，拥有事件更多特性，推荐使用
### 发展史
- DOM L0：是DOM的发展的第一个版本；L: level
- DOM L1：DOM级别1于1998年10月1日成为W3C推荐标准
- DOM L2：使用addEventListener注册事件
- DOM L3：DOM3级事件模块在DOM2级事件的基础上重新定义了这些事件，也添加了一些新事件类型

# 02_事件流
## 事件流
### 事件流和两个阶段说明
- 概念：
    指的是事件完整执行过程中的流动路径
- 说明：
    假设页面里有个div，当触发事件时，会经历两个阶段，分别是捕获阶段、冒泡阶段
- 简单来说：
    捕获阶段是从父到子冒泡阶段是从子到父
- ===实际工作都是使用事件冒泡为主===
### 事件捕获
- 事件捕获概念：
    从DOM的根元素开始去执行对应的事件（从外到里)
- 事件捕获需要写对应代码才能看到效果
- 代码：
```
DOM.addEventListener(事件类型，事件处理函数，是否使用捕获机制)
```
- 说明:
    - addEventListener第三个参数传入true代表是捕获阶段触发（很少使用)
    - 若传入false代表冒泡阶段触发，默认就是false
### 事件冒泡
- 事件冒泡概念：
    当一个元素的事件被触发时，同样的事件将会在该元素的所有祖先元素中依次被触发。这一过程被称为事件冒泡
- 简单理解：
    当一个元素触发事件后，会依次向上调用所有父级元素的===同名事件===
- 事件冒泡是默认存在的
- L2事件监听第三个参数是false，或者默认都是冒泡
示例：
```
const father = document.querySelector('.father')
const son = document.querySelector('.son')
document.addEventListener('click', function (){
alert('我是爷爷')
})
fa.addEventListener('click', function (){
alert('我是爸爸')
})
son.addEventListener('click',function (){
alert('我是儿子‘)
})
```
### 阻止冒泡
- 目标：
    能够写出阻止冒泡的代码
- 问题：
    因为默认就有冒泡模式的存在，所以容易导致事件影响到父级元素
- 需求：
    若想把事件就限制在当前元素内，就需要阻止事件冒泡
- 前提：
    阻止事件冒泡需要拿到事件对象
- 语法：
    `事件对象.stopPropagation()`
- 注意：
    此方法可以阻断事件流动传播，不光在冒泡阶段有效，捕获阶段也有效
### 解绑事件 
- on事件方式，直接使用null覆盖偶就可以实现事件的解绑
- 语法：
```
// 绑定事件
btn.onclick = function (){
alert('点击了')
//解绑事件
btn.onclick = null
```
- addEventListener方式，必须使用：
    `removeEventListener(事件类型，事件处理函数，[获取捕获或者冒泡阶段])`
- 例如：
```
function fn() {
alert('点击了‘)
// 绑定事件
btn.addEventListener('click',fn)
// 解绑事件
btn.removeEventListener('click',fn)
```
- 注意：
    匿名函数无法被解绑
### 两种注册事件的区别
#### 传统on注册（L0）
- 同一个对象，后面注册的事件会覆盖前面注册（同一个事件)
- 直接使用null覆盖偶就可以实现事件的解绑
- 都是冒泡阶段执行的
#### 事件监听注册（L2）
- 语法：
    `addEventListener(事件类型，事件处理函数，是否使用捕获)`
- 后面注册的事件不会覆盖前面注册的事件（同一个事件)
- 可以通过第三个参数去确定是在冒泡或者捕获阶段执行
- 必须使用removeEventListener(事件类型，事件处理函数，获取捕获或者冒泡阶段）
- 匿名函数无法被解绑
## 事件委托
- 事件委托是利用事件流的特征解决一些开发需求的知识技巧
- 优点：
    减少注册次数，可以提高程序性能
- 原理：
    事件委托其实是利用事件冒泡的特点。
    - 给===父元素注册事件===，当我们触发子元素的时候，会冒泡到父元素身上，从而触发父元素的事件
- 实现：
    事件对象.target.tagName 可以获得真正触发事件的元素
### 总结
1. 事件委托的好处是什么？
    减少注册次数，提高了程序性能
2. 事件委托是委托给了谁？父元素还是子元素？
    父元素
3. 如何找到真正触发的元素？
    `事件对象.target.tagName`
## 阻止冒泡
- 我们某些情况下需要阻止默认行为的发生，比如阻止 链接的跳转，表单域跳转
- 语法：
    `e.preventDefault()`
```
<form action="http://www.baidu.com"><input type="submit"value="提交"></form>
<script>
const form = document.querySelector('form')form.addEventListener('click',function (e) {//阻止表单默认提交行为
e.preventDefault()
})
```
### 阻止元素默认行为
- 语法：
    `e.preventDefault()`
### 总结
1. 阻止冒泡如何做？
    `事件对象.stopPropagation()`
2. 阻止元素默认行为如何做？
    `e.preventDefault()`
## 其他事件
### 页面加载事件
- 加载外部资源（如图片、外联CSS和JavaScript等）加载完毕时触发的事件
- 为什么要学？
    有些时候需要等页面资源全部处理完了做一些事情
    老代码喜欢把 script写在head中，这时候直接找dom元素找不到
- 事件名：load
- 监听页面所有资源加载完毕:
    给window添加load事件
```
// 页面加载事件
window.addEventListener('load', function (){
// 执行的操作
})
```
- 注意：不光可以监听整个页面资源加载完毕，也可以针对某个资源绑定load事件
#### 总结
1. 页面加载事件有哪两个？如何添加？
    - load事件
        监听整个页面资源给window加
    - DOMContentLoaded
        给document加
        需等待样式表、图像等完全加载
### 页面滚动事件
- 概念：
    滚动条在滚动的时候持续触发的事件
- 为什么要学？
    很多网页需要检测用户把页面滚动到某个区域后做一些处理，比如固定导航栏，比如返回顶部
    事件名：scroll
- 监听整个页面滚动：
```
// 页面滚动事件
window.addEventListener('scroll',function (){
// 执行的操作
})
```
    给window或 document 添加scroll事件
- 监听某个元素的内部滚动直接给某个元素加即可
#### 页面滚动事件-获取位置
- 属性：
    scrollLeft和scrollTop
        状取被卷去的大小
        获取元素内容往左、往上滚出去看不到的距离
        这两个值是可读写的
- 尽量在scroll事件里面获取被卷去的距离
```
div.addEventListener('scroll',function (){
console.log(this.scrollTop)
})
```
- 开发中，我们经常检测页面滚动的距离，比如页面滚动100像素，就可以显示一个元素，或者固定一个元素
- 页面滚动事件
```
window.addEventListener('scroll', function () {// document.documentELement 是htmL元素获取方式const n = document.documentElenîent.scrollTop console.log(n)
})
```
- 注意事项：
    document.documentElement HTML文档返回对象为HTML元素
```
<html lang="en">
<head>..<./head>
<body>../body>
</html>
```
##### 总结
1. 被卷去的头部或者左侧用那个属性？是否可以读取和修改?
    scrollTop / scrollLeft
    可以读取，也可以修改（赋值）
2. 检测页面滚动的头部距离（被卷去的头部）用那个属性？
    `document.documentElement.scrollTop`
### 页面尺寸事件
- 会在窗口尺寸改变的时候触发事件：
    resize
```
window.addEventListener('resize',function (){
|/ 执行的代码
})
```
- 检测屏幕宽度：
```
window.addEventListener('resize',function (){let w = document.documentElement.clientwidth console.log(w)
})
```
#### 页面尺寸事件-获取元素宽高
- 获取宽高：
    - 获取元素的可见部分宽高（不包含边框，margin，滚动条等）
    - clientwidth和clientHeight
## 元素尺寸与位置
- 使用场景：
    - 前面案例滚动多少距离，都是我们自己算的，最好是页面滚动到某个元素，就可以做某些事。
    - 简单说，就是通过js的方式，得到元素在页面中的位置
    - 这样我们可以做，页面滚动到这个位置，就可以做某些操作，省去计算了
### 元素尺寸于位置-尺寸
- 获取宽高：
    - 获取元素的自身宽高、包含元素自身设置的宽高、padding、border
    - offsetWidth和offsetHeight
    - 获取出来的是数值，方便计算
    - 注意:
        获取的是可视宽高，如果盒子是隐藏的,获取的结果是C
- 获取位置：
    获取元素距离自己定位父级元素的左、上距离
- offsetLeft和offsetTop 注意是只读属性
### 总结
1. offsetwidth和offsetHeight是得到元素什么的宽高？
    内容+padding+ border
2. offsetTop和offsetLeft得到位置以谁为准？
    带有定位的父级
    如果都没有则以文档左上角 为准