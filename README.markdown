### 跟着我，一步一个脚印，学习数据结构与算法 

从底层实现是数组的**Vector、Heap**到底层实现是链表的**Stack、Queue、Deque、BinaryTree、BinarySearchTree**，一步一步用源代码解开数据结构神秘的面纱

#### 目的

- 消除对数据结构和算法的恐惧，其实也就那么回事
- 从一个DSA的小白到在自己脑海中构建**可视化**的数据结构
- 理解数据结构的底层是怎么实现的，能够私人订制自己的数据结构
- 在工作中遇到问题，知道从什么样的数据就够入手去解决问题
- 对OOP(面向对象编程)思想有更加深刻的理解

#### 注意

- 只针对DSA的小白，如果你是大神，请指教
- **可视化**的重要性，要在脑海中建立抽象模型
- 源代码要看完之后自己coding

#### 亮点

- 使用UML(统一建模语言)进行代码的自动生成
- UML类图能够可视化类之间的关系，帮助理解结构之间的关系
- 有详细的源代码和测试代码
- 代码有详细的演变和泛化过程，帮助理解面向对象的抽象化

#### 工具

- Enterprise Architect，工业界使用广泛的UML建模工具
- Java，数据结构用Java语言实现

#### 结构框架

![结构框架](image/dsa_learn_scheme.png "结构框架")

#### Vector

![Vector](image/dynamic_fixed_vector.png "Vector")

**vector**: a random-access collection of elements

操作：

- append(element) : 添加一个新的元素到这个Collection中
- clear() : 清空这个Collection
- contains(element) : Collection中是否含有元素element
- elementAt(index) : 获取相应index的元素
- indexOf(element) : 获取element的index
- insertAt(index, element) : 在指定的index处插入element
- isEmpty() : Collection是否为空
- removeAt(index) : 删除指定index的element
- remove(element) : 删除Collection中指定的element
- replace(index, element) : 替换掉指定index处的元素为element
- size() : Collection共包含多少个元素

**FixedVector**: 是传统意义上的Vector，也就是数组的一个简单包装。当Collection的容量等于Collection的size()的时候，就不能执行append()和insertAt()操作。

**DynamicVector**: 是一个动态的Vector，当Collection的容量等于Collection的size()的时候，要记性插入操作就要动态的扩充Collection的容量。

[Vector.java]()

[FixedVector.java]()

[DynamicVector.java]()
