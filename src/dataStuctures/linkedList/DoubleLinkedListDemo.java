package dataStuctures.linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("双向链表测试~~");

        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(3, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(5, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(7, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(7, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况:");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表:");
        doubleLinkedList.list();

        HeroNode2 heroNode5 = new HeroNode2(2, "宋江", "及时雨");
        HeroNode2 heroNode6 = new HeroNode2(4, "卢俊义", "玉麒麟");
        HeroNode2 heroNode7 = new HeroNode2(6, "吴用", "智多星");
        HeroNode2 heroNode8 = new HeroNode2(8, "林冲", "豹子头");
        doubleLinkedList.addByOrder(heroNode8);
        doubleLinkedList.addByOrder(heroNode7);
        doubleLinkedList.addByOrder(heroNode6);
        doubleLinkedList.addByOrder(heroNode5);
        doubleLinkedList.list();
    }
}//

// 创建一个双向链表的类
class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }

    public void update(HeroNode2 heroNode) {
        if (head.getNext() == null) {
            System.out.println("链表为空~~");
            return;
        }

        HeroNode2 temp = head.getNext();
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

    public void del(int no) {
        if (head.getNext() == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.getNext();
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
            temp.getPre().setNext(temp.getNext());
        } else {
            System.out.printf("要删除的%d节点不存在\n", no);
        }
    }

    public void addByOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
            } else if (temp.getNo() == heroNode.getNo()) {
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
            heroNode.setPre(temp);
            if (temp.getNext() != null) {
                temp.getNext().setPre(heroNode);
            }
            temp.setNext(heroNode);
        }
    }
}

class HeroNode2 {
    private int no;
    private String name;
    private String nickname;
    private HeroNode2 next;
    private HeroNode2 pre;

    // 构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
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

    public HeroNode2 getNext() {
        return next;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }
}
