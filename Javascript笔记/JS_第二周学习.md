# 01_内置对象-Math
- 介绍：
    Math对象是JavaScript提供的一个“数学”对象
- 作用：
    提供了一系列做数学运算的方法
- Math对象包含的方法有：
    random：生成0-1之间的随机数（包含0不包括1）
    ceil：向上取整
    floor：向下取整
    max：找最大数
    min：找最小数
    pow：幂运算
    abs：绝对值
## 生成任意范围随机数
- 介绍：
    Math.random()随机数函数，返回一个0-1之间，并且包括0不包括1的随机小数`[0，1)`
- 如何生成0-10的随机数呢？
    `Math.floor(Math.random()*(10 + 1))`
- 如何生成5-10的随机数？
    `Math.floor(Math.random()*(5+1))+5`
- 如何生成N-M之间的随机数
    `Math.floor(Math.random()*(M-N+1))+N`
## 随机点名
- 源代码：
```
<script>
let arr =['赵云’，‘黄忠’，‘关羽’，‘张飞’，‘马超’，‘刘备’，‘曹操' ]
  // 1.得到一个随机数， 作为数组的索引号，这个随机数0~6 
let random = Math.floor(Math.random()* arr.length)
  //2.页面输出数组里面的元素document.write(arr[random])
  // 3. splice(起始位置(下标)，删除几个元素)
arr.splice(random, 1)
console.log(arr)
</script>
```
## 拓展
### 堆栈空间分配区别:
- 1、栈（操作系统）：由操作系统自动分配释放存放函数的参数值、局部变量的值等。其操作方式类似于数据结构中的栈;===简单数据类型存放到栈里面===
- 2、堆（操作系统）：存储复杂类型（对象），一般由程序员分配释放，若程序员不释放，由垃圾回收机制回收。===引用数据类型存放到堆里面===
# 02_变量声明
- 变量声明有三个
    var let 和const
- 我们应该用那个呢？
    首先var 先排除，老派写法，问题很多，可以淘汰掉…..
- let or const?
    建议： const 优先，尽量使用const，
    - 原因是：
        const 语义化更好很多变量我们声明的时候就知道他不会被更改了
    - 那为什么不用const呢？
        实际开发中也是，比如react框架，基本const
- 如果你还在纠结，那么我建议：
    有了变量先给const，如果发现它后面是要被修改的，再改为let
## 总结
1. 以后声明变量我们优先使用哪个？
    const 有了变量先给const，如果发现它后面是要被修改的，再改为let
2. 为什么const声明的对象可以修改里面的属性？
    因为对象是引用类型，里面存储的是地址，只要地址不变，就不会报错===建议数组和对象使用const来声明===
3. 什么时候使用let声明变量?
    1. 如果基本数据类型的值或者引用类型的地址发生变化的时候，需要用let
    2. 比如 一个变量进行加减运算，比如for循环中的i++
