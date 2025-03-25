# 059_字体
## 字体风格
- 属性名：font-style  
- 常用值：
  1. normal:正常(默认值)
  2. italic:斜体( 推荐 使用字体自带的斜体效果)
  3. oblique:斜体(强制倾斜产生的斜体效果)
- 语法：
```
div {
     font-style:italic;
}
```
## 字体粗细
- 属性名：font-weight
- 常用值：
  - 关键词
  1. lighter: 细
  2. normal: 正常
  3. bold: 粗
  4. bolder: 很粗 （多数字体不支持） 
  - 数值
1. 100~1000旦无单位，数值越大，字体越粗（或一样粗，具体得看字体设计时的精确程度）。
2. 100~300等同于lighter，400~500等同于normal，600及以上等同于bold。
- 语法：
```
div{
    font-weight: bold;
 }
div{
    font-weight:600;
 }
```
## 字体的复合写法
- 属性名：font，可以把上述字体合并成一个属性
- 编写规则：
    1. 字体大小、字体族必须都写上。
    2. 字体族必须是最后一位、字体大小必须是倒数第二位。
    3. 各个属性间用空格隔开。
- 实际开发中更推荐复合写法，但这也不是绝对的，比如只想设置字体大小，那就直接用font-size属性。
# 060_文本
## 文本颜色
- 属性名：color
- 可选值：
    1. 颜色名
    2. rgb&rgba(常用)
    3. HEX&HEXA(十六进制)(常用)
    4. HSL&HSLA
- 举例：
```
div {
    color:rgb(112,45,78);
}
```
## 文本间距
- 字母间距：letter-spacing
- 单词间距：word-spacing(通过空格识别词)
- 属性值为像素(px)，正值让间距增大，负值让间距缩小
## 文本修饰
- 属性名：text-decoration
- 可选值：
    1. none:无装饰线(常用)
    2. underline:下划线(常用)
    3. overline:上划线
    4. line-through:删除线
    可搭配如下值使用：
    1. dotted:虚线
    2. wavy:波浪线
    3. 也可以指定颜色
- 举例：
```
a {
    text-decoration:none;
}
```
## 文本缩进
- 属性名：text-indent
- 属性值：css中的长度单位 例如:px
- 举例：
```
div {
    text-indent:40px;
}
```
## 文本对齐_水平
- 属性名：text-align
- 常用值：
    1. left：左对齐(默认值)
    2. right：右对齐
    3. center：居中对齐
- 举例：
```
div {
    text-align:center;
}
```
## 行高
- 属性值：line-height
- 可选值：
    1. normal：由浏览器根据文字大小决定的一个默认值
    2. 像素（px）
    3. 数字：参考自身font-size的倍数（很常用）
    4. 百分比：参考自身font-size的百分比
- 备注：由于字体设计问题，文字在一行中，并不是绝对垂直居中，若一行中都是文字，不会太影响观感
- 举例：
```
div {
    line-height:60px;
    line-height: 1.5;
    line-height:150%;
}
```
- 行高注意事项：
    1. line-height过小会怎样？—-文字产生重叠，且最小值是0，不能为负数。
    2. line-height是可以继承的，且为了能更好的呈现文字，最好写数值。
    3. line-height和height是什么关系?
        - 设置了height，那么高度就是height的值。
        - 不设置height的时候，会根据line-height计算高度。
- 应用场景：
    1. 对于多行文字：控制行与行之间的距离。
    2. 对于单行文字：让height等于line-height，可以实现文字垂直居中。
    - 备注：
     由于字体设计原因，靠上述办法实现的居中，并不是绝对的垂直居中，但如果一行中都是文字，不会太影响观感。
