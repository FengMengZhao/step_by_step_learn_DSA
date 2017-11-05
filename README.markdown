# 一步一个脚印学习类设计和抽象

---

## 目录

- 一. [简介](#1)
    - [目的](#1.1)
    - [读者群](#1.2)
    - [术语和缩写](#1.3)
    - [工具](#1.4)
    - [概览](#1.5)
- 二. [Vector](#2)
    - [目前的Model](#2.1)
    - [Vector抽象数据类型(ADT)](#2.2)
    - [Vector UML类图](#2.3)
    - [Vector数据结构(Data Structure)](#2.4)
- 三. [DynamicVector及Vector Generalization](#3)
    - [目前的Model](#3.1)
    - [DynamicVector UML类图](#3.2)
    - [FixedVector & DynamicVector Gneralization](#3.3)
    - [Vector一般化抽象实现](#3.4)
- 四. [Heap及ArrayBased Container一般化抽象](#4)
    - [目前的Model](#4.1)
    - [Heap抽象数据类型(ADT)](#4.2)
    - [Heap UML类图](#4.3)
    - [Heap一般化抽象实现](#4.4)
    - [Array-Based Container UML类图](#4.5)
    - [Array-Based Container实现](#4.6)
- 五. [Stack(sequential-based, single lined-list)及ArrayContainer & Stack一般化抽象](#5)
    - [目前的Model](#5.1)
    - [Stack抽象数据类型(ADT)](#5.2)
    - [Stack UML图](#5.3)
    - [Stack实现](#5.4)
    - [ArrayContainer & Stack一般化抽象UML图](#5.5)
    - [ArrayContainer & Stack一般化抽象实现](#5.6)
- 六. [Queue(sequential-based, double linked-list)及ArrayContainer & Stack & Queue一般化抽象](#6)
    - [目前的Model](#6.1)
    - [Queue抽象数据类型(ADT)](#6.2)
    - [Queue UML图](#6.3)
    - [Queue 实现](#6.4)
    - [ArrayContainer & Stack & Queue一般化抽象UML图](#6.5)
    - [ArrayContainer & Stack & Queuek一般化抽象实现](#6.6)
- 七. [Deque](#7)
    - [目前的Model](#7.1)
- 八. [Linked-Based Container Generalization](#8)
- 十. [Array-Based Container & Linked-Based Container Generalization](#10)
- 十一. [BinaryTree](#11)
- 十二. [BinarySearchTree及BinaryTree Generalization](#12)
- 十三. [最终Generalization](#13)

---

<h3 id="1">一. 简介</h3>

面向对象语言的三要素:封装,继承和多态.也可以理解为:抽象,封装和复用.

- 抽象(Abstraction): 是一个一般化(generalization)的过程.代表了事物的必要信息,而没有具体的实现细节.抽象是一种实现的隐藏(Implementation hiding).
- 封装(Encapsulation): 将事物的状态和对状态的操作整合为一个对象,并且严格限制外部对对象某些特征的访问.也就是说,将事物的内在表示从外部世界对它的定义中隐藏起来.封装是一种信息的隐藏(Informatica hiding).

> 抽象和封装是多多态的基石,多态是复用的一种.

<h3 id="1.1">目的</h3>

如何能够通过抽象,封装和复用设计出可插入,可扩展,灵活性好的软件系统是程序设计人员的不断追求.本项目从底层实现是数组的`Vector`,`Heap`到底层实现是链表的`Stack`,`Queue`,`Deque`,`BinaryTree`,`BinarySearchTree`,一步一步通过UML图和源代码实现的方式揭开类设计的神秘面纱:

- 如何将数据和方法进行封装,将类的内部信息和外部接口分离,保证程序扩展和修改的灵活性
- 如何抽象一个类,从而扩展出与之相似的类,实现抽象和多态(polymorphism)
- 如何抽象类的等级结构(hierarchy),保证整体结构的可插入行和可扩展性
- 在类的等级结构进化过程中,数据和方法是分别朝着什么方法移动
- 如何将类等级结构通过UML方式表示出来,并通过UML自动生成源代码

<h3 id="1.2">读者群</h3>

如果你初学数据结构和算法,对Java类集框架底层实现和类结构演化感兴趣;如果你想了解简单的类设计,想弄明白平时常用的Java类集抽象层的设计原理;如果你想找一个完整的,一步一个脚印的类演化过程;如果你想学习UML,通过手画UML理解类之间的继承关联和依赖等关系,私下里过一下设计师的瘾;那么,这个入门的项目就是为你设计的,希望能够给你提供价值.

<h3 id="1.3">术语和缩写</h3>

- UML(Unified Model Language, 统一建模语言): 软件软件工程行业一种通用的,开发级建模语言,这种语言致力于提供标准的可视化系统设计.本项目使用UML描述类结构的进化过程.[https://en.wikipedia.org/wiki/Unified_Modeling_Language](https://en.wikipedia.org/wiki/Unified_Modeling_Language, "UML")
- 类图(Class Diagram): UML中的一种静态结构类型.类图可以通过系统的类,属性和方法以及类之间的关系描述整个系统的结构.本项目中用到的类关系主要有继承,关联和依赖三种.[https://en.wikipedia.org/wiki/Class_diagram](https://en.wikipedia.org/wiki/Class_diagram, "Class Diagram")
- 抽象数据类型(ADT, Abstract Data Type): 定义了数据类型的成员(member)和对成员的操作(operation).抽象一词表明此数据类型没有具体的实现细节,是抽象而不是具体的(concrete).[https://en.wikipedia.org/wiki/Abstract_data_type](https://en.wikipedia.org/wiki/Abstract_data_type "Abstract Data Type")
- 数据结构(Data Structure): ADT的一种实现.一个数据结构是具体的,它定义了ADT的成员变量和对成员变量的操作.

<h3 id="1.4">工具</h3>

- Enterprise Architect，工业界使用广泛的UML建模工具
- JDK，数据结构用Java语言实现

<h3 id="1.5">概览</h3>

- 第二部分,介绍`Vector`数据结构
- 第三部分,介绍`DynamicVector`及对`Vector`的一般化抽象
- 第四部分,介绍`Heap`数据结构,包括`MaxHeap`和`MinHeap`
- 第五部分,介绍底层实现是Array的`Vector`和`Heap`的一般化抽象
- 第六部分,介绍`Stack`数据结构
- 第七部分,介绍`Queue`数据结构
- 第八部分,介绍`Deque`数据结构及对`Queue`的一般化抽象
- 第九部分,介绍底层实现是Linked Node的`Stack`,`Queue`及`Deque`的一般化抽象
- 第十部分,介绍底层实现是Array的`ArrayContainer`和底层实现是Linked Node的`LinkedContainer`的一般化抽象
- 第十一部分,介绍`BinaryTree`数据结构
- 第十二部分,介绍`BinarySearchTree`数据结构及底层实现是`TreeNode`的`BinaryTree`的一般化抽象
- 第十三部分,最终的一般化抽象.介绍将底层实现是Array的`ArrayContainer`和底层实现是`LinkedNode`的`LinearLinkedContainer`以及底层实现是`TreeNode`的`TreeContainer`的一般化抽象.

先一睹为快最终的模型(Model):

![最终抽象UML](image/overview.png)

---

<h3 id="2">二. Vector</h3>

<h4 id="2.1">目前的Model</h4>

![目前的Model](image/current-fixed-vector.png "Fixed Vector")

<h4 id="2.2">Vector抽象数据类型(ADT)</h4>

> **vector**: 一个随机访问(random-access)数据集.

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

<h4 id="2.3">Vector UML类图</h4>

![Vector UML类图](image/fixed-vector.png)

<h4 id="2.4">Vector数据结构(Data Structure)</h4>

**源码:** [VectorInit.java](src/VectorInit.java)

---

<h3 id="3">三. DynamicVector及Vector Generalization</h3>

<h4 id="3.1">目前的Model</h4>

![目前的Model](image/current-vector-generalization.png "Vector Generalization")

<h4 id="3.2">DynamicVector UML类图</h4>

`FixedVector`: 是传统意义上的Vector,也就是数组的一个简单包装.当Collection的容量等于Collection的size()的时候，就不能执行append()和insertAt()操作。第二部分中介绍的`Vector`就是`FixedVector`.

`DynamicVector`: 是一个动态的Vector，当Collection的容量等于Collection的size()的时候，要记性插入操作就要动态的扩充Collection的容量。

![DynamicVector类图](image/dynamic-vector.png)

> 简化的UML图,省略了与`FixedVector`相同的部分.

<h4 id="3.3">FixedVector & DynamicVector Gneralization</h4>

`FixedVector`和`DynamicVector`是`Vector`两个不同的变种.它们具有一些必要的本质特征,而在某些操作(支持扩容与否)上略有差异.

**FixedVector和DynamicVector一般化抽象UML类图**

![Vector Generalization UML图](image/vector-generalization.png)

<h4 id="3.4">Vector一般化抽象实现</h4>

**源码:**

- [Vector.java](src/Vector.java)
- [FexedVector.java](src/FixedVector.java)
- [DynamicVector](src/DynamicVector.java)

---

<h3 id="4">四. Heap及ArrayBased Container一般化抽象</h3>

<h4 id="4.1">目前的Model</h4>

![目前的Model](image/current-arraybased-generalization.png)

<h4 id="4.2">Heap抽象数据类型(ADT)</h4>

`Heap` : Heap是一个部分有序完全二叉树(partially ordered complete binary tree);部分有序指: 堆的父元素总是比子元素小(大)，父元素比子元素大称之为MaxHeap，父元素比子元素小称之为MinHeap。

Heap二叉树相关:

- 二叉树元素n的深度：从root开始到元素n必须经由的边的个数
- 二叉树的高度：最深的一个元素的深度加1
- 同样深度的元素为同一个level
- 完全二叉树：二叉树的填充顺序是从root开始，从左到右依次填充每一个level

操作：

- clear() : 清空Collection
- insert(element): 插入一个新的元素到Collection
- isEmpty() : Colloection是否为空
- peek() : 得到root元素
- remove() : 删除root元素
- size() : Collection中有多少个元素

<h4 id="4.3">Heap UML类图</h4>

![Heap UML类图](image/heap-generalization.png)

<h4 id="4.4">Heap一般化抽象实现</h4>

**源码:**

- [Heap.java](src/Heap.java)
- [MinHeap.java](src/MinHeap.java)
- [MaxHeap.java](src/MaxHeap.java)

第二部分中介绍的`Vector`和第三部分介绍的`Heap`底层实现都是Array.同样,我们将之进行一般化抽象.

<h4 id="4.5">Array-Based Container UML类图</h4>

![Vector & Heap Generalization](image/vector-heap-generalization.png "ArrayBased Container")

<h4 id="4.6">Array-Based Container实现</h4>

**源码:**

- [Container.java](src/arraybased/Container.java)
- [Vector.java](src/arraybased/Vector.java)
- [Heap.java](src/arraybased/Heap.java)
- [FixedVector.java](src/arraybased/FixedVector.java)
- [DynamicVector.java](src/arraybased/DynamicVector.java)
- [MaxHeap.java](src/arraybased/MaxHeap.java)
- [MinHeap.java](src/arraybased/MinHeap.java)

---

<h3 id="5">五. Stack(sequential-based, single lined-list)及ArrayContainer & Stack一般化抽象</h3>

我们在第二三四部分介绍了Array-Based的数据结构及它们的一般化抽象;在接下来的第六七八部分将介绍LinkedNode-Based的数据结构及它们的一般化抽象过程.首先要介绍的是以链表为底层实现的栈(Stack).

<h4 id="5.1">目前的Model</h4>

![目前的Model](image/current-stack.png)

<h4 id="5.2">Stack抽象数据类型(ADT)</h4>

> 我们可以很容易的使用array container来实现Stack，但是我们通常使用链表来实现Stack。

**使用链表实现Stack的原因**

- Stack不是random-access的
- 使用数组实现的栈并不能使用上random-access的功能
- 使用数组实现的栈浪费空间，因为Collection的容量总是大于Collection的size()

**链表(linked list)**

链表是一组nodes的线性组合，组合中的每一个node至少提供a data和a link portion；一个node的link portion是一个指针或者引用执行组合中的下一个node。

**Stack**: 一组线性元素组成的Collection，只能够从Collection的一端获取元素。我们所感兴趣的当前元素称之为top元素

操作：

- clear() : 清空Collection
- isEmpty() : 判断Collection是否为空
- pop() : 删除top元素
- push(element) : 把指定的element推入栈，最为topelement
- size() : Collection共有多少个元素
- top() : 得到top元素

<h4 id="5.3">Stack UML类图</h4>

![Stack UML类图](image/stack.png)

<h4 id="5.4">Stack实现</h4>

**源码:**

- [Stack.java](src/Stack.java)
- [LinearNode.java](src/LinearNode.java)

<h4 id="5.5">ArrayContainer & Stack一般化抽象UML图</h4>

![ArrayBased Stack UML类图](image/arraybased-stack.png)

<h4 id="5.6">ArrayContainer & Stack一般化抽象实现</h4>

**源码:**

- [Container.java](src/arraybased-stack/Container.java)
- [Vector.java](src/arraybased-stack/Vector.java)
- [Heap.java](src/arraybased-stack/Heap.java)
- [FixedVector.java](src/arraybased-stack/FixedVector.java)
- [DynamicVector.java](src/arraybased-stack/DynamicVector.java)
- [MaxHeap.java](src/arraybased-stack/MaxHeap.java)
- [MinHeap.java](src/arraybased-stack/MinHeap.java)
- [LinearNode.java](src/arraybased-stack/LinearNode.java)
- [Stack.java](src/arraybased-stack/Stack.java)

---

<h3 id="6">六. Queue(sequential-based, double linked-list)</h3>

<h4 id="6.1">目前的Model</h4>

![目前的Model](image/current-queue.png)

<h4 id="6.2">Queue抽象数据类型(ADT)</h4>

`Queue`: 一组线性元素组成的Collection，只能从Collection的末尾获取元素；我们感兴趣的元素称之为front element；最后一个元素称之为back element

操作：

- clear() : 清空Collection中的元素
- front() : 得到Collection的front element
- insertBack() : 向Collection的队尾添加元素，称为back element
- isEmpty() : 判断Collection是否为空
- removeFront() : 删除front element
- size() : Collection中共有多少个元素

> 我们用单链表实现了Stack数据结构，由于队列有对头和对尾，我们要使用双链表实现Queue数据结构

<h4 id="6.3">Queue UML图</h4>

![Queue](image/queue.png)

<h4 id="6.4">Queue实现</h4>

**源码:**

- [Queue.java](src/Queue.java)
- [SLNode.java](src/SLNode.java)
- [DLNode.java](src/DLNode.java)

<h4 id="6.5">ArrayContainer & Stack & Queue一般化抽象UML图</h4>

![ArrayBased Contaner & Stack & Queue一般化抽象UML类图](image/arraybased-stack-queue.png)

<h4 id="6.6">ArrayContainer & Stack & Queue实现</h4>

**源码:**

- [Container.java](src/arraybased-stack-queue/Container.java)
- [Vector.java](src/arraybased-stack-queue/Vector.java)
- [Heap.java](src/arraybased-stack-queue/Heap.java)
- [FixedVector.java](src/arraybased-stack-queue/FixedVector.java)
- [DynamicVector.java](src/arraybased-stack-queue/DynamicVector.java)
- [MaxHeap.java](src/arraybased-stack-queue/MaxHeap.java)
- [MinHeap.java](src/arraybased-stack-queue/MinHeap.java)
- [Stack.java](src/arraybased-stack-queue/Stack.java)
- [SLNode.java](src/arraybased-stack-queue/SLNode.java)
- [DLNode.java](src/arraybased-stack-queue/DLNode.java)
- [Queue.java](src/arraybased-stack-queue/Queue.java)

---






---

#### Deque(sequential-based, double linked-list)

![Deque](image/deque_extends_queue.png)

**Deque**: 称之为double-ended queue；可以在队列两段进行插入和删除操作

> Deque继承Queue，比Queue增加的功能为可以任意的一端进行插入和删除操作

操作：

- back() : 得到Collection的back element
- clear() : 清空Collection
- front() : 得到Collection的front element
- insertBack() : 插入元素为back element
- insertFront() : 插入元素为front element
- removeBack() : 删除back element
- removeFront() : 删除front element
- size() : Collection含有多少个元素

**Implementation**

[Deque.java](src/Deque.java)

**Deque应用**

- web browser's history

---

#### 抽象化Stack、Queue和Deque为LinearLinkedContainer

![linear linked container](image/linear_linked_container.png)

---

#### 抽象化LinkedContainer和ArrayContainer为Container

![array-container linear linked-container](image/array_linear_linked_container.png)

---

#### 进一步抽象化Container

接下来我们要讲解General Binary Tree，由于General Binary Tree是Linked Container，但是不是Linear Linked Container，所以我么有必要将我们的UML模型记性进一步的抽象。

![结构框架](image/dsa_learn_scheme.png "结构框架")

**Container-ArrayContiner部分**

![container arrayContainer](image/container_arrayContainer.png)

*源代码*

[Container.java](src/generalize/Container.java)

[ArrayContainer.java](src/generalize/ArrayContainer.java)

[Vector.java](src/generalize/Vector.java)

[FixedVector.java](src/generalize/FixedVector.java)

[DynamicVector.java](src/generalize/DynamicVector.java)

[Heap.java](src/generalize/Heap.java)

[MaxHeap.java](src/generalize/MaxHeap.java)

[MinHeap.java](src/generalize/MinHeap.java)

**Container-LinkedContainer部分**

![Container linkedContainer](image/container_linkedContainer.png)

**源代码**

[LinkedContainer.java](src/generalize/LinkedContainer.java)

[LinearLinkedContainer.java](src/generalize/LinearLinkedContainer.java)

[Stack.java](src/generalize/Stack.java)

[Queue.java](src/generalize/Queue.java)

[Deque.java](src/generalize/Deque.java)

[TreeContainer.java](src/generalize/TreeContainer.java)

[BinaryTree.java](src/generalize/BinaryTree.java)

[BinarySearchTree.java](src/generalize/BinarySearchTree.java)

---

#### General Binary Tree

![binary tree](image/binary_tree.png)

操作:

- clear() : 清空Collection
- height() : 二叉树的高度
- inorderTraverse() : 中序遍历
- postorderTraverse() : 后序遍历
- preorderTraverse() : 前序遍历
- size() : Collection中包含的元素的多少

**Implementation**

> 此时我们已经建立的完全的抽象模型，实现也是基于模型进行。

[TreeContainer.java](src/generalize/TreeContainer.java)

[BinaryTree.java](src/generalize/BinaryTree.java)

**BinaryTree的应用**

- Huffman coding
- Expression Tree

---

#### BinarySearchTree(BST)

![binary search tree](image/binary_search_tree.png)

**BST**: 是一个绝对有序的二叉树(totally ordered binary tree)。绝对有序指的是：一个node的leftChild的data小于node的data；node的rightChild的data大于或者等于node的data。

操作：

- clear() : 清除Collection
- find(element) : 查找指定的element
- inorderTraverse(processor) : 中序遍历
- insert(element) : 插入element到Collection中
- isEmpty() : 判断Collection是否为空
- maximum() : 得到Collection的最大element
- minimum() : 得到Collection的最小element
- postorderTraverse(processor) : 后序遍历
- predecessor(element) : get the inorder predecessor of the given element
- preorderTraverse(processor) : 前序遍历
- remove(element) : 从Collection中删除指定的element
- successor() : get the inorder successor of the given element

**Implementation**

[BinarySearchTree.java](src/generalize/BinarySearchTree.java)

**BST应用**

- dictionary

---

<center>End</center>

---