# 03_DOM和BOM
## 作用和分类
- 作用：就是使用JS去操作html和浏览器
- 分类：DOM（文档对象模型）、BOM（浏览器对象模型）
## 什么是DOM
- DOM (Document Object Model——文档对象模型）是用来呈现以及与任意HTML或XML文档交互的API
- 白话文：
    DOM是浏览器提供的一套专门用来 操作网页内容的功能
- DOM作用：
    开发网页内容特效和实现用户交互
## DOM树
- DOM树是什么？
    将HTML文档以树状结构直观的表现出来，我们称之为文档树或DOM树
- 描述网页内容关系的名词
    作用：文档树直观的体现了标签与标签之间的关系
## DOM对象（重要）
- DOM对象：浏览器根据html标签生成的JS对象
    所有的标签属性都可以在这个对象上面找到
    修改这个对象的属性会自动映射到标签身上
- DOM的核心思想
    把网页内容当做对象来处理
- document 对象
    是DOM里提供的一个对象
    所以它提供的属性和方法都是用来访问和操作网页内容的
    - 例：document.write()
    网页所有内容都在document里面
## 总结
1. DOM树是什么?
    将HTML文档以树状结构直观的表现出来，我们称之为文档树或DOM树
    作用：文档树直观的体现了标签与标签之间的关系
2. DOM对象怎么创建的？
    浏览器根据html标签生成的JS对象（DOM对象）
    DOM的核心就是把内容当对象来处理
3. document 是什么?
    是 DOM里提供的一个对象
    网页所有内容都在document里面
# 04_获取DOM对象
- 目标：
    能查找/获取DOM对象
- 提问：我们想要操作某个标签首先做什么？
    肯定首先选中这个标签，跟CSS选择器类似，选中标签才能操作
- ===查找元素DOM元素就是利用JS选择页面中标签元素===
## **根据CSS选择器来获取DOM元素**（重点）
- 选择匹配的多个元素
- 语法：
    `document.querySelectorAll('css选择器')`
- 参数：
    包含一个或多个有效的CSS选择器 字符串
- 返回值：
    CSS选择器匹配的NodeList对象集合
- 例如：
    document.querySelectorAll('ul li')
- 得到的是一个伪数组：
    有长度有索引号的数组
    但是没有 pop()push(）等数组方法
- 想要得到里面的每一个对象，则需要遍历（for）的方式获得。
- 注意事项
   哪怕只有一个元素，通过querySelectAll()获取过来的也是一个伪数组，里面只有一个元素而已
## 其他获取DOM元素方法（了解）
- 根据id获取一个元素
    `document.getElementById('nav')`
- 根据 标签获取一类元条获取页面 所有div
    `document.getElementsByTagName('div')`
- 根据 类名获取元素 获取页面 所有类名为w的
    `document.getElementsByClassName('w')`
## 总结
1. 获取页面中的标签我们最终常用那两种方式？
    querySelectorAll()
    querySelector()
2. 他们两者的区别是什么?
    querySelector(）只能选择一个元素，可以直接操作
    querySelectorAll(）可以选择多个元素，得到的是伪数组，需要遍历得到每一个元素
3. 他们两者小括号里面的参数有神马注意事项？
    里面写CSS选择器
    必须是字符串，也就是必须加引号
4. 获取一个DOM元素我们使用谁？能直接操作修改吗？
    querySelector()
    可以
5. 获取多个DOM元素我们使用谁？能直接修改吗？如果不能可以怎么做到修改
    querySelectorAll()
    不可以，只能通过遍历的方式一次给里面的元素做修改
# 05_操作元素内容
- DOM对象都是根据标签生成的，所以操作标签，本质上就是操作DOM对象。
- 就是操作对象使用的点语法。
- 如果想要修改标签元素的里面的内容，则可以使用如下几种方式：
    对象.innerText属性
    对象.innerHTML属性
## 元素innerText属性
- 将文本内容添加/更新到任意标签位置
- 显示纯文本，不解析标签
- 示例：
```
// 1.获取元素
const box = document.querySelector('.box')
//2.修改文字内容 对象.innerText 属性console.log(box.innerText） // 获取文字内容
// box.innerText =‘我是一个盒子’//修改文字内容
box.innerText ='<strong>我是一个盒子</strong>'//修改文字内容
```
## 元素.innerHTML属性
- 将文本内容添加/更新到任意标签位置会解析标签，多标签建议使用模板字符
- 示例：
```
const info = document.querySelector('.info')
// 获取标签内部的文字
// console.Log(info.innerHTML)
// 添加/修改标签内部文字内容
info.innerHTML =`嗨喽，俺是<strong>刘德华</strong>~
```
## 总结
1. 设置/修改DOM元素内容有哪2钟方式？
    元素.innerText属性
    元素.innerHTML属性
2. 三者的区别是什么?
    - 元素.innerText属性 
        只识别文本，不能解析标签
    - 元素.innerHTML属性
        能识别文本，能够解析标签
- 如果还在纠结到底用谁，你可以选择innerHTML
# 06_操作元素属性
## 操作元素常用属性
- 还可以通过JS设置/修改标签元素属性，比如通过src更换图片
- 最常见的属性比如：href、title、src等
- 语法：
    `对象.属性=值`
- 举例说明：
```
// 1.获取元素
const pic = document.querySelector('img')
// 2、操作元素
pic.src = './images/b02.jpg'
pic.title ='刘德华墨马演唱会'
```
## 操作元素样式属性
### 通过 style 属性操作CSS
- 语法：
    `对象.style.样式属性=值`
- 举例说明：
```
const box = document.querySelector('.box')
|| 修改元素样式
box.style.width = '200px'box.style.marginTop. = '15px'box.style.backgroundColor = 'pink'
```
- 注意：
    修改样式通过style属性引出
    如果属性有-连接符，需要转换为小驼峰命名法
    赋值的时候，需要的时候不要忘记加CSS单位
#### 总结
1. 设置/修改元素样式属性通过style_属性引出来？
2. 如果需要修改一个div盒子的样式，比如padding-left，如何写？
     element.style.paddingLeft ='300px'
     小驼峰命名法
3. 因为我们是样式属性，一定别忘记，大部分数字后面都需要加单位
```
const box = document.querySelector('.box')
// 修改元素样式
box.style.width ='200px'box.style.marginTop = '15px'box.style.backgroundCôlor = 'pink'
```
### 操作类名（className)操作CSS
- 如果修改的样式比较多，直接通过style属性修改比较繁琐，我们可以通过借助于css类名的形式。
- 语法：
```
// active 是一个css类名
元素.className ='active
```
- 注意：
    由于class是关键字，所以使用className去代替
    className是使用新值换旧值，如果需要添加一个类,需要保留之前的类名
#### 总结
1. 使用className有什么好处？
    可以同时修改多个样式
2. 使用className有什么注意事项？
    直接使用className 赋值会覆盖以前的类名
### 通过 classList 操作类控制CSS
- 为了解决className 容易覆盖以前的类名，我们可以通过classList方式追加和删除类名
- 语法：
```
// 追加一个类
元素.classList.add('类名'）
// 删除一个类
元素.classList.remove('类名’）
// 切换一个类
元素.classList.toggle('类名‘)
```
#### 总结
1. 使用className和classList的区别？
    修改大量样式的更方便
    修改不多样式的时候方便
    classList 是追加和删除不影响以前类名
# 07_操作表单元素属性
- 表单很多情况，也需要修改属性，比如点击眼睛，可以看到密码，本质是把表单类型转换为文本框
- 正常的有属性有取值的跟其他的标签属性没有任何区别
- 获取：
    `DOM对象.属性名`
- 设置：
    `DOM对象.属性名=新值`
- 示例：
```
表单.value=‘用户名
表单。type ='password'
```
- 表单属性中添加就有效果，移除就没有效果，一律使用布尔值表示 如果为true代表添加了该属性 如果是false代表移除了该属性
    比如：disabled、checked、selected
# 08_自定义属性
- 标准属性：
    标签天生自带的属性 比如class id title等，可以直接使用点语法操作比如： disabled、checked、selected
- 自定义属性：
    在html5中推出来了专门的data-自定义属性在标签上一律以data-开头
    在DOM对象上一律以dataset对象方式获取
```

<body>
<div class="box" data-id="10">盒子</div>
<script>
const box = document.querySelector('.box')
console.log(box.dataset.id)
</script>
</body>
```
# 09_定时器-间歇函数
## 开启定时器
- 语法：
    `setInterval(函数，间隔时间）`
- 作用：每隔一段时间调用这个函数
    间隔时间单位是毫秒
- 举例说明:
```
function repeat() {
console.log('前端程序员，就是头发多咋滴~~‘）
}
// 每隔一秒调用repeat函数
setInterval(repeat,1000)
```
- 注意：
    函数名字不需要加括号
    定时器返回的是一个id数字
## 关闭定时器
- 语法：
    `let 变量名=setInterval(函数，间隔时间)clearInterval(变量名)`
- 一般不会刚创建就停止，而是满足一定条件再停止
```
let timer = setInterval(function() {
console.log('hi~~')
},1000)
clearInterval(timer)
```
- 注意：
1. 函数名字不需要加括号
2. 定时器返回的是一个id数字