## 文本对齐_垂直
1. 顶部：无需任何属性，在垂直方向上，默认就是顶部对齐。
2. 居中：对于单行文字，让height=line-height即可。
- 问题：多行文字垂直居中怎么办？—- 后面我们用定位去做。
3. 底部：对于单行文字，目前一个临时的方式:让line-height =(height x2)-font-size-x。
- 备注：×是根据字体族，动态决定的一个值。
- 问题：垂直方向上的底部对齐，更好的解决办法是什么？—-后面我们用定位去做。
## vertical-align
- 属性名：vertical-align
- 作用：用于指定同一行元素之间，或表格单元格内文字垂直对齐方式
- 常用值：
    1. baseline（默认值）：使元素的基线与父元素的基线对齐。
    2. top：使元素的顶部与其所在行的顶部对齐。
    3. middle：使元素的中部与父元素的基线加上父元素字母×的一半对齐。
    4. bottom：使元素的底部与其所在行的底部对齐。
- 特别注意：vertical-align不能控制块元素。
# 061_细说font-size
1. 由于字体设计原因，文字最终呈现的大小，并不一定与font-size的值一致，可能大，也可能小。
- 例如：font-size设为40px，最终呈现的文字，可能比40px大，也可能比40px小。
2. 通常情况下，文字相对字体设计框，并不是垂直居中的，通常都靠下一些。
# 062_CSS列表属性
列表相关属性，可以作用在ul,ol,li元素上
## list-style-type
- 功能：设置列表符号
- 常用值：
    1. none：不显示前面的标识（很常用！）
    2. square：实心方块
    3. disc：圆形
    4. decimal：数字
    5. lower-roman：小写罗马字
    6. upper-roman：大写罗马字
    7. lower-alpha：小写字母
    8. upper-alpha：大写字母
## list-style-position
- 功能：设置列表符号的位置
- 常用值：
    1. inside:在li的里面
    2. outside:在li的外面
## list-sryle-image
- 功能：自定义列表符号
- 属性值：
    1. url(图片地址)
## list-style
- 功能：符合属性
- 属性值：
    1. 没有数量、顺序的要求
# 063_CSS表格属性
## 1.边框相关属性（其他元素也能用）：
### border-width
- 功能：边框宽度
- 属性值：CSS中可用的长度值
### border-color
- 功能：边框颜色
- 属性值：CSS中可用的颜色值
### border-style
- 功能：边框风格
- 属性值：
    1. none 默认值
    2. solid 实线
    3. dashed 虚线
    4. dotted 点线
    5. double 双实线
### border
- 功能：边框复合属性
- 属性值：没有数量、顺序要求
### 注意：
1. 以上4个边框相关的属性，其他元素也可以用，这是我们第一次遇见它们。
2. 在后面的盒子模型中，我们会详细讲解边框相关的知识。
## 2.表格独有属性（只有table标签才能使用）：
### table-layout
- 功能：设置列宽度
- 属性值：
    1. auto：自动，列表根据内容计算（默认值）
    2. fixed：固定列宽，平均分
### border-spacing
- 功能：单元格间距
- 属性值：
    1. CSS中可用的长度值
    2. 生效的前提：单元格边框不能合并
### border-collapse
- 功能：合并单元格边框
- 属性值：
    1. collapse：合并
    2. separate：不合并
### empty-cells
- 功能：影藏没有内容的单元格
- 属性值：
    1. show：显示（默认值）
    2. hide：影藏
    3. 生效前提：单元格不能合并
### caption-side
- 功能：设置表格标题位置
- 属性值：
    1. top：上面（默认值）
    2. bottom：在表格下面
### 注意：
以上五个属性，只有表格才能使用，即：`<table>`标签
# 064_CSS背景属性
## background-color
- 功能：设置背景颜色
- 属性值：
    1. 符合CSS中颜色规范的值。
    2. 默认背景颜色是transparent。
## background-image
- 功能：设置背景图片
- 属性值：
    1. url(图片的地址)
## background-repeat
- 功能：设置背景重复方式
- 属性值：
    1. repeat：重复，铺满整个元素，默认值。
    2. repeat-x：只在水平方向重复。
    3. repeat-y：只在垂直方向重复。
    4. no-repeat：不重复。
## background-position
- 功能：设置背景图位置
- 属性值：
    1. 通过关键字设置位置:  
     写两个值，用空格隔开  
     水平：left、center、right  
     垂直：top、center、bottom
     如果只写一个值，另一个方向的值取center
    2. 通过长度指定坐标位置：  
     以元素左上角，为坐标原点，设置图片左上角的位置。
     两个值，分别是×坐标和y坐标。
     只写一个值，会被当做×坐标，y坐标取center
