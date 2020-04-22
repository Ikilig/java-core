package dataStuctures.linkedList;


import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        // 测试
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(5, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(7, "林冲", "豹子头");
        HeroNode heroNode5 = new HeroNode(2, "黄忠", "及时雨");
        HeroNode heroNode6 = new HeroNode(4, "李元芳", "玉麒麟");
        HeroNode heroNode7 = new HeroNode(6, "张飞", "智多星");
        HeroNode heroNode8 = new HeroNode(8, "鲁班", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);

        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList2.addByOrder(heroNode5);
        singleLinkedList2.addByOrder(heroNode6);
        singleLinkedList2.addByOrder(heroNode7);
        singleLinkedList2.addByOrder(heroNode8);
//        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.list();
        singleLinkedList2.list();

//        // 测试修改节点的代码
//        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
//        singleLinkedList.update(newHeroNode);
//        // 修改后的链表
//        singleLinkedList.list();
//
//        singleLinkedList.del(1);
//        System.out.println("删除后的链表~~");
//        singleLinkedList.list();
//
//        // 测试获取链表节点个数
//        System.out.println(getLength(singleLinkedList.getHead()));
//
//        // 测试是否找到了倒数第k个节点
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
//        System.out.println("res = " + res);

        // 链表反转
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();
//
//        // 逆序打印
//        reversePrint(singleLinkedList.getHead());
//        singleLinkedList.list();
        // 合并两个有序链表
        HeroNode mergeList = mergeOrderedLinkedList(singleLinkedList.getHead(), singleLinkedList2.getHead());
//        System.out.println(mergeList);
        HeroNode t = mergeList.getNext();
        while (t != null) {
            System.out.println(t);
            t = t.getNext();
        }
    }

    /**
     * 获取单链表的节点个数，不包括头节点
     * @param head
     * @return
     */
    public static int getLength(HeroNode head) {
        if (head.getNext() == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.getNext();
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第k个节点【新浪面试题】
     * @param head
     * @param index
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.getNext() == null) {
            return null;
        }
        int size =  getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.getNext();
        for (int i = 0; i < size - index; i++) {
            cur = cur.getNext();
        }
        return cur;
    }

    /**
     * 单链表反转【腾讯面试题】
     * @param head
     */
    public static void reverseList(HeroNode head) {
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        HeroNode cur = head.getNext();
        HeroNode next = null; // 指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(reverseHead.getNext()); // 将当前节点的下一个节点指向新链表的第一个节点（非头节点），这样，就将先放入新链表的节点排到了后放入节点的后面
            reverseHead.setNext(cur);  // 将当前节点放入新链表的第一个节点中
            cur = next;
        }
        head.setNext(reverseHead.getNext());
    }

    /**
     * 逆序打印【百度面试题】
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head.getNext() == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.getNext();
        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序单链表
     * @param head1
     * @param head2
     * @return
     */
    public static HeroNode mergeOrderedLinkedList(HeroNode head1, HeroNode head2) {
        HeroNode mergeList = new HeroNode(0, "", "");
        HeroNode temp = mergeList;
        HeroNode temp1 = head1.getNext();
        HeroNode temp2 = head2.getNext();
        while (temp1 != null && temp2 != null) {
            if (temp1.getNo() > temp2.getNo()) {
                temp.setNext(temp2);
                temp = temp.getNext();
                temp2 = temp2.getNext();
            }
            if (temp1.getNo() < temp2.getNo()) {
                temp.setNext(temp1);
                temp = temp.getNext();
                temp1 = temp1.getNext();
            }
        }
        temp.setNext(temp1!=null?temp1:temp2);
        return mergeList;
    }
}


// 定义SingleLinkedList, 管理HeroNode
class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        // 判断flag
        if (flag) {
            System.out.printf("编号%d已经存在\n", heroNode.getNo());
        } else {
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    public void update(HeroNode heroNode) {
        if (head.getNext() == null) {
            System.out.println("链表为空~~");
            return;
        }

        HeroNode temp = head.getNext();
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setName(heroNode.getName());
            temp.setNickname(heroNode.getNickname());
        } else {
            System.out.printf("没有找到编号%d\n", heroNode.getNo());
        }
    }

    // 删除节点
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.printf("要删除的%d节点不存在\n", no);
        }
    }

    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private String nickname;
    private HeroNode next;

    // 构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
}