## background
- 功能：复合属性
- 属性值：
    1. 没有数量和顺序要求
# 065_CSS鼠标属性
## cursor
- 功能：设置鼠标光标的样式
- 属性值：
    1. pointer:小手
    2. move：移动图标
    3. text：文字选择器
    4. crosshair：十字架
    5. wait：等待
    6. help：帮助
## 扩展：自定义鼠标图标
```
/*自定义鼠标光标 */
cursor: url("./arrow.png"),pointer;
```
# 066_CSS盒子模型
## 1.CSS长度单位
1. px：像素
2. em：相对font-size的倍数
3. rem：相对根字体大小，html标签就是根
4. %：相对父元素计算
- 注意：CSS中设置长度，必须加单位，否则样式无效！
## 2.元素的显示模式
### 块元素(block)
- 又称：块级元素
- 特点：
    1. 1.在页面中独占一行，不会与任何元素共用一行，是从上到下排列的。
    2. 默认宽度：撑满父元素。
    3. 默认高度：由内容撑开。
    4. 可以通过CSS设置宽高。
### 行内元素(inline)
- 又称：内联元素
- 特点：
    1. 在页面中不独占一行，一行中不能容纳下的行内元素，会在下一行继续从左到右排列。
    2. 默认宽度：由内容撑开。
    3. 默认高度：由内容撑开。
    4. 无法通过CSS设置宽高。
### 行内块元素(inline-block)
- 又称：内联块元素
- 特点：
    1. 1.在页面中不独占一行，一行中不能容纳下的行内元素，会在下一行继续从左到右排列。
    2. 默认宽度：由内容撑开。
    3. 默认高度：由内容撑开。
    4. 可以通过CSS设置宽高。
注意：元素早期只分为：行内元素、块级元素，区分条件也只有一条：“是否独占一行”，如果按照这种分类方式，行内块元素应该算作行内元素。
## 3.总结各元素的显示模式
### 块元素(block)
1. 主题结构标签：`<html>,<body>`
2. 排版标签：`<h1>-<h6>,<hr>,<p>,<pre>,<div>`
3. 列表标签：`<ul>,<ol>,<li>,<dl>,<dt>,<dd>`
4. 表格相关标签：`<table>,<tbody>,<thead>,<tr>,<caption>`
5. `<form>`与`<option>`
### 行内元素(inline)
1. 文本标签：`<br>,<em>,<strong>,<sub>,<del>,<ins>`
2. `<a>`与`<label>`
### 行内块元素(inline-block)
1. 图片：`<img>`
2. 单元格：`<td>,<th>`
3. 表单控件：`<input>，<textarea>，<select>，<button>`
4. 框架标签：`<iframe>`
## 4.修改元素显示模式
### 通过CSS中的display属性可以修改元素的默认显示效果，常用值如下：
#### none
- 描述：元素会被隐藏
#### block
- 描述：元素会被作为块级元素展示
#### inline
- 描述：元素会被作为行内(内联)元素展示
#### inline-block
- 描述：元素会被作为行内块元素展示
## 5.盒子模型的组成
- CSS会把所有的HTML元素都看做一个盒子，所有的样式也都基于这个盒子
1. margin（外边距）：盒子与外界的蹈离。
2. border（边框）：盒子的边框。
3. padding（内边距）：紧贴内容的补白区域。
4. content（内容）：元素中的文本或后代元素都是它的内容
- 盒子的大小=content+左右padding+左右border
- 注意：外边距margin不会影响盒子的大小，但会影响盒子的位置
## 6.盒子的内容区(content)
### width
- 功能：设置内容区域宽度
### max-width
- 功能：设置内容区域的最大宽度
### min-width
- 功能：设置内容区域的最小宽度
### height
- 功能：设置内容区域的高度
### max-height
- 功能：设置内容区域的最大高度
### min-height
- 功能：设置内容区域的最小高度
### 注意：
- max-width、min-width 一般不与width一起使用。
- max-height、min-height 一般不与height—起使用。
## 7.关于默认宽度
- 所谓的默认宽度，就是不设置width属性时，元素所呈现出来的宽度。
- 总宽度=父的content -自身的左右margin。
- 内容区的宽度=父的content -自身的左右margin -自身的左右border -自身的左右padding。
## 8.盒子内边距(padding)
### padding-top
- 功能：上内边距
- 属性值：长度
### padding-right
- 功能：右内边距
- 属性值：长度
### padding-bottom
- 功能：下内边距
- 属性值：长度
### padding-left
- 功能：左内边距
- 属性值：长度
### padding
- 功能：复合属性
- 属性值：长度
### padding复合属性的使用规则：
1. padding:18px；四个方向内边距都是10p×。
2. padding: 10px 20px;上10p×，左右20px。（上下、左右）
3. padding:10px20px30px；上10px，左右20px，下30px。（上、左右、下）
4. padding:10px20px30px40px；上18px，右28px，下38px，左48px。（上、右、下、左）
### 注意点：
1. padding的值不能为负数。
2. 行内元素的左右内边距是没问题的，上下内边距不能完美的设置。
3. 块级元素、行内块元素，四个方向内边距都可以完美设置。
## 9.盒子的边框(border)
### border-style
- 功能：边框线风格 复合了四个方向的边框风格
- 属性值：
    1. none 默认值
    2. solid 实线
    3. dashed 虚线
    4. dotted 点线
    5. double 双实线
    6. ......
### border-width
- 功能：边框线宽度 复合了四个方向的边框宽度
- 属性值：长度，默认3px
### border-color
- 功能：边框线颜色 复合了四个方向的边框颜色
- 属性值：颜色，默认黑色
### border
- 功能：复合属性
- 属性值：值没有顺序和数量的要求
### 分别设置各个方向的边框<br>属性值同上
- border-left
- border-left-style
- border-left-width
- border-left-color
- border-right 
- border-right-style 
- border-right-width
- border-right-color
- border-bottom
- border-bottom-style
- border-bottom-width
- border-bottom-color
### 注意：
- 边框相关属性共20个。
- border-style、border-width、border-color其实也是复合属性。
## 10.盒子外边距(margin)
#### margin-left
- 功能：左外边距
- 属性值：CSS中的长度值
#### margin-right
- 功能：右外边距
- 属性值：CSS中的长度值
#### margin-top
- 功能：上外边距
- 属性值：CSS中的长度值
#### margin-bottom
- 功能：下外边距
- 属性值：CSS中的长度值
#### margin
- 功能：复合属性，可以写1~4个值，规律同padding（顺时针）（上右下左）
- 属性值：CSS中的长度值
### 10.1 margin注意事项
1. 子元素的margin，是参考父元素的content计算的。（因为是父亲的content中承装着子元素)
2. 上margin、左margin：影响自己的位置；下margin、右margin：影响后面兄弟元素的位置。
3. 块级元素、行内块元素，均可以完美地设置四个方向的margin；但行内元素，左右margin可以完美设置，上下margin设置无效。
4. margin的值也可以是auto，如果给一个块级元素设置左右margin都为auto，该块级元素会在父元素中水平居中。
5. margin的值可以是负值。
### 10.2 margin塌陷问题
- 什么是margin 塌陷?
    - 第一个子元素的上margin会作用在父元素上，最后一个子元素的下margin会作用在父元素上。
- 如何解决margin塌陷?
    - 方案一：给父元素设置不为0的padding。
    - 方案二：给父元素设置宽度不为0的border。
    - 方案三：给父元素设置css样式overflow:hidden
### 10.3 margin合并问题
- 什么是margin合并?
    - 上面兄弟元素的下外边距和下面兄弟元素的上外边距会合并，取一个最大的值，而不是相加。
- 如何解决margin 塌陷?
    - 无需解决，布局的时候上下的兄弟元素，只给一个设置上下外边距就可以了。
## 11.处理内容溢出
### overflow
- 功能：溢出内容的处理方式
- 属性值：
    1. visible：显示，默认值
    2. hidden：隐藏
    3. scroll：显示滚动条，不论内容是否溢出
    4. auto：自动显示滚动条，内容不溢出不显示
### overflow-x
- 功能：水平方向溢出内容的处理方式
- 属性值：同overflow
### overflow-y
- 功能：垂直方向溢出内容的处理方式
- 属性值：同overflow
### 注意：
1. overflow-x、overflow-y不能一个是hidden，一个是visible，是实验性属性，不建议使用。
2. overflow 常用的值是hidden和auto，除了能处理溢出的显示方式，还可以解决很多疑难杂症。
## 12.隐藏元素的方式
### 方式一：visibility属性：
visibility 属性默认值是show，如果设置为hidden，元素会隐藏。
元素看不见了，还占有原来的位置（元素的大小依然保持）。
### 方式二：display属性：
设置display：none，就可以让元素隐藏。
彻底地隐藏，不但看不见，也不占用任何位置，没有大小宽高。
## 13.样式的继承
- 有些样式会继承，元素如果本身设置了某个样式，就使用本身设置的样式；但如果本身没有设置某个样式，会从父元素开始一级一级继承（优先继承离得近的祖先元素）。
### 会继承的css属性
- 字体属性、文本属性（除了vertical-align）、文字颜色等。
### 不会继承的css属性
- 边框、背景、内边距、外边距、宽高、溢出方式等。
### 一个规律：
- 能继承的属性，都是不影响布局的，简单说：都是和盒子模型没关系的。
## 14.默认样式
- 元素一般都些默认的样式，例如:
    1. `<a>`元素：下划线、字体颜色、鼠标小手。
    2. `<h1>~<h6>`元素：文字加粗、文字大小、上下外边距。
    3. `<p>`元素：上下外边距
    4. `<ul>`、`<ol>`元素：左内边距
    5. body元素：8px外边距（4个方向）
- 优先级：元素的默认样式>继承的样式，所以如果要重置元素的默认样式，选择器一定要直接选择器到该元素。
## 15.布局小技巧
 1. 行内元素、行内块元素，可以被父元素当做文本处理。
    - 即：可以像处理文本对齐一样，去处理：行内、行内块在父元素中的对齐。
    - 例如：text-align、line-height、text-indent等。
2. 如何让子元素，在父亲中 水平居中:
    - 若子元素为块元素，给父元素加上：margin:0 auto;
    - 若子元素为行内元素、行内块元素，给父元素加上：text-align:center
3. 如何让子元素，在父亲中 垂直居中:
    - 若子元素为块元素，给子元素加上：margin-top，值为：（父元素content-子元素盒子总高）/2
    - 若子元素为行内元素、行内块元素：
        - 让父元素的height = line-height，每个子元素都加上：vertical-align:middle;
        - 补充：若想绝对垂直居中，父元素font-size设置为0。
## 16.元素之间的空白问题
- 产生的原因：
    - 行内元素、行内块元素，彼此之间的换行会被浏览器解析为一个空白字符。
- 解决方案:
    1. 方案一：去掉换行和空格（不推荐）。
    2. 方案二：给父元素设置font-size：0，再给需要显示文字的元素，单独设置字体大小（推荐)
## 17.行内块的幽灵空白问题
- 产生原因：
    - 行内块元素与文本的基线对齐，而文本的基线与文本最底端之间是有一定距离的。
- 解决方案：
    1. 方案一：给行行内块设置vertical，值不为 baseline 即可，设置为middel、bottom、top均可。
    2. 方案二：若父元素中只有一张图片，设置图片为display：block。
    3. 方案三：给父元素设置font-size：0。如果该行内块内部还有文本，则需单独设置font-size。
# 067_浮点
## 1.浮动的简介
- 在最初，浮动是用来实现文字环绕图片效果的，现在浮动是主流的页面布局方式之一。
## 2.元素浮动后的特点
1. 脱离文档流
2. 不管浮动前是什么元素，浮动后：默认宽与高都是被内容撑开（尽可能小），而且可以设置宽高。
3. 不会独占一行，可以与其他元素共用一行。
4. 不会margin合并，也不会margin塌陷，能够完美的设置四个方向的margin和padding。
5. 不会像行内块一样被当做文本处理（没有行内块的空白问题）。